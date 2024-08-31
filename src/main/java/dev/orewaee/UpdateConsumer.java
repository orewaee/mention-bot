package dev.orewaee;

import java.util.StringJoiner;

import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import dev.orewaee.config.Config;
import dev.orewaee.config.ConfigManager;
import dev.orewaee.config.Mention;

public class UpdateConsumer implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient client;
    private final ConfigManager configManager;

    public UpdateConsumer(TelegramClient client, ConfigManager configManager) {
        this.client = client;
        this.configManager = configManager;
    }

    @Override
    public void consume(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) return;

        Message message = update.getMessage();
        long chatId = message.getChatId();
        long userId = message.getFrom().getId();

        if (message.getText().equals("/info")) {
            try {
                client.execute(SendMessage.builder()
                    .chatId(chatId)
                    .text(String.format("This chat id: `%d`\nYour id: `%d`", chatId, message.getFrom().getId()))
                    .parseMode(ParseMode.MARKDOWN)
                    .build());
            } catch (TelegramApiException exception) {
                exception.printStackTrace(System.err);
            }

            return;
        }

        Config config = configManager.getConfig();
        if (chatId != config.getChat().getId()) return;

        String text = message.getText();
        if (!text.startsWith("/")) return;
        text = text.trim().toLowerCase().substring(1);

        if (!config.getMentions().containsKey(text)) return;

        Mention mention = config.getMentions().get(text);
        if (mention == null) return;
        if (!mention.getWhitelist().contains(userId)) return;

        StringJoiner names = new StringJoiner(" ");
        for (String name : mention.getNames()) names.add("@" + name);

        try {
            client.execute(SendMessage.builder()
                .chatId(chatId)
                .text(names + "")
                .build());
        } catch (TelegramApiException exception) {
            exception.printStackTrace(System.err);
        }
    }
}
