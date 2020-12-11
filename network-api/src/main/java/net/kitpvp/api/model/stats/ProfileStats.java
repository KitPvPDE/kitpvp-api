package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.StatsKey;
import net.kitpvp.stats.keys.array.ArraySStatsKey;
import net.kitpvp.stats.keys.numeric.DoubleSStatsKey;
import net.kitpvp.stats.keys.numeric.LongSStatsKey;
import net.kitpvp.stats.keys.set.SetSStatsKey;

import java.util.UUID;
import java.util.function.Function;

public interface ProfileStats {

    SStatsKey<String> PROFILE_NAME = SStatsKey.<String>builder().defaultValue((String) null).keyBuilder(builder -> builder.path("name")).build();
    SStatsKey<String> PROFILE_NAME_LOWERCASE = SStatsKey.<String>builder().defaultValue((String) null).keyBuilder(builder -> builder.path("lowername")).build();
    SStatsKey<String> PROFILE_GROUP = SStatsKey.<String>builder().defaultValue("default").keyBuilder(builder -> builder.path("group")).build();
    SStatsKey<String> PROFILE_ADDRESS = SStatsKey.<String>builder().defaultValue((String) null).keyBuilder(builder -> builder.path("address")).build();
    LongSStatsKey PROFILE_BALANCE = LongSStatsKey.builder().keyBuilder(builder -> builder.path("balance")).build();
    LongSStatsKey PROFILE_LEVEL = LongSStatsKey.builder().keyBuilder(builder -> builder.path("level")).offset(1).build();
    LongSStatsKey PROFILE_LOGINS = LongSStatsKey.builder().keyBuilder(builder -> builder.path("logins")).build();
    LongSStatsKey PROFILE_LAST_ONLINE = LongSStatsKey.builder().keyBuilder(builder -> builder.path("timestamp")).build();
    DoubleSStatsKey PROFILE_EXP = DoubleSStatsKey.builder().keyBuilder(builder -> builder.path("exp")).build();

    ArraySStatsKey<UUID> PROFILE_BLOCKED =
            ArraySStatsKey.<UUID>builder().keyBuilder(builder -> builder.path("blocked")).build();
    ArraySStatsKey<String> PROFILE_TITLES =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("titles")).build();
    ArraySStatsKey<String> PROFILE_PERMISSIONS =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("permissions")).build();
    ArraySStatsKey<String> PROFILE_PAST_ADDRESS =
            ArraySStatsKey.<String>builder().keyBuilder(builder -> builder.path("addresses")).build();
    StatsKey<String, String> PROFILE_SETTINGS =
            StatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("settings").function(Function.identity())).defaultValue("").build();
    StatsKey<String, String> PROFILE_SERVER_GROUP =
            StatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("groups").function(Function.identity())).defaultValue("default").build();


}
