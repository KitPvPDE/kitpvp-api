package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.array.ArraySStatsKey;
import net.kitpvp.stats.keys.array.ArrayStatsKey;
import net.kitpvp.stats.keys.numeric.*;
import org.bson.Document;

import java.util.function.Function;

public interface MMStats {

    IntSSeasonKey ELO =
            IntSStatsKey.builder().keyBuilder(builder -> builder.path("1vs1.elo.normal")).offset(1000).season();
    IntSeasonKey<String> LEGACY_ELO =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(Function.identity()).suffix("elo")).offset(1000).season();
    IntSSeasonKey SUMO =
            IntSStatsKey.builder().keyBuilder(builder -> builder.path("1vs1.elo.sumo")).offset(1000).season();
    IntStageKey<String> PLAYED_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(Function.identity()).suffix("playedMatches")).stage();
    IntStageKey<String> WON_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(Function.identity()).suffix("wonMatches")).stage();
    IntStageKey<String> LOST_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(Function.identity()).suffix("lostMatches")).stage();
    IntStageKey<String> KILLS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(Function.identity()).suffix("kills")).stage();
    IntStageKey<String> DEATHS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.modes").function(Function.identity()).suffix("deaths")).stage();
    IntStageKey<String> PLAYED_MATCHES_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(Function.identity()).suffix("playedMatches")).stage();
    IntStageKey<String> WON_MATCHES_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(Function.identity()).suffix("wonMatches")).stage();
    IntStageKey<String> LOST_MATCHES_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(Function.identity()).suffix("lostMatches")).stage();
    IntStageKey<String> KILLS_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(Function.identity()).suffix("kills")).stage();
    IntStageKey<String> DEATHS_WITH_KIT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.stats").function(Function.identity()).suffix("deaths")).stage();
    IntStageKey<String> WINS_AGAINST_BOT =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1.bot").function(Function.identity()).suffix("wins")).stage();
    ArraySStatsKey<String> PREVIOUS_OPPONENTS =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("alltime.1vs1.previous.opponents")).build();
    ArraySStatsKey<String> BANNED_KITS =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("alltime.1vs1.banned.kits")).build();
    ArrayStatsKey<String, String> BANNED_MAPS =
            ArrayStatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("alltime.1vs1.banned.maps").function(Function.identity())).build();
    IntSStatsKey PREVIOUS_OPPONENTS_STREAK =
            IntSStatsKey.builder().keyBuilder(builder -> builder.path("alltime.1vs1.previous.streak")).build();
}
