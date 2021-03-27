package net.kitpvp.network.chat;

import com.google.common.base.Preconditions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class FormatBuilder {

    private boolean brackets, prefixBold = false;
    private String prefix;
    private ChatColor prefixColor, innerPrefixColor, highlightColor, normalColor = ChatColor.GRAY;

    public FormatBuilder normalColor(ChatColor color) {
        this.normalColor = color;
        return this;
    }

    public FormatBuilder highlightColor(ChatColor color) {
        this.highlightColor = color;
        return this;
    }

    public FormatBuilder prefixColor(ChatColor color) {
        this.prefixColor = color;
        return this;
    }

    public FormatBuilder innerPrefixColor(ChatColor color) {
        this.innerPrefixColor = color;
        return this;
    }

    public FormatBuilder prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    public FormatBuilder prefixBold(boolean bold) {
        this.prefixBold = bold;
        return this;
    }

    public FormatBuilder prefixBrackets(boolean brackets) {
        this.brackets = brackets;
        return this;
    }

    public FormatBuilder noPrefix() {
        this.prefix = "";
        return this;
    }

    public MsgFormat build() {
        Preconditions.checkNotNull(this.prefix, "prefix");
        Preconditions.checkNotNull(this.prefixColor, "prefixColor");
        Preconditions.checkState(this.innerPrefixColor != null || !this.brackets, "innerPrefixColor");
        Preconditions.checkNotNull(this.highlightColor, "highlightColor");
        Preconditions.checkNotNull(this.normalColor, "normalColor");

        return new MsgFormatImpl(this.brackets, this.prefixBold, this.prefix, this.prefixColor,
                this.innerPrefixColor, this.highlightColor, this.normalColor);
    }

    @Getter
    @RequiredArgsConstructor
    private class MsgFormatImpl implements MsgFormat {

        private final boolean brackets, prefixBold;
        private final String prefix;
        private final ChatColor prefixColor, innerPrefixColor, highlightColor, normalColor;

        @Override
        public String formatPrefix() {
            if (this.brackets) {
                return ""
                        + this.prefixColor
                        + "["
                        + this.innerPrefixColor
                        + (this.prefixBold ? ChatColor.BOLD : "")
                        + this.getPrefix()
                        + this.getPrefixColor()
                        + "]";
            } else if (!this.prefix.isEmpty()) {
                return ""
                        + this.getPrefixColor()
                        + (this.isPrefixBold() ? ChatColor.BOLD : "")
                        + this.getPrefix();
            } else {
                return ""
                        + this.normalColor;
            }
        }

        @Override
        public ComponentBuilder prefixBuilder() {
            if (this.brackets) {
                return new ComponentBuilder("[")
                        .color(this.prefixColor)
                        .bold(this.prefixBold)
                        .append(this.prefix)
                        .color(this.innerPrefixColor)
                        .append("]")
                        .color(this.prefixColor)
                        .append(" ", ComponentBuilder.FormatRetention.NONE)
                        .color(this.normalColor);
            } else if (!this.prefix.isEmpty()) {
                return new ComponentBuilder(this.prefix)
                        .color(this.prefixColor)
                        .bold(this.prefixBold)
                        .append(" ", ComponentBuilder.FormatRetention.NONE)
                        .color(this.normalColor);
            } else {
                return new ComponentBuilder("")
                        .color(this.normalColor);
            }
        }
    }
}
