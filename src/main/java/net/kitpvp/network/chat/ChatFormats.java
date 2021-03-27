package net.kitpvp.network.chat;

import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;

public class ChatFormats {

    public static final MsgFormat SEASON_PASS = builder()
            .prefixBrackets(true)
            .prefixColor(ChatColor.WHITE)
            .innerPrefixColor(ChatColor.RED)
            .prefix("SeasonPass")
            .highlightColor(ChatColor.RED)
            .normalColor(ChatColor.GRAY)
            .build();
    public static final MsgFormat MATCHMAKING = builder()
            .prefixBrackets(true)
            .prefixColor(ChatColor.WHITE)
            .innerPrefixColor(ChatColor.GREEN)
            .prefix("1vs1")
            .highlightColor(ChatColor.GREEN)
            .normalColor(ChatColor.GRAY)
            .build();
    public static final MsgFormat GLOBAL = builder()
            .prefix("»»")
            .prefixColor(ChatColor.DARK_RED)
            .highlightColor(ChatColor.RED)
            .build();
    public static final MsgFormat KITPVP = builder()
            .prefixBrackets(true)
            .prefixColor(ChatColor.WHITE)
            .innerPrefixColor(ChatColor.YELLOW)
            .prefix("KitPvP")
            .highlightColor(ChatColor.GREEN)
            .build();
    public static final MsgFormat PUNISHMENT = builder()
            .prefix(">»»")
            .prefixColor(ChatColor.RED)
            .highlightColor(ChatColor.RED)
            .normalColor(ChatColor.DARK_AQUA)
            .build();

    public static FormatBuilder builder() {
        return new FormatBuilder();
    }

}
