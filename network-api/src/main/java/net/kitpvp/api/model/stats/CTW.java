package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.numeric.IntSStageKey;
import net.kitpvp.stats.keys.numeric.IntSStatsKey;

public interface CTW {
    IntSStageKey KILLS = IntSStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.kills")).
            stage();
    IntSStageKey DEATHS = IntSStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.deaths")).
            stage();
    IntSStageKey WOOLS = IntSStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.wools")).
            stage();
    IntSStageKey POINTS = IntSStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.points")).
            stage();
}
