package net.kitpvp.api.model;

import lombok.RequiredArgsConstructor;
import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;

@RequiredArgsConstructor
public enum NoPrefixFormat implements MsgFormat {

    MATCHMAKING(ChatFormat.MATCHMAKING),
    NETWORK(ChatFormat.NETWORK),
    KITPVP(ChatFormat.KITPVP),
    ;

    private final MsgFormat handle;

    @Override
    public String getPrefix() {
        return this.handle.getPrefix();
    }

    @Override
    public ChatColor getPrefixColor() {
        return this.handle.getPrefixColor();
    }

    @Override
    public ChatColor getHighlightColor() {
        return this.handle.getHighlightColor();
    }

    @Override
    public ChatColor getNormalColor() {
        return this.handle.getNormalColor();
    }

    @Override
    public String buildPrefix() {
        return "" + this.getNormalColor();
    }

    @Override
    public ComponentBuilder prefixBuilder() {
        return new ComponentBuilder("").color(this.getNormalColor());
    }


}
