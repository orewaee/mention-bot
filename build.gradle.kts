plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "dev.orewaee"
version = "2.0.0"

application {
    mainClass = "dev.orewaee.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.telegrambots.longpolling)
    implementation(libs.telegrambots.client)
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release = 21
    }

    shadowJar {
        archiveFileName = "${rootProject.name}-$version.jar"
    }
}
