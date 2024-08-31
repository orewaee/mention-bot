package dev.orewaee.config;

import java.util.Map;
import java.util.Set;

public class Config {
    private Set<Long> superusers;
    private Long chat;
    private Map<String, Mention> mentions;


    public Set<Long> getSuperusers() {
        return superusers;
    }

    public void setSuperusers(Set<Long> superusers) {
        this.superusers = superusers;
    }

    public Long getChat() {
        return chat;
    }

    public void setChat(Long chat) {
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
        return String.format("Config[superusers=%s chat=%s mentions=%s]", superusers, chat, mentions);
    }
}
