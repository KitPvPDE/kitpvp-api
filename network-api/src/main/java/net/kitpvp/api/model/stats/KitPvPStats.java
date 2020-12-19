package net.kitpvp.api.model.stats;

import net.kitpvp.api.utils.ArrayUtils;
import net.kitpvp.stats.keys.StatsKey;
import net.kitpvp.stats.keys.numeric.IntStatsKey;
import net.kitpvp.stats.keys.numeric.LongStageKey;
import net.kitpvp.stats.keys.numeric.LongStatsKey;

import java.util.Set;
import java.util.function.Function;

public interface KitPvPStats {

    // KitPvP
    Set<String> PATHS = ArrayUtils.asSet("air", "army",
            "beam", "fire", "healer", "shockwave", "soldier", "undead", "weather");

    IntStatsKey<String> KITPVP_PATH_EXP =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("paths").function(StatsKey.STRING_KEY).suffix("exp")).build();
    IntStatsKey<String> KITPVP_PATH_LEVEL =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("paths").function(StatsKey.STRING_KEY).suffix("level")).build();
    LongStageKey<String> KITPVP_KILLS_WITH_KIT =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.STRING_KEY).suffix("kills")).stage();
    LongStageKey<String> KITPVP_DEATHS_WITH_KIT =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.STRING_KEY).suffix("deaths")).stage();
    LongStageKey<String> KITPVP_KILLSTREAK_WITH_KIT =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.STRING_KEY).suffix("killstreak")).stage();
    LongStageKey<String> KITPVP_SPECIAL_ACTION_WITH_KIT =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("kitpvp.stats.").function(StatsKey.STRING_KEY).suffix("value")).stage();

}
