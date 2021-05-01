package net.kitpvp.network.model;

import net.kitpvp.network.Currency;
import net.kitpvp.network.HeadRarity;
import net.kitpvp.network.Perk;
import net.kitpvp.network.Warp;
import net.kitpvp.network.util.ArrayUtils;
import net.kitpvp.stats.Key;
import net.kitpvp.stats.keys.*;

import java.util.Set;
import java.util.UUID;
import java.util.function.UnaryOperator;

public interface Statistics {

    Key<Warp> WARP_KEY = Key.<Warp>builder()
            .function(Warp::nameToLowercase)
            .inverse(Warp::matchIgnoringCase)
            .buildKey();
    Key<Perk> PERK_KEY = Key.<Perk>builder()
            .function(Perk::nameToLowercase)
            .inverse(Perk::matchIgnoringCase)
            .buildKey();
    Key<HeadRarity> HEAD_RARITY_KEY = Key.<HeadRarity>builder()
            .function(HeadRarity::nameToLowercase)
            .inverse(HeadRarity::rarityFromLowercase)
            .buildKey();
    StatsKey<String, UUID> UUID_STATS_KEY = StatsKey.<String, UUID>builder()
            .keyBuilder(stringKeyBuilder -> stringKeyBuilder.key(Key.identity()))
            .defaultNull()
            .build();
    LongVoidStageKey ONLINE_STREAK = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("streak.days"))
            .stage(Remap.identity());
    LongVoidStageKey ONLINE_LAST_DAY = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("streak.last-day"))
            .stage(Remap.identity());
    LongVoidStageKey ONLINE_MAX_STREAK = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("streak.record"))
            .stage(Remap.identity());
    LongVoidStageKey ONLINE_TIME = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("online"))
            .stage(Remap.identity()); // check
    LongVoidStageKey AFK_TIME = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("afk"))
            .stage(Remap.identity()); // check
    VoidStatsKey<String> MONGO_ID = VoidStatsKey.<String>builder()
            .keyBuilder(builder -> builder.path("_id"))
            .defaultNull()
            .build();
    LongVoidStageKey KILLS = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.kills"))
            .stage(Remap.identity()); // check
    LongVoidStageKey DEATHS = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.deaths"))
            .stage(Remap.identity()); // check
    IntVoidStageKey ACTIVE_KILLSTREAK = IntVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.activeKillstreak.global"))
            .stage(Remap.identity()); // check
    IntStageKey<Warp> ACTIVE_KILLSTREAK_AT_WARP = IntStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.activeKillstreak").function(WARP_KEY))
            .stage(Remap.seasonPass());
    LongVoidStageKey KILLSTREAK_RECORD = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.killstreak.record"))
            .stage(Remap.identity()); // check
    LongStageKey<Warp> KILLSTREAK_RECORDS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.streaksAtWarp").function(WARP_KEY))
            .stage(Remap.seasonPass()); // check
    LongVoidStageKey CLEAN_KILLS = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("global.cleanKills.global"))
            .stage(Remap.identity()); // check
    LongStageKey<Warp> KILLS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.killsAtWarp").function(WARP_KEY))
            .stage(Remap.seasonPass()); // check
    LongStageKey<Warp> DEATHS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.deathsAtWarp").function(WARP_KEY))
            .stage(Remap.seasonPass()); // check
    LongStageKey<Warp> CLEAN_KILLS_AT_WARP = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("global.cleanKills").function(WARP_KEY))
            .stage(Remap.seasonPass()); // check

    // Heads
    LongStageKey<HeadRarity> HEADS_RECEIVED = LongStatsKey.<HeadRarity>builder()
            .keyBuilder(builder -> builder.prefix("heads.received").function(HEAD_RARITY_KEY))
            .stage(Remap.seasonPass()); // check

    // Perks
    IntStatsKey<Perk> PERK_TIER = IntStatsKey.<Perk>builder()
            .keyBuilder(builder -> builder.prefix("perks").function(PERK_KEY).suffix("tier"))
            .build();

    // Events

    LongStageKey<String> EVENT_TAKEN_PART = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("participated"))
            .stage(Remap.seasonPass());
    LongStageKey<String> EVENT_WINS = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("won"))
            .stage(Remap.seasonPass());
    LongStageKey<String> EVENT_KILLS = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("kills"))
            .stage(Remap.seasonPass());
    LongStageKey<String> EVENT_DEATHS = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("events").function(Key.identity()).suffix("deaths"))
            .stage(Remap.seasonPass());
    LongVoidStageKey GLOBAL_EVENT_TAKEN_PART =
            EVENT_TAKEN_PART.bind("global");
    LongVoidStageKey GLOBAL_EVENT_WINS =
            EVENT_WINS.bind("global");
    LongVoidStageKey GLOBAL_EVENT_KILLS =
            EVENT_KILLS.bind("global");
    LongVoidStageKey GLOBAL_EVENT_DEATHS =
            EVENT_DEATHS.bind("global");


    // Training
    IntStageKey<String> TRAINING_ITERATIONS = IntStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("tries"))
            .stage(Remap.seasonPass());
    IntStageKey<String> TRAINING_COMPLETED = IntStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("completed"))
            .stage(Remap.seasonPass());
    LongStageKey<String> TRAINING_RECORD = LongStatsKey.<String>builder()
            .keyBuilder(builder -> builder.prefix("training").function(Key.identity()).suffix("record"))
            .def(-1)
            .stage(Remap.seasonPass());

    // Misc
    LongVoidStageKey MISC_SOUPS_EATEN = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("misc.soupsEaten"))
            .stage(Remap.identity());
    LongVoidStageKey MISC_BLOCKS_WALKED = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("misc.blocksWalked"))
            .stage(Remap.identity());
    LongStageKey<Warp> BLOCKS_WALKED = LongStatsKey.<Warp>builder()
            .keyBuilder(builder -> builder.prefix("incremental").function(WARP_KEY).suffix("blocks"))
            .stage(Remap.seasonPass());
    LongVoidStageKey GLOBAL_BLOCKS_WALKED = LongVoidStatsKey.builder()
            .keyBuilder(builder -> builder.path("incremental.global.blocks"))
            .stage(Remap.identity());

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
            .stage(Remap.identity());
    SetVoidStageKey<Integer> SEASONPASS_COMPLETED_CHALLENGES = SetVoidStatsKey.<Integer>builder()
            .keyBuilder(builder -> builder.path("seasonpass.completed"))
            .stage(Remap.identity());

    interface KitPvP {

        Set<String> PATHS = ArrayUtils.asSet("air", "army",
                "beam", "fire", "healer", "shockwave", "soldier", "undead", "weather");

        Set<String> DAMAGER_DIFFICULTIES = ArrayUtils.asSet("easy", "normal", "hard", "extreme", "crazy", "ultimate", "impossible");

        IntStatsKey<String> KITPVP_PATH_EXP = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("paths").function(StatsKey.identity()).suffix("exp"))
                .build();
        IntStatsKey<String> KITPVP_PATH_LEVEL = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("paths").function(StatsKey.identity()).suffix("level"))
                .build();
        LongStageKey<String> KITPVP_KILLS_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("kills"))
                .stage(Remap.seasonPass());
        LongVoidStageKey KITPVP_KILLS_WITH_ANY_KIT =
                KITPVP_KILLS_WITH_KIT.bind("any");
        LongVoidStageKey KITPVP_KILLS_WITH_ANY_PATH =
                KITPVP_KILLS_WITH_KIT.bind("anyPath");
        LongStageKey<String> KITPVP_DEATHS_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("deaths"))
                .stage(Remap.seasonPass());
        LongStageKey<String> KITPVP_KILLSTREAK_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("killstreak"))
                .stage(Remap.seasonPass());
        LongStageKey<String> KITPVP_SPECIAL_ACTION_WITH_KIT = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("kitpvp.stats").function(StatsKey.identity()).suffix("value"))
                .stage(Remap.seasonPass());
    }

    interface Matchmaking {
        IntVoidSeasonKey ELO = IntVoidStatsKey.builder()
                .keyBuilder(builder -> builder.path("1vs1.elo.normal"))
                .offset(1000)
                .season();
        IntSeasonKey<String> LEGACY_ELO = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1").function(StatsKey.identity()).suffix("elo"))
                .offset(1000).season();
        IntVoidSeasonKey SUMO = IntVoidStatsKey.builder()
                .keyBuilder(builder -> builder.path("1vs1.elo.sumo"))
                .offset(1000)
                .season();
        IntStageKey<String> PLAYED_MATCHES = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.identity()).suffix("playedMatches"))
                .stage(Remap.seasonPass());
        IntVoidStageKey GLOBAL_PLAYED_MATCHES = PLAYED_MATCHES.bind("global");
        IntStageKey<String> WON_MATCHES = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.identity()).suffix("wonMatches"))
                .stage(Remap.seasonPass());
        IntVoidStageKey GLOBAL_WON_MATCHES = WON_MATCHES.bind("global");
        IntStageKey<String> LOST_MATCHES = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.identity()).suffix("lostMatches"))
                .stage(Remap.seasonPass());
        IntVoidStageKey GLOBAL_LOST_MATCHES = LOST_MATCHES.bind("global");
        IntStageKey<String> KILLS = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.identity()).suffix("kills"))
                .stage(Remap.seasonPass());
        IntStageKey<String> DEATHS = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.modes").function(StatsKey.identity()).suffix("deaths"))
                .stage(Remap.seasonPass());
        IntStageKey<String> PLAYED_MATCHES_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.identity()).suffix("playedMatches"))
                .stage(Remap.seasonPass());
        IntStageKey<String> WON_MATCHES_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.identity()).suffix("wonMatches"))
                .stage(Remap.seasonPass());
        IntStageKey<String> LOST_MATCHES_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.identity()).suffix("lostMatches"))
                .stage(Remap.seasonPass());
        IntStageKey<String> KILLS_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.identity()).suffix("kills"))
                .stage(Remap.seasonPass());
        IntStageKey<String> DEATHS_WITH_KIT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.stats").function(StatsKey.identity()).suffix("deaths"))
                .stage(Remap.seasonPass());
        IntStageKey<String> WINS_AGAINST_BOT = IntStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("1vs1.bot").function(StatsKey.identity()).suffix("wins"))
                .stage(Remap.seasonPass());
        ArrayVoidStatsKey<String> PREVIOUS_OPPONENTS = ArrayVoidStatsKey.<String>builder()
                .keyBuilder(builder -> builder.path("alltime.1vs1.previous.opponents"))
                .build();
        ArrayVoidStatsKey<String> BANNED_KITS = ArrayVoidStatsKey.<String>builder()
                .keyBuilder(builder -> builder.path("alltime.1vs1.banned.kits"))
                .build();
        ArrayStatsKey<String, String> BANNED_MAPS = ArrayStatsKey.<String, String>builder()
                .keyBuilder(builder -> builder.prefix("alltime.1vs1.banned.maps").function(StatsKey.identity()))
                .build();
        IntVoidStatsKey PREVIOUS_OPPONENTS_STREAK = IntVoidStatsKey.builder()
                .keyBuilder(builder -> builder.path("alltime.1vs1.previous.streak"))
                .build();
    }

    interface Remap {

        static UnaryOperator<VoidKeyFunction> identity() {
            return (function) ->
                    KeyFunctions.prefixed(function, "seasonpass.statistics");
        }

        static <K> UnaryOperator<KeyFunction<K>> seasonPass() {
            return (function) ->
                    KeyFunctions.prefixed(function, "seasonpass.statistics");
        }
    }
}
