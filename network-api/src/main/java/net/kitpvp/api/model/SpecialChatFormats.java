package net.kitpvp.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

@Getter
@RequiredArgsConstructor
public enum SpecialChatFormats implements MsgFormat {

    NORISK_CLIENT("NRC >>", ChatColor.AQUA, ChatColor.AQUA, ChatColor.GRAY) {
        @Override
        public String formatPrefix() {
            return "" + this.getPrefixColor() + ChatColor.BOLD + "NRC" + this.getPrefixColor() + " »";
        }

        @Override
        public ComponentBuilder prefixBuilder() {
            return new ComponentBuilder("NRC").
                    color(this.getPrefixColor()).
                    bold(true).
                    append(" ", ComponentBuilder.FormatRetention.NONE).
                    color(this.getPrefixColor()).
                    append("»").
                    append(" ", ComponentBuilder.FormatRetention.NONE).
                    color(this.getNormalColor());
        }
    }
    ;

    private final String prefix;
    private final boolean prefixBold;
    private final ChatColor prefixColor, highlightColor, normalColor;

    SpecialChatFormats(String prefix, ChatColor prefixColor, ChatColor highlightColor, ChatColor normalColor) {
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