package net.kitpvp.network.user;

import net.kitpvp.chat.api.player.ChatConnection;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;

import java.util.Locale;
import java.util.UUID;

public interface User extends ChatConnection {

    UUID getPlayerId();

    String getPlayerName();

    ChatConnection getPlayer();

    boolean isOnline();

    default boolean isOffline() {
        return !this.isOnline();
    }

    @Override
    default void sendMessage(ChatMessageType chatMessageType, BaseComponent... baseComponents) {
        this.getPlayer().sendMessage(chatMessageType, baseComponents);
    }

    @Override
    default void sendMessage(BaseComponent... baseComponents) {
        this.getPlayer().sendMessage(baseComponents);
    }

    @Override
    default boolean supportsLineFeed() {
        return this.getPlayer().supportsLineFeed();
    }

    @Override
    default Locale getLocale() {
        return this.getPlayer().getLocale();
    }
}
