package dev.orewaee.config;

import java.util.List;

public class Chat {
    private Long id;
    private List<Long> admins;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Long> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        return String.format("Chat[id=%d admins=%s]", id, admins);
    }
}
