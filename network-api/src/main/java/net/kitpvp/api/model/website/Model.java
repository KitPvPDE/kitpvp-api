package net.kitpvp.api.model.website;

import net.kitpvp.stats.keys.StatsKey;
import net.kitpvp.stats.keys.VoidStatsKey;
import net.kitpvp.stats.keys.LongVoidStatsKey;

public interface Model {

    VoidStatsKey<String> TOKEN = VoidStatsKey.<String>builder().
            keyBuilder(builder -> builder.path("token")).
            build();
    LongVoidStatsKey DISCORD_ID = LongVoidStatsKey.builder().
            keyBuilder(builder -> builder.path("discord.id")).
            def(-1).
            build();//StatKeys.newStatsKey("discord.id", -1L);
    VoidStatsKey<String> DISCORD_CODE = VoidStatsKey.<String>builder().
            keyBuilder(builder -> builder.path("discord.code")).
            defaultValue("").
            build();
    StatsKey<String, String> DISCORD_PLATFORMS = StatsKey.<String, String>builder().
            keyBuilder(builder -> builder.prefix("discord.platforms").function(StatsKey.STRING_KEY)).
            defaultValue("").
            build();
}
