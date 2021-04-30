package net.kitpvp.network;

import net.kitpvp.network.util.EnumUtils;

import java.util.Locale;

public enum Currency {

    NORMAL,
    SKILL_POINTS,
    LEGACY;

    public String nameToLowercase() {
        return name().toLowerCase(Locale.ROOT);
    }

    public static Currency matchIgnoringCase(String name) {
        return EnumUtils.matchIgnoringCase(Currency.class, name);
    }
}
