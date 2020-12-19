package net.kitpvp.api.heads;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.api.utils.EnumUtils;
import net.md_5.bungee.api.ChatColor;

@Getter
@RequiredArgsConstructor
public enum HeadRarity {

    LEGENDARY(ChatColor.DARK_RED, 0.0, 0.001),
    MYSTERY(ChatColor.RED, 0.001, 0.01),
    HEROIC(ChatColor.DARK_PURPLE, 0.01, 0.05),
    EPIC(ChatColor.LIGHT_PURPLE, 0.05, 0.15),
    RARE(ChatColor.BLUE, 0.15, 0.4),
    COMMON(ChatColor.AQUA, 0.4, 1.0)
    ;

    private final ChatColor color;
    private final double top, bottom;

    public static HeadRarity fromRarity(double value) {
        if(value < 0.0 || value > 1.0)
            return null;

        for(HeadRarity rarity : values()) {
            // 0.0 <= 0.12412 && 0.0001 >= 0.12412
            if(rarity.getTop() <= value && rarity.getBottom() >= value)
                return rarity;
        }

        return null;
    }

    public String nameToLowercase() {
        return this.name().toLowerCase();
    }

    public static HeadRarity rarityFromLowercase(String rarity) {
        return EnumUtils.matchIgnoringCase(HeadRarity.class, rarity);
    }
}
