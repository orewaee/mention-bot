package dev.orewaee.config;

import java.util.List;

public class Config {
    private Chat chat;
    private List<Mention> mentions;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public List<Mention> getMentions() {
        return mentions;
    }

    public void setMentions(List<Mention> mentions) {
        this.mentions = mentions;
    }

    @Override
    public String toString() {
        return String.format("Config[chat=%s mentions=%s]", chat, mentions);
    }
}
