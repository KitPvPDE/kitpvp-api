package net.kitpvp.api.title;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.ChatColor;

@RequiredArgsConstructor
public enum Title {

    SUMO_CHAMPION("sumo_champion", "Sumo §a§lCHAMPION", "§6§lSUMO", "Is one of the 3 most recent sumo event winners", 420),
    SEASON_1_CHAMPION_MATCHMAKING("season1_champion_matchmaking", "1vs1 §3§lCHAMPION", "§6§l1vs1", "Finished Top 3 at 1vs1", 283),
    SEASON_1_CHAMPION_KITPVP("season1_champion_kitpvp", "KitPvP §3§lCHAMPION", "§6§lKITPVP", "Finished Top 3 at one of the kitpvp warps", 54),
    MEETUP_CHAMPION("meetup_champion", "Meetup §a§lCHAMPION", "§6§lMEETUP", "Is the most recent meetup event winner", 110),
    SEASON_2_CHAMPION_MATCHMAKING("season2_champion_matchmaking", "1vs1 §5§lCHAMPION", "§5§l1vs1", "Finished Top 3 at 1vs1", 283),
    SEASON_2_CHAMPION_KITPVP("season2_champion_kitpvp", "KitPvP §5§lCHAMPION", "§5§lKITPVP", "Finished Top 3 at one of the kitpvp warps", 54),
    MANAGEMENT("management", "§4§lMANAGEMENT", "", "Is either fleance or PatrickGHG", 152),
    SEASON_3_CHAMPION_MATCHMAKING("season3_champion_matchmaking", "1vs1 §c§lCHAMPION", "§c§l1vs1", "Finished Top 3 at 1vs1", 283),
    SEASON_3_CHAMPION_KITPVP("season3_champion_kitpvp", "KitPvP §c§lCHAMPION", "§c§lKITPVP", "Finished Top 3 at one of the kitpvp warps", 54),
    SEASON_4_CHAMPION_MATCHMAKING("season4_champion_matchmaking", "1vs1 §a§lCHAMPION", "", "Finished Top 3 at 1vs1 in Season 4", 283),
    SEASON_4_CHAMPION_KITPVP("season4_champion_kitpvp", "KitPvP §a§lCHAMPION", "", "Finished Top 3 at FFA or Feast in Season 4", 54),

    NORISK_CLIENT("norisk_client", "§bNoRisk §fClient", ChatColor.BLUE + "NRC", "Moin", 416),
    ;

    @Getter
    private final String name, display, shortDisplay, description;
    @Getter
    private final int item;

    public static Title safeValueOf(String name) {
        return fromEnum(name);
    }

    public static Title fromName(String name) {
        for(Title title : values()){
            if(title.getName().equalsIgnoreCase(name))
                return title;
        }
        return null;
    }

    public static Title fromEnum(String name) {
        for(Title title : values()){
            if(title.name().equalsIgnoreCase(name))
                return title;
        }
        return null;
    }
}