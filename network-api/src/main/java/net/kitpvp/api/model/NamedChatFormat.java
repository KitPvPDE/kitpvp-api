package net.kitpvp.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

@Getter
@RequiredArgsConstructor
public enum NamedChatFormat implements MsgFormat {

    SEASON_PASS("SeasonPass", ChatColor.WHITE, ChatColor.RED, ChatColor.RED, ChatColor.GRAY),
    ALERT("?", ChatColor.WHITE, ChatColor.LIGHT_PURPLE, ChatColor.RED, ChatColor.GRAY),
    TOURNAMENT("Tournament", ChatColor.WHITE, ChatColor.RED, ChatColor.YELLOW, ChatColor.GRAY)
    ;

    private final String prefix;
    private final ChatColor prefixColor, innerPrefixColor, highlightColor, normalColor;

    @Override
    public String formatPrefix() {
        return "" + this.getPrefixColor() + "[" + this.getInnerPrefixColor() + this.getPrefix() + this.getPrefixColor() + "]";
    }

    @Override
    public ComponentBuilder prefixBuilder() {
        return new ComponentBuilder("[").color(this.prefixColor).append(this.prefix).color(this.innerPrefixColor).
                append("]").color(this.prefixColor).append(" ", ComponentBuilder.FormatRetention.NONE).color(this.normalColor);
    }
}
