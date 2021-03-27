package net.kitpvp.network;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.network.util.EnumUtils;
import net.md_5.bungee.api.ChatColor;

@RequiredArgsConstructor
public enum Group {

    ADMIN(0),
    DEVELOPER(10),
    SENIOR_MODERATOR(20),
    MODERATOR(50),
    TRIAL_MODERATOR(100),
    BUILDER(200),
    MEDIA(300),
    PRO_PLUS(400),
    LEGEND(500),
    INFECTED(500),
    ELITE(600),
    HAZARD(600),
    PRO(700),
    DEFAULT(1000);

    public static Group matchIgnoringCase(String name) {
        return EnumUtils.matchIgnoringCase(Group.class, name);
    }

    @Getter
    private final int power;

    public boolean isHigher(Group other) {
        return this.getPower() < other.getPower();
    }

    public boolean isHigherOrEqual(Group other) {
        return this.getPower() <= other.getPower();
    }

    public boolean isLower(Group other) {
        return this.getPower() > other.getPower();
    }

    public boolean isLowerOrEqual(Group other) {
        return this.getPower() >= other.getPower();
    }

    public boolean isEqual(Group other) {
        return this.getPower() == other.getPower();
    }

    public String getName() {
        switch(this) {
            case PRO:
                return "Pro";
            case ADMIN:
                return "Admin";
            case ELITE:
                return "Elite";
            case BUILDER:
                return "Builder";
            case MEDIA:
                return "Media";
            case LEGEND:
                return "Legend";
            default:
            case DEFAULT:
                return "Normal";
            case PRO_PLUS:
                return "Pro+";
            case DEVELOPER:
                return "Developer";
            case MODERATOR:
                return "Moderator";
            case TRIAL_MODERATOR:
                return "Trial Moderator";
            case SENIOR_MODERATOR:
                return "Senior Moderator";
            case INFECTED:
                return "Infected";
            case HAZARD:
                return "Hazard";
        }
    }

    public String getColor() {
        switch(this) {
            case PRO:
                return "" + ChatColor.BLUE;
            case DEFAULT:
                return "" + ChatColor.GRAY;
            case SENIOR_MODERATOR:
                return "" + ChatColor.DARK_PURPLE + ChatColor.ITALIC;
            case TRIAL_MODERATOR:
                return "" + ChatColor.LIGHT_PURPLE;
            case MODERATOR:
                return "" + ChatColor.DARK_PURPLE;
            case DEVELOPER:
            case ADMIN:
                return "" + ChatColor.RED;
            case PRO_PLUS:
                return "" + ChatColor.BLUE + ChatColor.ITALIC;
            case LEGEND:
                return "" + ChatColor.GOLD + ChatColor.ITALIC;
            case MEDIA:
                return "" + ChatColor.AQUA;
            case BUILDER:
                return "" + ChatColor.YELLOW;
            case ELITE:
                return "" + ChatColor.GOLD;
            case HAZARD:
                return "" + ChatColor.GREEN;
            case INFECTED:
                return "" + ChatColor.GREEN + ChatColor.ITALIC;
            default:
                throw new UnsupportedOperationException("Unknown group " + this);
        }
    }
}
