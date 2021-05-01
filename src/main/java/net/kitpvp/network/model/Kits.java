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
}
