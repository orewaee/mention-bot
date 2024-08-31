package dev.orewaee.config;

import java.util.Set;

public class Mention {
    private Set<String> names;
    private Set<Long> whitelist;

    public Set<String> getNames() {
        return names;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }

    public Set<Long> getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(Set<Long> whitelist) {
        this.whitelist = whitelist;
    }

    @Override
    public String toString() {
        return String.format("Mention[names=%s whitelist=%s]", names, whitelist);
    }
}
