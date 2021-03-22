package net.kitpvp.api.model.stats;

import net.kitpvp.api.Warp;
import net.kitpvp.api.heads.HeadRarity;
import net.kitpvp.stats.Key;
import net.kitpvp.stats.keys.*;

import java.util.function.Consumer;

public interface Stats {

    Key<Warp> WARP_KEY = Key.<Warp>builder().function(Warp::nameToLowercase).inverse(Warp::matchIgnoringCase).buildKey();
    Key<HeadRarity> HEAD_RARITY_KEY = Key.<HeadRarity>builder().function(HeadRarity::nameToLowercase).inverse(HeadRarity::rarityFromLowercase).buildKey();

    LongVoidStageKey ONLINE_TIME =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("online")).stage(); // check
    LongVoidStageKey AFK_TIME =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("afk")).stage(); // check
    VoidStatsKey<String> MONGO_ID =
            VoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("_id")).defaultValue((String) null).build();
    LongVoidStageKey KILLS =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("global.kills")).stage(); // check
    LongVoidStageKey DEATHS =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("global.deaths")).stage(); // check
    IntVoidStageKey ACTIVE_KILLSTREAK =
            IntVoidStatsKey.builder().keyBuilder(builder -> builder.path("global.activeKillstreak.global")).stage(); // check
    IntStageKey<Warp> ACTIVE_KILLSTREAK_AT_WARP =
            IntStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("global.activeKillstreak").function(WARP_KEY)).stage();
    LongVoidStageKey KILLSTREAK_RECORD =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("global.killstreak.record")).stage(); // check
    LongStageKey<Warp> KILLSTREAK_RECORDS_AT_WARP =
            LongStatsKey.<Warp>builder().keyBuilder(builder -> builder.prefix("global.streaksAtWarp").function(WARP_KEY)).stage(); // check
    LongVoidStageKey CLEAN_KILLS =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("global.cleanKills.global")).stage(); // check
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
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("participated")).stage();
    LongStageKey<String> EVENT_WINS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("won")).stage();
    LongStageKey<String> EVENT_KILLS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("kills")).stage();
    LongStageKey<String> EVENT_DEATHS =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("deaths")).stage();
    LongVoidStageKey GLOBAL_EVENT_TAKEN_PART =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("events.global.participated")).stage();
    LongVoidStageKey GLOBAL_EVENT_WINS =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("events.global.won")).stage();
    LongVoidStageKey GLOBAL_EVENT_KILLS =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("events.global.kills")).stage();
    LongVoidStageKey GLOBAL_EVENT_DEATHS =
            LongVoidStatsKey.builder().keyBuilder(builder -> builder.path("events.global.deaths")).stage();


    // Training
    IntStageKey<String> TRAINING_ITERATIONS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("tries")).stage();
    IntStageKey<String> TRAINING_COMPLETED =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("completed")).stage();
    LongStageKey<String> TRAINING_RECORD =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("record")).def(-1).stage();

    // Misc
    LongVoidStageKey MISC_SOUPS_EATEN =
            LongVoidStatsKey.builder().keyBuilder(LocalStats.SOUPS_EATEN_KEY_BUILDER).stage();
    LongVoidStageKey MISC_BLOCKS_WALKED =
            LongVoidStatsKey.builder().keyBuilder(LocalStats.BLOCKS_WALKED_KEY_BUILDER).stage();
    IntStatsKey<Integer> MISC_VOTINGS =
            IntStatsKey.<Integer>builder().keyBuilder(builder -> builder.prefix("misc.votings").function(IntStatsKey.INT_KEY)).def(-1).build();
    VoidStatsKey<String> API_KEY =
            VoidStatsKey.<String>builder().keyBuilder(builder -> builder.path("misc.website.apiKey")).defaultValue("").build();
    ArrayVoidStatsKey<Long> ACHIEVEMENTS =
            ArrayVoidStatsKey.<Long>builder().keyBuilder(builder -> builder.path("misc.achievements")).build();

    // Season Pass
    BooleanVoidStageKey SEASONPASS_STAGE_DONE =
            BooleanVoidStatsKey.builder().keyBuilder(builder -> builder.path("seasonpass.done")).stage();
    SetVoidStageKey<Integer> SEASONPASS_COMPLETED_CHALLENGES =
            SetVoidStatsKey.<Integer>builder().keyBuilder(builder -> builder.path("seasonpass.completed")).stage();

    interface LocalStats {
        Consumer<VoidKeyBuilder> BLOCKS_WALKED_KEY_BUILDER = builder -> builder.path("misc.blocksWalked");
        Consumer<VoidKeyBuilder> SOUPS_EATEN_KEY_BUILDER = builder -> builder.path("misc.soupsEaten");

        LongVoidStatsKey BLOCKS_WALKED =
                LongVoidStatsKey.builder().keyBuilder(BLOCKS_WALKED_KEY_BUILDER).build();
        LongVoidStatsKey SOUPS_EATEN =
                LongVoidStatsKey.builder().keyBuilder(SOUPS_EATEN_KEY_BUILDER).build();
    }
}
