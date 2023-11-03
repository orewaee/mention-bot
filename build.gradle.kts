plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "dev.orewaee"
version = "1.1.0"

application {
    mainClass = "dev.orewaee.Main"
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.telegram:telegrambots:6.8.0")
    implementation("org.telegram:telegrambotsextensions:6.8.0")
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    shadowJar {
        archiveFileName.set("MentionsBot-$version.jar")
    }
}
