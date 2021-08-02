package net.kitpvp.network.model;

import net.kitpvp.network.Kit;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Kits {

    Set<Kit> ALL_KITS = Stream.of(Kit.values())
            .collect(Collectors.toSet());

    Set<Kit> FREE_KITS = Stream.of(Kit.NONE, Kit.NOOB, Kit.RELAXO, Kit.NEO, Kit.VIPER, Kit.FIREMAN, Kit.BARBARIAN)
            .collect(Collectors.toSet());

    Set<String> MATCHMAKING_KITS = Stream.of("nodebuff", "onlysword", "fullinv", "lavaduel", "recraft", "combo", "onebar",
                    "bow", "gladiator1v1", "sumo", "classic", "debuff", "earlyhg", "anchor", "builduhc", "mcsg", "pit", "gapple")
            .collect(Collectors.toSet());
}
