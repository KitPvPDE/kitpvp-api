package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.IntVoidStageKey;
import net.kitpvp.stats.keys.IntVoidStatsKey;

public interface CTW {
    IntVoidStageKey KILLS = IntVoidStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.kills")).
            stage();
    IntVoidStageKey DEATHS = IntVoidStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.deaths")).
            stage();
    IntVoidStageKey WOOLS = IntVoidStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.wools")).
            stage();
    IntVoidStageKey POINTS = IntVoidStatsKey.builder().
            keyBuilder(builder -> builder.path("ctw.points")).
            stage();
}
