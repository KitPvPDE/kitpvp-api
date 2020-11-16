package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.array.ArraySStatsKey;
import net.kitpvp.stats.keys.array.ArrayStatsKey;
import net.kitpvp.stats.keys.numeric.*;
import org.bson.Document;

import java.util.function.Function;

import static net.kitpvp.stats.api.functions.keys.KeyFunctions.*;

public interface MMStats {

    IntSSeasonKey ELO =
            IntSStatsKey.builder().keyBuilder(builder -> builder.path("1vs1.elo.normal")).offset(1000).season();
    IntSeasonKey<String> LEGACY_ELO =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(Function.identity()).suffix("elo")).offset(1000).season();
    IntSSeasonKey SUMO =
            IntSStatsKey.builder().keyBuilder(builder -> builder.path("1vs1.elo.sumo")).offset(1000).season();
    IntStageKey<String> PLAYED_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(Function.identity()).suffix("playedMatches")).stage();
    IntStageKey<String> WON_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(Function.identity()).suffix("wonMatches")).stage();
    IntStageKey<String> LOST_MATCHES =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(Function.identity()).suffix("lostMatches")).stage();
    IntStageKey<String> KILLS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(Function.identity()).suffix("kills")).stage();
    IntStageKey<String> DEATHS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("1vs1").function(Function.identity()).suffix("deaths")).stage();
    SStatsKey<String> KIT_SELECTED =
            null;
    IntSStatsKey KIT_INDEX =
            null;
    ArraySStatsKey<Document> KITS =
            null;
    ArraySStatsKey<String> PREVIOUS_OPPONENTS =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.function(alltime(immutable("1vs1.previous.opponents")))).build();
    ArraySStatsKey<String> BANNED_KITS =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.function(alltime(immutable("1vs1.banned.kits")))).build();
    ArrayStatsKey<String, String> BANNED_MAPS =
            ArrayStatsKey.<String, String>builder().keyBuilder(builder -> builder.function(alltime(prepend("1vs1.banned.maps", Function.identity())))).build();
    IntSStatsKey PREVIOUS_OPPONENTS_STREAK =
            IntSStatsKey.builder().keyBuilder(builder -> builder.function(alltime(immutable("1vs1.previous.streak")))).build();
}
