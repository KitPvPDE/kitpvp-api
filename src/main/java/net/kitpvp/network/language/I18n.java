package net.kitpvp.network.language;

import net.kitpvp.network.Group;
import net.kitpvp.network.Warp;
import net.kitpvp.network.translation.LocaleManager;

import java.util.Locale;

public class I18n {

    public static String translateWarp(Warp warp, Locale locale) {
        return LocaleManager.getInstance().translate(locale, "warps." + warp.nameToLowercase() + ".name");
    }

    public static String translateAbility(String ability, Locale locale) {
        return LocaleManager.getInstance().translate(locale, "ability." + ability + ".name");
    }

    public static String translateRank(Group group, Locale locale) {
        return LocaleManager.getInstance().translate(locale, "group." + group.name().toLowerCase(Locale.ROOT) + ".name");
    }
}
