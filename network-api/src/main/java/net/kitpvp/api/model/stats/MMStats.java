package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.*;

public interface MMStats {

    IntVoidSeasonKey ELO =
            IntVoidStatsKey.builder().keyBuilder(builder -> builder.path("1vs1.elo.normal")).offset(1000).season();
    IntSeasonKey<String> LEGACY_ELO =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(StatsKey.STRING_KEY).suffix("elo")).offset(1000).season();
    IntVoidSeasonKey SUMO =
            IntVoidStatsKey.builder().keyBuilder(builder -> builder.path("1vs1.elo.sumo")).offset(1000).season();
    IntStageKey<String> PLAYED_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("playedMatches")).stage();
    IntStageKey<String> WON_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("wonMatches")).stage();
    IntStageKey<String> LOST_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("lostMatches")).stage();
    IntStageKey<String> KILLS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("kills")).stage();
    IntStageKey<String> DEATHS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("deaths")).stage();
    IntStageKey<String> PLAYED_MATCHES_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("playedMatches")).stage();
    IntStageKey<String> WON_MATCHES_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("wonMatches")).stage();
    IntStageKey<String> LOST_MATCHES_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("lostMatches")).stage();
    IntStageKey<String> KILLS_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("kills")).stage();
    IntStageKey<String> DEATHS_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("deaths")).stage();
    IntStageKey<String> WINS_AGAINST_BOT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.bot").function(StatsKey.STRING_KEY).suffix("wins")).stage();
    ArrayVoidStatsKey<String> PREVIOUS_OPPONENTS =
            ArrayVoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("alltime.1vs1.previous.opponents")).build();
    ArrayVoidStatsKey<String> BANNED_KITS =
            ArrayVoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("alltime.1vs1.banned.kits")).build();
    ArrayStatsKey<String, String> BANNED_MAPS =
            ArrayStatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("alltime.1vs1.banned.maps").function(StatsKey.STRING_KEY)).build();
    IntVoidStatsKey PREVIOUS_OPPONENTS_STREAK =
            IntVoidStatsKey.builder().keyBuilder(builder -> builder.path("alltime.1vs1.previous.streak")).build();
}
