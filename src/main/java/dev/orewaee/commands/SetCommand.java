package dev.orewaee.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import dev.orewaee.managers.MentionManager;

public class SetCommand extends BotCommand {
    public SetCommand() {
        super("set", "Sets mentions for channel");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        boolean isGroupChat = chat.isGroupChat();
        boolean isSuperGroupChat = chat.isSuperGroupChat();

        if (!isGroupChat && !isSuperGroupChat) return;

        long chatId = chat.getId();

        MentionManager mentionManager = new MentionManager();

        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);

        mentionManager.setMentionsByChatId(chatId, arguments);

        sendMessage.setText("Success");

        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException exception) {
            exception.printStackTrace();
        }
    }
}
