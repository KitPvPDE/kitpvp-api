package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.numeric.IntStatsKey;
import net.kitpvp.stats.keys.numeric.LongStageKey;
import net.kitpvp.stats.keys.numeric.LongStatsKey;

import java.util.function.Function;

public interface KitPvPStats {

    // KitPvP

    IntStatsKey<String> KITPVP_PATH_EXP =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("paths").function(Function.identity()).suffix("exp")).build();
    IntStatsKey<String> KITPVP_PATH_LEVEL =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("paths").function(Function.identity()).suffix("level")).build();
    LongStageKey<String> KITPVP_KILLS_WITH_KIT =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("kitpvp.kills").function(Function.identity())).stage();
    LongStageKey<String> KITPVP_DEATHS_WITH_KIT =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("kitpvp.deaths").function(Function.identity())).stage();
}
