package net.kitpvp.api.setting.settings;

import net.kitpvp.stats.settings.TSetting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ScoreboardSetting implements TSetting {

    ENABLED("scoreboardEnabled", "true", "false"),
    SHOW_RANK_COLOR("scoreboardRankColor", "true", "false"),
    SHOW_ALLTIME_STATS("scoreboardAlltimeStats", "false", "true"),
    ;

    private final String key, def;
    private final List<String> values;

    ScoreboardSetting(String key, boolean def) {
        this.key = key;
        this.def = "" + def;
        this.values = Arrays.asList("true", "false");
    }

    ScoreboardSetting(String key) {
        this.key = key;
        this.def = "";
        this.values = new ArrayList<>();
    }

    ScoreboardSetting(String key, String def, String... values) {
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
