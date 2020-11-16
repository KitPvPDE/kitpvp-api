package net.kitpvp.api.model.stats;

import net.kitpvp.api.Warp;
import net.kitpvp.api.heads.HeadRarity;
import net.kitpvp.api.utils.EnumUtils;
import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.array.ArraySStatsKey;
import net.kitpvp.stats.keys.numeric.*;

import java.util.Objects;
import java.util.function.Function;

import static net.kitpvp.stats.api.functions.keys.KeyFunctions.alltime;
import static net.kitpvp.stats.api.functions.keys.KeyFunctions.immutable;

public interface Stats {

    LongSStageKey ONLINE_TIME =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("online")).stage();
    LongSStageKey AFK_TIME =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("afk")).stage();
    LongSStatsKey LEVEL =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("level")).build();
    DoubleSStatsKey EXP =
            DoubleSStatsKey.builder().keyBuilder(builder -> builder.path("exp")).build();
    LongSStatsKey BALANCE =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("credits")).build();
    SStatsKey<String> MONGO_ID =
            SStatsKey.<String>builder().keyBuilder(builder -> builder.path("_id")).defaultValue((String) null).build();
    LongSStageKey KILLS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("global.kills")).stage();
    LongSStageKey DEATHS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("global.deaths")).stage();
    LongSStatsKey KILLSTREAK =
            LongSStatsKey.builder().keyBuilder(builder -> builder.function(alltime(immutable("global.killstreak.current")))).build();
    LongSStageKey KILLSTREAK_RECORD =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("global.killstreak.record")).stage();
    LongSStageKey CLEAN_KILLS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("cleanKills.global")).stage();
    LongStageKey<Warp> KILLS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("kills").function(EnumUtils::nameToLowercase)).stage();
    LongStageKey<Warp> DEATHS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("deaths").function(EnumUtils::nameToLowercase)).stage();
    LongStageKey<Warp> CLEAN_KILLS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("cleanKills").function(EnumUtils::nameToLowercase)).stage();
    LongStageKey<String> KILLS_WITH_KIT =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("killsWithKit").function(Function.identity())).stage();
    ArraySStatsKey<String> TITLES =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("titles")).build();

    // Heads
    LongStageKey<HeadRarity> HEADS_RECEIVED =
            LongStatsKey.<HeadRarity>builder().keyBuilder(builder -> builder.prefix("heads.received").function(EnumUtils::nameToLowercase)).stage();

    // Events

    LongStageKey<String> EVENT_TAKEN_PART =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Function.identity()).suffix("participated")).stage();
    LongStageKey<String> EVENT_WINS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Function.identity()).suffix("won")).stage();
    LongStageKey<String> EVENT_KILLS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Function.identity()).suffix("kills")).stage();
    LongStageKey<String> EVENT_DEATHS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Function.identity()).suffix("deaths")).stage();
    LongSStageKey GLOBAL_EVENT_TAKEN_PART =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.participated")).stage();
    LongSStageKey GLOBAL_EVENT_WINS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.won")).stage();
    LongSStageKey GLOBAL_EVENT_KILLS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.kills")).stage();
    LongSStageKey GLOBAL_EVENT_DEATHS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.deaths")).stage();


    // Training
    IntStageKey<String> TRAINING_ITERATIONS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Function.identity()).suffix("tries")).stage();
    IntStageKey<String> TRAINING_COMPLETED =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Function.identity()).suffix("completed")).stage();
    LongStageKey<String> TRAINING_RECORD =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Function.identity()).suffix("record")).stage();

    // KitPvP

    IntStatsKey<String> KITPVP_PATH_EXP =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("alltime.kitpvp.paths").function(Function.identity()).suffix("exp")).build();
    IntStatsKey<String> KITPVP_PATH_LEVEL =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("alltime.kitpvp.paths").function(Function.identity()).suffix("level")).build();

    // Misc
    LongSStageKey MISC_SOUPS_EATEN =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("misc.soupsEaten")).stage();
    LongSStageKey MISC_BLOCKS_WALKED =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("misc.blocksWalked")).stage();
    IntStatsKey<Integer> MISC_VOTINGS =
            IntStatsKey.<Integer>builder().keyBuilder(builder -> builder.prefix("misc.votings").function(Objects::toString)).def(-1).build();
    SStatsKey<String> API_KEY =
            SStatsKey.<String>builder().keyBuilder(builder -> builder.path("misc.website.apiKey")).defaultValue("").build();
    ArraySStatsKey<Long> ACHIEVEMENTS =
            ArraySStatsKey.<Long>builder().keyBuilder(builder -> builder.path("misc.achievements")).build();

}
