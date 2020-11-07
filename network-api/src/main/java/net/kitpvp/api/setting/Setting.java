package net.kitpvp.api.setting;

import net.kitpvp.stats.settings.TSetting;

import java.util.Arrays;
import java.util.List;

public enum Setting implements TSetting {

    TITLE_FORCED_OFF("titleForcedOff", false)
    ;

    private final String key, def;
    private final List<String> values;

    Setting(String key, boolean def) {
        this.key = key;
        this.def = "" + def;
        this.values = Arrays.asList("true", "false");
    }

    public String getKey() {
        return this.key;
    }

    @Override
    public String getDefault() {
        return this.def;
    }

    public List<String> getValues() {
        return this.values;
    }

    @Override
    public final String next(String current) {
        if(this.values.isEmpty())
            throw new IllegalArgumentException("Cannot toggle the setting " + this);
        return TSetting.super.next(current);
    }
}
