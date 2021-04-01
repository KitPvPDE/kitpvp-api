package net.kitpvp.network.model;

import net.kitpvp.stats.settings.impl.NormalSetting;
import net.kitpvp.stats.settings.impl.ToggleSetting;
import net.kitpvp.stats.settings.impl.TrueFalseSetting;

import java.util.ArrayList;
import java.util.Arrays;

public interface Settings {

    interface Global {
        NormalSetting TITLE = normal("title", "none");
        NormalSetting HEAD = normal("head", "");
        NormalSetting APPEALS_BLOCKED = normal("appealsBlocked", "");
        NormalSetting TAG_RANK = normal("tagRank", "");
        TrueFalseSetting TAG = trueFalse("tag", true);
        TrueFalseSetting CLAN_TAG = trueFalse("clanTag", true);
        TrueFalseSetting CLAN_CHAT = trueFalse("clanChat", false);
        TrueFalseSetting MESSAGES = trueFalse("messages", true);
        TrueFalseSetting TITLE_FORCED_OFF = trueFalse("titleForcedOff", false);
        TrueFalseSetting ONLY_MESSAGES = trueFalse("onlyMessages2", false);
        TrueFalseSetting VOTED = trueFalse("votedForServer", false);
        ToggleSetting TIME_LOCK = toggle("timeLock", "default", "day", "night");
    }

    interface Staff {
        TrueFalseSetting SILENT_MODE = trueFalse("silentMode", false);
        TrueFalseSetting STAFF_CHAT = trueFalse("staffChat", false);
        TrueFalseSetting STRONG_SPECTATE_MODE = trueFalse("strongSpectateMode", false);

        TrueFalseSetting TELEPORT_TO_WARP = trueFalse("teleportToWarp", true);
        TrueFalseSetting VANISH_WHEN_AFK = trueFalse("vanishWhenAfk", true);
        NormalSetting NOTIFY_CHANNELS = normal("notifyChannels", "");
    }

    interface Scoreboard {
        TrueFalseSetting ENABLED = trueFalse("scoreboardEnabled", true);
        TrueFalseSetting ALLTIME_STATS = trueFalse("scoreboardAlltimeStats", false);
    }

    interface KitPvP {
        NormalSetting LAST_KIT = normal("lastKit", "");

        ToggleSetting COOLDOWN = toggle("cooldown", "actionbar", "chat", "disabled");

        interface Training {
            TrueFalseSetting INCLUDE_SWORD = trueFalse("trainingIncludeSword", true);

            ToggleSetting DIFFICULTY_DAMAGER = toggle("trainingDifficultyDamager", "normal", "easy", "hard", "extreme", "crazy", "ultimate", "impossible");
            ToggleSetting DIFFICULTY_LAVA = toggle("trainingDifficultyLava", "normal", "noob", "easy", "vanilla", "hard", "extreme", "crazy", "ultimate", "impossible");
            ToggleSetting DIFFICULTY_AIM = toggle("trainingDifficultyAim", "normal", "easy", "hard", "extreme");
            ToggleSetting INVENTORY_TRAINING = toggle("trainingInventory", "refill", "recraft");

            NormalSetting LAST_TRAINING = normal("trainingLastTraining", "damager");
        }
    }

    static TrueFalseSetting trueFalse(String key, boolean def) {
        return new TrueFalseSetting(key, def ? "true" : "false");
    }

    static ToggleSetting toggle(String key, String def, String... values) {
        return new ToggleSetting(key, def, new ArrayList<String>() {{
            add(def);
            addAll(Arrays.asList(values));
        }});
    }

    static NormalSetting normal(String key, String def) {
        return new NormalSetting(key, def);
    }
}
