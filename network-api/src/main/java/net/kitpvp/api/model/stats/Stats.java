package net.kitpvp.api.model.stats;

import net.kitpvp.api.Warp;
import net.kitpvp.api.heads.HeadRarity;
import net.kitpvp.stats.api.keys.Key;
import net.kitpvp.stats.api.keys.Keys;
import net.kitpvp.stats.builder.keys.VoidKeyBuilder;
import net.kitpvp.stats.keys.SStatsKey;
import net.kitpvp.stats.keys.array.ArraySStatsKey;
import net.kitpvp.stats.keys.bool.BooleanSStageKey;
import net.kitpvp.stats.keys.bool.BooleanSStatsKey;
import net.kitpvp.stats.keys.numeric.*;
import net.kitpvp.stats.keys.set.SetSStageKey;
import net.kitpvp.stats.keys.set.SetSStatsKey;

import java.util.function.Consumer;

public interface Stats {

    Key<Warp> WARP_KEY = Key.<Warp>builder().function(Warp::nameToLowercase).inverse(Warp::matchIgnoringCase).buildKey();
    Key<HeadRarity> HEAD_RARITY_KEY = Key.<HeadRarity>builder().function(HeadRarity::nameToLowercase).inverse(HeadRarity::rarityFromLowercase).buildKey();

    LongSStageKey ONLINE_TIME =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("online")).stage(); // check
    LongSStageKey AFK_TIME =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("afk")).stage(); // check
    SStatsKey<String> MONGO_ID =
            SStatsKey.<String>builder().keyBuilder(builder -> builder.path("_id")).defaultValue((String) null).build();
    LongSStageKey KILLS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("global.kills")).stage(); // check
    LongSStageKey DEATHS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("global.deaths")).stage(); // check
    IntSStageKey ACTIVE_KILLSTREAK =
            IntSStatsKey.builder().keyBuilder(builder -> builder.path("global.activeKillstreak.global")).stage(); // check
    IntStageKey<Warp> ACTIVE_KILLSTREAK_AT_WARP =
            IntStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("global.activeKillstreak").function(WARP_KEY)).stage();
    LongSStageKey KILLSTREAK_RECORD =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("global.killstreak.record")).stage(); // check
    LongStageKey<Warp> KILLSTREAK_RECORDS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("global.streaksAtWarp").function(WARP_KEY)).stage(); // check
    LongSStageKey CLEAN_KILLS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("global.cleanKills.global")).stage(); // check
    LongStageKey<Warp> KILLS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("global.killsAtWarp").function(WARP_KEY)).stage(); // check
    LongStageKey<Warp> DEATHS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("global.deathsAtWarp").function(WARP_KEY)).stage(); // check
    LongStageKey<Warp> CLEAN_KILLS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("global.cleanKills").function(WARP_KEY)).stage(); // check

    // Heads
    LongStageKey<HeadRarity> HEADS_RECEIVED =
            LongStatsKey.<HeadRarity>builder().keyBuilder(builder -> builder.prefix("heads.received").function(HEAD_RARITY_KEY)).stage(); // check

    // Events

    LongStageKey<String> EVENT_TAKEN_PART =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Keys.STRING_KEY).suffix("participated")).stage();
    LongStageKey<String> EVENT_WINS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Keys.STRING_KEY).suffix("won")).stage();
    LongStageKey<String> EVENT_KILLS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Keys.STRING_KEY).suffix("kills")).stage();
    LongStageKey<String> EVENT_DEATHS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Keys.STRING_KEY).suffix("deaths")).stage();
    LongSStageKey GLOBAL_EVENT_TAKEN_PART =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.participated")).stage();
    LongSStageKey GLOBAL_EVENT_WINS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.won")).stage();
    LongSStageKey GLOBAL_EVENT_KILLS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.kills")).stage();
    LongSStageKey GLOBAL_EVENT_DEATHS =
            LongSStatsKey.builder().keyBuilder(builder -> builder.path("events.global.deaths")).stage();


    // Training
    IntStageKey<String> TRAINING_ITERATIONS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Keys.STRING_KEY).suffix("tries")).stage();
    IntStageKey<String> TRAINING_COMPLETED =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Keys.STRING_KEY).suffix("completed")).stage();
    LongStageKey<String> TRAINING_RECORD =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Keys.STRING_KEY).suffix("record")).def(-1).stage();

    // Misc
    LongSStageKey MISC_SOUPS_EATEN =
            LongSStatsKey.builder().keyBuilder(LocalStats.SOUPS_EATEN_KEY_BUILDER).stage();
    LongSStageKey MISC_BLOCKS_WALKED =
            LongSStatsKey.builder().keyBuilder(LocalStats.BLOCKS_WALKED_KEY_BUILDER).stage();
    IntStatsKey<Integer> MISC_VOTINGS =
            IntStatsKey.<Integer>builder().keyBuilder(builder -> builder.prefix("misc.votings").function(IntStatsKey.INT_KEY)).def(-1).build();
    SStatsKey<String> API_KEY =
            SStatsKey.<String>builder().keyBuilder(builder -> builder.path("misc.website.apiKey")).defaultValue("").build();
    ArraySStatsKey<Long> ACHIEVEMENTS =
            ArraySStatsKey.<Long>builder().keyBuilder(builder -> builder.path("misc.achievements")).build();

    // Season Pass
    BooleanSStageKey SEASONPASS_STAGE_DONE =
            BooleanSStatsKey.builder().keyBuilder(builder -> builder.path("seasonpass.done")).stage();
    SetSStageKey<Integer> SEASONPASS_COMPLETED_CHALLENGES =
            SetSStatsKey.<Integer>builder().keyBuilder(builder -> builder.path("seasonpass.completed")).stage();

    interface LocalStats {
        Consumer<VoidKeyBuilder> BLOCKS_WALKED_KEY_BUILDER = builder -> builder.path("misc.blocksWalked");
        Consumer<VoidKeyBuilder> SOUPS_EATEN_KEY_BUILDER = builder -> builder.path("misc.soupsEaten");

        LongSStatsKey BLOCKS_WALKED =
                LongSStatsKey.builder().keyBuilder(BLOCKS_WALKED_KEY_BUILDER).build();
        LongSStatsKey SOUPS_EATEN =
                LongSStatsKey.builder().keyBuilder(SOUPS_EATEN_KEY_BUILDER).build();
    }
}
