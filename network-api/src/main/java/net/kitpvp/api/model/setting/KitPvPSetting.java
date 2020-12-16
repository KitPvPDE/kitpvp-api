package net.kitpvp.api.model.setting;

import net.kitpvp.stats.settings.impl.NormalSetting;
import net.kitpvp.stats.settings.impl.ToggleSetting;
import net.kitpvp.stats.settings.impl.TrueFalseSetting;

import static net.kitpvp.api.model.setting.Setting.*;

public interface KitPvPSetting {

    NormalSetting LAST_KIT = normal("lastKit", "");

    ToggleSetting COOLDOWN = toggle("cooldown", "actionbar", "chat", "disabled");

    interface TrainingSetting {
        TrueFalseSetting INCLUDE_SWORD = trueFalse("trainingIncludeSword", true);

        ToggleSetting DIFFICULTY_DAMAGER = toggle("trainingDifficultyDamager", "normal", "easy", "hard", "extreme", "crazy", "ultimate", "impossible");
        ToggleSetting DIFFICULTY_LAVA = toggle("trainingDifficultyLava", "normal", "noob", "easy", "vanilla", "hard", "extreme", "crazy", "ultimate", "impossible");
        ToggleSetting DIFFICULTY_AIM = toggle("trainingDifficultyAim", "normal", "easy", "hard", "extreme");
        ToggleSetting INVENTORY_TRAINING = toggle("trainingInventory", "refill", "recraft");

        NormalSetting LAST_TRAINING = normal("trainingLastTraining", "damager");
    }
}
