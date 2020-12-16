package net.kitpvp.api.model.setting;

import net.kitpvp.stats.settings.impl.TrueFalseSetting;

import static net.kitpvp.api.model.setting.Setting.trueFalse;

public interface StaffSetting {

    TrueFalseSetting TELEPORT_TO_WARP = trueFalse("teleportToWarp", true);
    TrueFalseSetting VANISH_WHEN_AFK = trueFalse("vanishWhenAfk", true);
}
