package dev.orewaee.config;

import java.io.IOException;

import org.jetbrains.annotations.NotNull;

public interface ConfigManager {
    void loadConfig() throws IOException;
    void reloadConfig() throws IOException;
    @NotNull Config getConfig();
}
