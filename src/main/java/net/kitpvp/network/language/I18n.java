package net.kitpvp.network.language;

import net.kitpvp.mongodbapi.log.Log;
import net.kitpvp.network.Group;
import net.kitpvp.network.Perk;
import net.kitpvp.network.Warp;
import net.kitpvp.network.translation.LocaleManager;
import net.kitpvp.network.translation.exception.InvalidTranslationException;
import net.kitpvp.network.translation.exception.MissingTranslationException;

import java.util.Locale;
import java.util.logging.Level;

public class I18n {

    public static String translateWarp(Warp warp, Locale locale) {
        return translateKey(locale, "warps." + warp.nameToLowercase() + ".name");
    }

    public static String translateAbility(String ability, Locale locale) {
        return translateKey(locale, "ability." + ability + ".name");
    }

    public static String translateRank(Group group, Locale locale) {
        return translateKey(locale, "group." + group.name().toLowerCase(Locale.ROOT) + ".name");
    }

    public static String translate1vs1Kit(String kit, Locale locale) {
        return translateKey(locale, "matchmaking.kit." + kit + ".name");
    }

    public static String translatePerk(Perk perk, Locale locale) {
        return translateKey(locale, "perk." + perk.nameToLowercase() + ".name");
    }

    private static String translateKey(Locale locale, String translationKey, Object... args) {
        try {
            return LocaleManager.getInstance().translate(locale, translationKey, args);
        } catch (MissingTranslationException cause) {
            Log.log(Level.WARNING, "Translation " + cause.getMessage() + " is missing");
        } catch (InvalidTranslationException cause) {
            Log.log(Level.WARNING, "Could not translate " + cause.getMessage() + ": ", cause);
        }
        return translationKey;
    }
}
