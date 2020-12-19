package net.kitpvp.api.model.setting;

import net.kitpvp.stats.settings.impl.NormalSetting;
import net.kitpvp.stats.settings.impl.ToggleSetting;
import net.kitpvp.stats.settings.impl.TrueFalseSetting;

import java.util.ArrayList;
import java.util.Arrays;

public interface Setting {

    NormalSetting TITLE = normal("title", "none");
    NormalSetting HEAD = normal("head", "");
    NormalSetting APPEALS_BLOCKED = normal("appealsBlocked", "");
    TrueFalseSetting TAG = trueFalse("tag", true);
    TrueFalseSetting CLAN_TAG = trueFalse("clanTag", true);
    TrueFalseSetting CLAN_CHAT = trueFalse("clanChat", false);
    TrueFalseSetting MESSAGES = trueFalse("messages", true);
    TrueFalseSetting TITLE_FORCED_OFF = trueFalse("titleForcedOff", false);
    TrueFalseSetting ONLY_MESSAGES = trueFalse("onlyMessages2", false);
    TrueFalseSetting VOTED = trueFalse("votedForServer", false);
    ToggleSetting TIME_LOCK = toggle("timeLock", "default", "day", "night");

    // Scoreboard

    // Staff ---->
    TrueFalseSetting SILENT_MODE = trueFalse("silentMode", false);
    TrueFalseSetting STAFF_CHAT = trueFalse("staffChat", false);
    TrueFalseSetting STRONG_SPECTATE_MODE = trueFalse("strongSpectateMode", false);



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