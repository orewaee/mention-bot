package dev.orewaee;

import java.nio.file.Path;
import java.io.IOException;

import org.telegram.telegrambots.meta.generics.TelegramClient;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

import dev.orewaee.config.ConfigManager;
import dev.orewaee.config.YamlConfigManager;

public class Main {
    public static void main(String[] args) throws IOException {
        final String token = System.getenv("TELEGRAM_BOT_TOKEN");

        if (token == null) {
            System.out.println("Environment variable TELEGRAM_BOT_TOKEN is missing");
            return;
        }

        Path path = Path.of("config.yaml");
        ConfigManager configManager = new YamlConfigManager(path);
        configManager.loadConfig();

        try (TelegramBotsLongPollingApplication app = new TelegramBotsLongPollingApplication()) {
            TelegramClient client = new OkHttpTelegramClient(token);
            app.registerBot(token, new UpdateConsumer(client, configManager));
            Thread.currentThread().join();
        } catch (Exception exception) {
            exception.printStackTrace(System.err);
        }
    }
}
