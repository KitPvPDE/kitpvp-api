package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.StatsKey;
import net.kitpvp.stats.keys.array.ArraySStatsKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface ClanStats {

    SStatsKey<String> NAME =
            SStatsKey.<String>builder().keyBuilder(builder -> builder.path("name")).defaultValue("").build();
    SStatsKey<String> DESCRIPTION =
            SStatsKey.<String>builder().keyBuilder(builder -> builder.path("description")).defaultValue("").build();
    StatsKey<String, String> USER_GROUP =
            StatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("users").function(Function.identity())).defaultValue("").build();
    ArraySStatsKey<String> INVITES =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("invites")).build();

}
