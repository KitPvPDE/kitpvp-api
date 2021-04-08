package net.kitpvp.network.chat;

import lombok.RequiredArgsConstructor;
import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;

@RequiredArgsConstructor
public class NoPrefixFormats extends ChatFormats {

    public static final MsgFormat SEASON_PASS = builder()
            .noPrefix()
            .highlightColor(ChatColor.RED)
            .normalColor(ChatColor.GRAY)
            .build();
    public static final MsgFormat MATCHMAKING = builder()
            .noPrefix()
            .highlightColor(ChatColor.GREEN)
            .normalColor(ChatColor.GRAY)
            .build();
    public static final MsgFormat GLOBAL = builder()
            .noPrefix()
            .highlightColor(ChatColor.RED)
            .build();
    public static final MsgFormat KITPVP = builder()
            .noPrefix()
            .highlightColor(ChatColor.GREEN)
            .build();
    public static final MsgFormat PUNISHMENT = builder()
            .noPrefix()
            .highlightColor(ChatColor.RED)
            .normalColor(ChatColor.DARK_AQUA)
            .build();
}