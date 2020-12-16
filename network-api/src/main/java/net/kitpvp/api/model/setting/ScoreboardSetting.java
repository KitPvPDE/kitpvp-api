package net.kitpvp.api.model.setting;

import net.kitpvp.stats.settings.impl.TrueFalseSetting;

import static net.kitpvp.api.model.setting.Setting.*;

public interface ScoreboardSetting {

    TrueFalseSetting ENABLED = trueFalse("scoreboardEnabled", true);
    TrueFalseSetting ALLTIME_STATS = trueFalse("scoreboardAlltimeStats", false);
}
