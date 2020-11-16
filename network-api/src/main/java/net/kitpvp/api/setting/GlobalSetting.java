package net.kitpvp.api.setting;

import net.kitpvp.stats.settings.TSetting;
import net.kitpvp.stats.settings.impl.NormalSetting;
import net.kitpvp.stats.settings.impl.ToggleSetting;
import net.kitpvp.stats.settings.impl.TrueFalseSetting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum GlobalSetting implements TSetting {

    AFK_MODE("afkMode", "vanish", "ignore"),
    TIME_LOCK("dayNight", "disabled", "day", "night"),

    TITLE("title", "none"),
    TAG("tag", true),
    HEAD("head", ""),
    CLAN_TAG("clanTag", true),
    TITLE_FORCED_OFF("titleForcedOff", false),
    LEGACY_BUY_BUILDER("legacyBuybuilder", false);

    private final NormalSetting handle;

    GlobalSetting(String key, boolean def) {
        this.handle = new TrueFalseSetting(key, def + "");
    }

    GlobalSetting(String key) {
        this.handle = new NormalSetting(key, "");
    }

    GlobalSetting(String key, String def, String... values) {
        List<String> vals = new ArrayList<>();
        vals.add(def);
        vals.addAll(Arrays.asList(values));
        this.handle = new ToggleSetting(key, def, vals);
    }

    public String getKey() {
        return this.handle.getKey();
    }

    @Override
    public String getDefault() {
        return this.handle.getDefault();
    }

    public List<String> getValues() {
        if(!(this.handle instanceof TSetting))
            throw new IllegalArgumentException("Cannot toggle the setting " + this);
        return ((TSetting) this.handle).getValues();
    }

    @Override
    public final String next(String current) {
        if(!(this.handle instanceof TSetting))
            throw new IllegalArgumentException("Cannot toggle the setting " + this);
        return TSetting.super.next(current);
    }
}
