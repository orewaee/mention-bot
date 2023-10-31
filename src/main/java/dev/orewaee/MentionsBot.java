package dev.orewaee;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.StringJoiner;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MentionsBot extends TelegramLongPollingBot {
    public MentionsBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) return;

        Message message = update.getMessage();
        Chat chat = message.getChat();

        boolean isGroupChat = chat.isGroupChat();
        boolean isSuperGroupChat = chat.isSuperGroupChat();

        if (!isGroupChat && !isSuperGroupChat) return;

        if (!message.hasText()) return;

        String text = message.getText();

        if (!text.contains("@all")) return;

        Long chatId = chat.getId();
        String mentions = MentionManager.getInstance().getMentionsByChatId(chatId);

        if (mentions.isEmpty()) return;

        SendMessage sendMessage = new SendMessage();

        try {
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText(mentions);

            execute(sendMessage);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "peepo_clown_bot";
    }
}
