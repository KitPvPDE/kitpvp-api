package net.kitpvp.api.setting;

import net.kitpvp.pluginapi.modules.stats.TSetting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ScoreboardSetting implements TSetting {

    ENABLED("scoreboardEnabled", "true", "false"),
    SHOW_RANK_COLOR("scoreboardRankColor", "true", "false"),
    SHOW_ALLTIME_STATS("scoreboardAlltimeStats", "false", "true"),
    ;

    private final String settingsKey, settingsDefault;
    private final List<String> settingsValues;

    ScoreboardSetting(String settingsKey, String settingsDefault, String... settingsValues) {
        this.settingsKey = settingsKey;
        this.settingsDefault = settingsDefault;
        this.settingsValues = new ArrayList<>();
        this.settingsValues.add(settingsDefault);
        this.settingsValues.addAll(Arrays.asList(settingsValues));
    }

    @Override
    public boolean isLocal() {
        return true;
    }

    @Override
    public String getSettingsKey() {
        return settingsKey;
    }

    @Override
    public String getSettingsDefault() {
        return settingsDefault;
    }

    public List<String> settingsValues() {
        return this.settingsValues;
    }
}
