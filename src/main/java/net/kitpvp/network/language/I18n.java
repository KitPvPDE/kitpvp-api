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
        return translate(locale, "warps." + warp.nameToLowercase() + ".name");
    }

    public static String translateAbility(String ability, Locale locale) {
        return translate(locale, "ability." + ability + ".name");
    }

    public static String translateAbilityDescription(String ability, Locale locale) {
        return translate(locale, "ability." + ability + ".description");
    }

    public static String translateRank(Group group, Locale locale) {
        return translate(locale, "group." + group.name().toLowerCase(Locale.ROOT) + ".name");
    }

    public static String translate1vs1Kit(String kit, Locale locale) {
        return translate(locale, "matchmaking.kit." + kit + ".name");
    }

    public static String translatePerk(Perk perk, Locale locale) {
        return translate(locale, "perk." + perk.nameToLowercase() + ".name");
    }

    public static String translate(Locale locale, String translationKey, Object... args) {
        return translate(LocaleManager.getInstance(), locale, translationKey, args);
    }

    public static String translate(LocaleManager localeManager, Locale locale, String translationKey, Object... args) {
        try {
            return localeManager.translate(locale, translationKey, args);
        } catch (MissingTranslationException cause) {
            Log.log(Level.WARNING, "Translation " + cause.getMessage() + " is missing");
        } catch (InvalidTranslationException cause) {
            Log.log(Level.WARNING, "Could not translate " + cause.getMessage() + ": ", cause);
        }
        return translationKey;
    }
}
