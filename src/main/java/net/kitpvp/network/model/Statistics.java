package net.kitpvp.network.model;

import net.kitpvp.network.HeadRarity;
import net.kitpvp.network.Warp;
import net.kitpvp.network.util.ArrayUtils;
import net.kitpvp.stats.Key;
import net.kitpvp.stats.keys.*;

import java.util.Set;

public interface Statistics {

    Key<Warp> WARP_KEY = Key.<Warp>builder()
            .function(Warp::nameToLowercase)
            .inverse(Warp::matchIgnoringCase)
            .buildKey();
    Key<HeadRarity> HEAD_RARITY_KEY = Key.<HeadRarity>builder()
            .function(HeadRarity::nameToLowercase)
            .inverse(HeadRarity::rarityFromLowercase)
            .buildKey();
    LongVoidStageKey ONLINE_TIME = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("online"))
            .stage(); // check
    LongVoidStageKey AFK_TIME = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("afk"))
            .stage(); // check
    VoidStatsKey<String> MONGO_ID = VoidStatsKey.<String>builder()
            .keyBuilder(builder -> builder.path("_id"))
            .defaultNull()
            .build();
    LongVoidStageKey KILLS = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.kills"))
            .stage(); // check
    LongVoidStageKey DEATHS = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.deaths"))
            .stage(); // check
    IntVoidStageKey ACTIVE_KILLSTREAK = IntVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.activeKillstreak.global"))
            .stage(); // check
    IntStageKey<Warp> ACTIVE_KILLSTREAK_AT_WARP = IntStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.activeKillstreak").function(WARP_KEY))
            .stage();
    LongVoidStageKey KILLSTREAK_RECORD = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.killstreak.record"))
            .stage(); // check
    LongStageKey<Warp> KILLSTREAK_RECORDS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.streaksAtWarp").function(WARP_KEY))
            .stage(); // check
    LongVoidStageKey CLEAN_KILLS = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.cleanKills.global"))
            .stage(); // check
    LongStageKey<Warp> KILLS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.killsAtWarp").function(WARP_KEY))
            .stage(); // check
    LongStageKey<Warp> DEATHS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.deathsAtWarp").function(WARP_KEY))
            .stage(); // check
    LongStageKey<Warp> CLEAN_KILLS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.cleanKills").function(WARP_KEY))
            .stage(); // check

    // Heads
    LongStageKey<HeadRarity> HEADS_RECEIVED = LongStatsKey.<HeadRarity>builder()
            .keyBuilder(builder -> builder.prefix("heads.received").function(HEAD_RARITY_KEY))
            .stage(); // check

    // Events

    LongStageKey<String> EVENT_TAKEN_PART = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("participated"))
            .stage();
    LongStageKey<String> EVENT_WINS = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("won"))
            .stage();
    LongStageKey<String> EVENT_KILLS = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("kills"))
            .stage();
    LongStageKey<String> EVENT_DEATHS = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("deaths"))
            .stage();
    LongVoidStageKey GLOBAL_EVENT_TAKEN_PART =
            EVENT_TAKEN_PART.bind("global");
    LongVoidStageKey GLOBAL_EVENT_WINS =
            EVENT_WINS.bind("global");
    LongVoidStageKey GLOBAL_EVENT_KILLS =
            EVENT_KILLS.bind("global");
    LongVoidStageKey GLOBAL_EVENT_DEATHS =
            EVENT_DEATHS.bind("global");


    // Training
    IntStageKey<String> TRAINING_ITERATIONS =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("tries")).stage();
    IntStageKey<String> TRAINING_COMPLETED =
            IntStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("completed")).stage();
    LongStageKey<String> TRAINING_RECORD =
            LongStatsKey.<String>builder().keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("record")).def(-1).stage();

    // Misc
    LongVoidStageKey MISC_SOUPS_EATEN = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("misc.soupsEaten"))
            .stage();
    LongVoidStageKey MISC_BLOCKS_WALKED = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("misc.blocksWalked"))
            .stage();
    IntStatsKey<Integer> MISC_VOTINGS = IntStatsKey.<Integer>builder()
            .keyBuilder(builder -> builder.prefix("misc.votings").function(IntStatsKey.INT_KEY))
            .def(-1)
            .build();
    VoidStatsKey<String> API_KEY = VoidStatsKey.<String>builder()
            .keyBuilder(builder -> builder.path("misc.website.apiKey"))
            .defaultValue("")
            .build();
    ArrayVoidStatsKey<Long> ACHIEVEMENTS = ArrayVoidStatsKey.<Long>builder()
            .keyBuilder(builder -> builder.path("misc.achievements"))
            .build();

    // Season Pass
    BooleanVoidStageKey SEASONPASS_STAGE_DONE = BooleanVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("seasonpass.done"))
            .stage();
    SetVoidStageKey<Integer> SEASONPASS_COMPLETED_CHALLENGES = SetVoidStatsKey.<Integer>builder()
            .keyBuilder(builder -> builder.path("seasonpass.completed"))
            .stage();

    interface KitPvP {

        Set<String> PATHS = ArrayUtils.asSet("air", "army",
                "beam", "fire", "healer", "shockwave", "soldier", "undead", "weather");

        IntStatsKey<String> KITPVP_PATH_EXP = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("paths").function(StatsKey.identity()).suffix("exp"))
                .build();
        IntStatsKey<String> KITPVP_PATH_LEVEL = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("paths").function(StatsKey.identity()).suffix("level"))
                .build();
        LongStageKey<String> KITPVP_KILLS_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("kills"))
                .stage();
        LongStageKey<String> KITPVP_DEATHS_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("deaths"))
                .stage();
        LongStageKey<String> KITPVP_KILLSTREAK_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("killstreak"))
                .stage();
        LongStageKey<String> KITPVP_SPECIAL_ACTION_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("value"))
                .stage();
    }

    interface Matchmaking {
        IntVoidSeasonKey ELO = IntVoidStatsKey.builder()
                .keyBuilder(builder -> builder.path("1vs1.elo.normal"))
                .offset(1000)
                .season();
        IntSeasonKey<String> LEGACY_ELO = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1").function(StatsKey.STRING_KEY).suffix("elo"))
                .offset(1000).season();
        IntVoidSeasonKey SUMO = IntVoidStatsKey.builder()
                .keyBuilder(builder -> builder.path("1vs1.elo.sumo"))
                .offset(1000)
                .season();
        IntStageKey<String> PLAYED_MATCHES = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("playedMatches"))
                .stage();
        IntStageKey<String> WON_MATCHES = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("wonMatches"))
                .stage();
        IntStageKey<String> LOST_MATCHES = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("lostMatches"))
                .stage();
        IntStageKey<String> KILLS = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("kills"))
                .stage();
        IntStageKey<String> DEATHS = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.STRING_KEY).suffix("deaths"))
                .stage();
        IntStageKey<String> PLAYED_MATCHES_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("playedMatches"))
                .stage();
        IntStageKey<String> WON_MATCHES_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("wonMatches"))
                .stage();
        IntStageKey<String> LOST_MATCHES_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("lostMatches"))
                .stage();
        IntStageKey<String> KILLS_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("kills"))
                .stage();
        IntStageKey<String> DEATHS_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.STRING_KEY).suffix("deaths"))
                .stage();
        IntStageKey<String> WINS_AGAINST_BOT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.bot").function(StatsKey.STRING_KEY).suffix("wins"))
                .stage();
        ArrayVoidStatsKey<String> PREVIOUS_OPPONENTS = ArrayVoidStatsKey.<String>builder()
                .keyBuilder(builder -> builder.path("alltime.1vs1.previous.opponents"))
                .build();
        ArrayVoidStatsKey<String> BANNED_KITS = ArrayVoidStatsKey.<String>builder()
                .keyBuilder(builder -> builder.path("alltime.1vs1.banned.kits"))
                .build();
        ArrayStatsKey<String, String> BANNED_MAPS = ArrayStatsKey.<String, String>builder()
                .keyBuilder(builder -> builder.prefix("alltime.1vs1.banned.maps").function(StatsKey.STRING_KEY))
                .build();
        IntVoidStatsKey PREVIOUS_OPPONENTS_STREAK = IntVoidStatsKey.builder()
                .keyBuilder(builder -> builder.path("alltime.1vs1.previous.streak"))
                .build();
    }
}
