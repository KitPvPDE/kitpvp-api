package net.kitpvp.network;

import net.kitpvp.network.util.EnumUtils;

import java.util.Locale;

public enum Perk {

    INTELLIGENCE,
    CONSTITUTION,
    DURABILITY,
    FALL_DMG,
    ;

    public String nameToLowercase() {
        return this.name().toLowerCase(Locale.ROOT);
    }

    public static Perk matchIgnoringCase(String name) {
        return EnumUtils.matchIgnoringCase(Perk.class, name);
    }
}
