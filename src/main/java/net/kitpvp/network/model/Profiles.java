package net.kitpvp.network.model;

import net.kitpvp.stats.Key;
import net.kitpvp.stats.keys.*;

import java.util.UUID;

public interface Profiles {

    VoidStatsKey<String> PROFILE_NAME = StatsKey.identity().bind("name");
    VoidStatsKey<String> PROFILE_NAME_LOWERCASE = StatsKey.identity().bind("lowername");
    VoidStatsKey<String> PROFILE_GROUP = VoidStatsKey.<String>builder()
            .defaultValue("default")
            .keyBuilder(voidKeyBuilder -> voidKeyBuilder.path("group"))
            .build();
    VoidStatsKey<String> PROFILE_ADDRESS = StatsKey.identity().bind("address");

    LongVoidStatsKey PROFILE_BALANCE = LongStatsKey.identity().bind("balance");
    LongVoidStatsKey PROFILE_LEVEL = LongVoidStatsKey.builder()
            .offset(1)
            .keyBuilder(voidKeyBuilder -> voidKeyBuilder.path("level"))
            .build();
    LongVoidStatsKey PROFILE_LEGACY_LEVEL = LongVoidStatsKey.builder()
            .offset(1)
            .keyBuilder(voidKeyBuilder -> voidKeyBuilder.path("legacyLevel"))
            .build();
    LongVoidStatsKey PROFILE_LOGINS = LongStatsKey.identity().bind("logins");
    LongVoidStatsKey PROFILE_LAST_ONLINE = LongStatsKey.identity().bind("timestamp");

    DoubleVoidStatsKey PROFILE_EXP = DoubleStatsKey.identity().bind("exp");

    ArrayVoidStatsKey<UUID> PROFILE_BLOCKED = ArrayVoidStatsKey.<UUID>builder()
            .keyBuilder(voidKeyBuilder -> voidKeyBuilder.path("blocked"))
            .build();
    ArrayVoidStatsKey<String> PROFILE_TITLES = ArrayVoidStatsKey.<String>builder()
            .keyBuilder(voidKeyBuilder -> voidKeyBuilder.path("titles"))
            .build();

    ArrayVoidStatsKey<String> PROFILE_PERMISSIONS = ArrayVoidStatsKey.<String>builder()
            .keyBuilder(voidKeyBuilder -> voidKeyBuilder.path("permissions"))
            .build();
    ArrayVoidStatsKey<String> PROFILE_PAST_ADDRESS = ArrayVoidStatsKey.<String>builder()
            .keyBuilder(voidKeyBuilder -> voidKeyBuilder.path("addresses"))
            .build();

    StatsKey<String, String> PROFILE_SETTINGS = StatsKey.<String, String>builder()
            .keyBuilder(stringKeyBuilder -> stringKeyBuilder.prefix("settings").key(Key.identity()))
            .defaultValue("")
            .build();
    StatsKey<String, String> PROFILE_SERVER_GROUP = StatsKey.<String, String>builder()
            .keyBuilder(stringKeyBuilder -> stringKeyBuilder.prefix("groups").key(Key.identity()))
            .defaultValue("default")
            .build();
}
