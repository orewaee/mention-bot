package dev.orewaee.config;

import java.util.List;

public class Mention {
    // private String name;
    private List<String> names;
    private List<Long> whitelist;

    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    */

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<Long> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(List<Long> whitelist) {
        this.whitelist = whitelist;
    }

    @Override
    public String toString() {
        return String.format("Mention[name=%s names=%s whitelist=%s]", "123", names, whitelist);
    }
}
