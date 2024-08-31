package dev.orewaee.config;

import java.util.List;
import java.util.Map;

public class Config {
    private Chat chat;
    private Map<String, Mention> mentions;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Map<String, Mention> getMentions() {
        return mentions;
    }

    public void setMentions(Map<String, Mention> mentions) {
        this.mentions = mentions;
    }

    @Override
    public String toString() {
        return String.format("Config[chat=%s mentions=%s]", chat, mentions);
    }
}
