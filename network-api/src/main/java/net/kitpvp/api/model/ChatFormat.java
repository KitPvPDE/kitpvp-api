package net.kitpvp.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

@Getter
@RequiredArgsConstructor
public enum ChatFormat implements MsgFormat {

    MATCHMAKING("»", ChatColor.WHITE, ChatColor.WHITE, ChatColor.GRAY),
    NETWORK("»»", ChatColor.DARK_AQUA, ChatColor.WHITE, ChatColor.GRAY),
    KITPVP(">»", ChatColor.GREEN, ChatColor.WHITE, ChatColor.GRAY),
    PUNISHMENT(">»»", ChatColor.RED, ChatColor.RED, ChatColor.DARK_AQUA),
    ;

    private final String prefix;
    private final boolean prefixBold;
    private final ChatColor prefixColor, highlightColor, normalColor;

    ChatFormat(String prefix, ChatColor prefixColor, ChatColor highlightColor, ChatColor normalColor) {
        this(prefix, false, prefixColor, highlightColor, normalColor);
    }

    @Override
    public String formatPrefix() {
        return "" + this.getPrefixColor() + (this.prefixBold ? ChatColor.BOLD : "") + this.getPrefix();
    }

    @Override
    public ComponentBuilder prefixBuilder() {
        return (new ComponentBuilder(this.getPrefix())).color(this.getPrefixColor()).bold(this.prefixBold).append(" ", ComponentBuilder.FormatRetention.NONE).color(this.getNormalColor());
    }
}
