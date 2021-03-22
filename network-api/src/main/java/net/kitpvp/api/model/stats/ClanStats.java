package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.ArrayVoidStatsKey;
import net.kitpvp.stats.keys.StatsKey;
import net.kitpvp.stats.keys.VoidStatsKey;

import java.util.function.Function;

public interface ClanStats {

    VoidStatsKey<String> NAME =
            VoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("name")).defaultValue("").build();
    VoidStatsKey<String> DESCRIPTION =
            VoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("description")).defaultValue("").build();
    StatsKey<String, String> USER_GROUP =
            StatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("users").function(Function.identity()).inverse(Function.identity())).defaultValue("").build();
    ArrayVoidStatsKey<String> INVITES =
            ArrayVoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("invites")).build();

}
