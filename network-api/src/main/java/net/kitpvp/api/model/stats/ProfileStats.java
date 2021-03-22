package net.kitpvp.api.model.stats;

import net.kitpvp.stats.keys.*;

import java.util.UUID;
import java.util.function.Function;

public interface ProfileStats {

    VoidStatsKey<String> PROFILE_NAME = VoidStatsKey.<String>builder().defaultValue((String) null).keyBuilder(builder -> builder.path("name")).build();
    VoidStatsKey<String> PROFILE_NAME_LOWERCASE = VoidStatsKey.<String>builder().defaultValue((String) null).keyBuilder(builder -> builder.path("lowername")).build();
    VoidStatsKey<String> PROFILE_GROUP = VoidStatsKey.<String>builder().defaultValue("default").keyBuilder(builder -> builder.path("group")).build();
    VoidStatsKey<String> PROFILE_ADDRESS = VoidStatsKey.<String>builder().defaultValue((String) null).keyBuilder(builder -> builder.path("address")).build();
    LongVoidStatsKey PROFILE_BALANCE = LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("balance")).build();
    LongVoidStatsKey PROFILE_LEVEL = LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("level")).offset(1).build();
    LongVoidStatsKey PROFILE_LEGACY_LEVEL = LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("legacyLevel")).offset(1).build();
    LongVoidStatsKey PROFILE_LOGINS = LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("logins")).build();
    LongVoidStatsKey PROFILE_LAST_ONLINE = LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("timestamp")).build();
    DoubleVoidStatsKey PROFILE_EXP = DoubleVoidStatsKey.builder().keyBuilder(builder -> builder.path("exp")).build();

    ArrayVoidStatsKey<UUID> PROFILE_BLOCKED =
            ArrayVoidStatsKey.<UUID>builder().keyBuilder(builder -> builder.path("blocked")).build();
    ArrayVoidStatsKey<String> PROFILE_TITLES =
            ArrayVoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("titles")).build();
    ArrayVoidStatsKey<String> PROFILE_PERMISSIONS =
            ArrayVoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("permissions")).build();
    ArrayVoidStatsKey<String> PROFILE_PAST_ADDRESS =
            ArrayVoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("addresses")).build();
    StatsKey<String, String> PROFILE_SETTINGS =
            StatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("settings").function(Function.identity()).
                    inverse(Function.identity())).defaultValue("").build();
    StatsKey<String, String> PROFILE_SERVER_GROUP =
            StatsKey.<String, String>builder().keyBuilder(builder -> builder.prefix("groups").function(Function.identity()).inverse(Function.identity())).defaultValue("default").build();


}
