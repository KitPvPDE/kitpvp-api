package net.kitpvp.api.setting.settings;

import net.kitpvp.stats.settings.TSetting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PracticeSetting implements TSetting {

    ACTIONBAR_COOLDOWN("actionbarCooldown", "enabled", "disabled"),
    LAST_KIT("lastKit", "none")
    ;

    private final String key, def;
    private final List<String> values;

    PracticeSetting(String key, boolean def) {
        this.key = key;
        this.def = "" + def;
        this.values = Arrays.asList("true", "false");
    }

    PracticeSetting(String key) {
        this.key = key;
        this.def = "";
        this.values = new ArrayList<>();
    }

    PracticeSetting(String key, String def, String... values) {
        this.key = key;
        this.def = def;
        this.values = new ArrayList<>();
        this.values.add(def);
        this.values.addAll(Arrays.asList(values));
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
