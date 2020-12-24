package net.kitpvp.api.model.website;

import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.StatsKey;
import net.kitpvp.stats.keys.numeric.LongSStatsKey;

public interface Model {

    SStatsKey<String> TOKEN = SStatsKey.<String>builder().
            keyBuilder(builder -> builder.path("token")).
            build();
    LongSStatsKey DISCORD_ID = LongSStatsKey.builder().
            keyBuilder(builder -> builder.path("discord.id")).
            def(-1).
            build();//StatKeys.newStatsKey("discord.id", -1L);
    SStatsKey<String> DISCORD_CODE = SStatsKey.<String>builder().
            keyBuilder(builder -> builder.path("discord.code")).
            defaultValue("").
            build();
    StatsKey<String, String> DISCORD_PLATFORMS = StatsKey.<String, String>builder().
            keyBuilder(builder -> builder.prefix("discord.platforms").function(StatsKey.STRING_KEY)).
            defaultValue("").
            build();
}
