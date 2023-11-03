package dev.orewaee;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import dev.orewaee.commands.SetCommand;
import dev.orewaee.managers.MentionManager;

public class MentionsBot extends TelegramLongPollingCommandBot {
    public MentionsBot(String botToken) {
        super(botToken);

        register(new SetCommand());
    }

    @Override
    public void processNonCommandUpdate(Update update) {
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

        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(mentions);

        try {
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
