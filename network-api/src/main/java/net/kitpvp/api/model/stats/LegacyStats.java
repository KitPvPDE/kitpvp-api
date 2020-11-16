package net.kitpvp.api.model.stats;

import net.kitpvp.stats.StatKeys;
import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.StatsKey;
import net.kitpvp.stats.keys.array.ArraySStatsKey;
import net.kitpvp.stats.keys.array.ArrayStatsKey;
import net.kitpvp.stats.keys.numeric.*;

import java.util.function.Function;

public interface LegacyStats {

    ArraySStatsKey<Long> ACHIEVEMENT_LIST_KEY =
            ArraySStatsKey.<Long>builder().keyBuilder(builder -> builder.path("achievements")).build();
    ArraySStatsKey<String> TITLES_KEY =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("titles")).build();
    StatsKey<String, String> SETTINGS_KEY =
            StatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("misc.settings").function(Function.identity())).defaultValue("").build();

    ArraySStatsKey<String> BLOCKED_PLAYERS =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("misc.blocked")).build();

    LongSStatsKey BALANCE =
            StatKeys.newStatsKey("credits", 0L);
    LongSStatsKey KITPVP_LEVEL =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("level")).offset(1).build();
    DoubleSStatsKey KITPVP_EXP =
            DoubleSStatsKey.builder().keyBuilder(builder -> builder.path("exp")).build();

    // KITPVP
    LongSSeasonKey KITPVP_KILLS =
            StatKeys.newSeasonKey("kitpvp.kills", 0L);
    LongSSeasonKey KITPVP_DEATHS =
            StatKeys.newSeasonKey("kitpvp.deaths", 0L);
    LongSSeasonKey ONLINE_TIME =
            StatKeys.newSeasonKey("online", 0L);
    LongSeasonKey<String> KITPVP_WARP_KILLS =
            StatKeys.newSeasonKey("kitpvp.kits.warps", String::toLowerCase, null, 0L);
    LongSeasonKey<String> KITPVP_KIT_KILLS =
            StatKeys.newSeasonKey("kitpvp.kits.kills", String::toLowerCase, null, 0L);
    LongSeasonKey<String> KITPVP_KIT_KILLSTREAKS =
            StatKeys.newSeasonKey("kitpvp.kits.streaks", String::toLowerCase, null, 0L);
    SStatsKey<Long> KITPVP_SAVED_KILLSTREAK =
            StatKeys.newStatsKey("kitpvp.saved.killstreak", 0L);
    LongStatsKey<String> KITPVP_PATH_EXP =
            StatKeys.newStatsKey("kits.paths", Function.identity(), "exp", 0L);
    LongStatsKey<String> KITPVP_PATH_SELECTED_LEVEL =
            StatKeys.newStatsKey("kits.paths", Function.identity(), "selected", 0);
    StatsKey<String, Long> KITPVP_EVENT_WINS =
            StatKeys.newStatsKey("misc.events", Function.identity(), "wins", 0L);
    StatsKey<String, Long> KITPVP_EVENT_KILLS =
            StatKeys.newStatsKey("misc.events", Function.identity(), "kills", 0L);
    StatsKey<String, Long> KITPVP_EVENT_DEATHS =
            StatKeys.newStatsKey("misc.events", Function.identity(), "deaths", 0L);
    LongSSeasonKey KITPVP_KILLSTREAK_RECORD =
            StatKeys.newSeasonKey("kitpvp.records.killstreak", 0L);

    // MATCHMAKING
    IntSeasonKey<String> PLAYED_MATCHES =
            StatKeys.newSeasonKey("1vs1", Function.identity(), "playedMatches", 0);
    IntSeasonKey<String> WON_MATCHES =
            StatKeys.newSeasonKey("1vs1", Function.identity(), "wonMatches", 0);
    IntSeasonKey<String> LOST_MATCHES =
            StatKeys.newSeasonKey("1vs1", Function.identity(), "lostMatches", 0);
    IntSeasonKey<String> MATCHMAKING_KILLS =
            StatKeys.newSeasonKey("1vs1", Function.identity(), "kills", 0);
    IntSeasonKey<String> MATCHMAKING_DEATHS =
            StatKeys.newSeasonKey("1vs1", Function.identity(), "deaths", 0);
    ArraySStatsKey<String> MATCHMAKING_BANNED_KITS =
            StatKeys.newListKey("misc.1vs1.bannedKits");
    ArrayStatsKey<String, String> MATCHMAKING_BANNED_MAPS =
            StatKeys.newListKey("misc.1vs1.bannedMaps", Function.identity(), null);
    ArraySStatsKey<String> MATCHMAKING_LAST_OPPONENTS =
            StatKeys.newListKey("misc.1vs1.previousOpponents");
    IntSStatsKey MATCHMAKING_LAST_OPPONENTS_STREAK =
            StatKeys.newStatsKey("misc.1vs1.previousOpponentsStreak", 0);

    // TRAINING
    StatsKey<String, Long> TRAINING_RECORDS =
            StatKeys.newStatsKey("alltime.training", Function.identity(), "record", -1L);
    StatsKey<String, Long> TRAINING_ITERATIONS =
            StatKeys.newStatsKey("alltime.training", Function.identity(), "tries", 0L);
    StatsKey<String, Long> TRAINING_STREAK =
            StatKeys.newStatsKey("alltime.training", Function.identity(), "streak", 0L);

    // MISC
    SStatsKey<Long> WALKED_BLOCKS =
            StatKeys.newStatsKey("misc.useless.walked", 0L);
    SStatsKey<Long> SOUPS_EATEN =
            StatKeys.newStatsKey("misc.useless.soups", 0L);
    SStatsKey<Long> AFK_TIME =
            StatKeys.newStatsKey("misc.useless.afk", 0L);
    SStatsKey<Long> JOIN_TIME =
            StatKeys.newStatsKey("misc.useless.joined", -1L);
}
