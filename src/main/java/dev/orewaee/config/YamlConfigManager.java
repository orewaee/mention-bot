package dev.orewaee.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.jetbrains.annotations.NotNull;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlConfigManager implements ConfigManager {
    private final Path path;
    private final Yaml yaml = new Yaml(new Constructor(Config.class, new LoaderOptions()));
    private Config config;

    public YamlConfigManager(Path path) throws IOException {
        this.path = path;
        loadConfig();
    }

    @Override
    public void loadConfig() throws IOException {
        if (!Files.exists(path)) {
            InputStream defaultConfig = this.getClass().getResourceAsStream("/config.yaml");
            if (defaultConfig == null) throw new IOException("The default config was not found in the resources");

            Files.copy(defaultConfig, path);
            defaultConfig.close();

            throw new IOException("A default configuration was loaded that was unsuitable for the bot to work properly");
        }

        InputStream inputStream = Files.newInputStream(path);

        Config config = yaml.load(inputStream);

        inputStream.close();

        this.config = config;
    }

    @Override
    public void reloadConfig() throws IOException {
        loadConfig();
    }

    @Override
    @NotNull
    public Config getConfig() {
        return config;
    }
}
