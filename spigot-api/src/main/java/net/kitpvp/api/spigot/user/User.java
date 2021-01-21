package net.kitpvp.api.spigot.user;

import net.kitpvp.api.spigot.SpigotPlugin;
import net.kitpvp.chat.api.player.ChatConnection;
import net.kitpvp.network.translation.LocaleManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.UUID;

public interface User extends IUser, ChatConnection {

    default boolean isOnline() {
        return Bukkit.getPlayer(this.getPlayerId()) != null;
    }

    @Override
    default Locale getLocale() {
        ChatConnection connection = Bukkit.getPlayer(this.getPlayerId());
        if(connection != null){
            return connection.getLocale();
        }
        return LocaleManager.DEFAULT;
    }

    @Override
    default void sendMessage(ChatMessageType chatMessageType, BaseComponent... baseComponents) {
        ChatConnection connection = Bukkit.getPlayer(this.getPlayerId());
        if(connection != null){
            connection.sendMessage(chatMessageType, baseComponents);
        }
    }

    @Override
    default void sendMessage(BaseComponent... baseComponents) {
        this.sendMessage(ChatMessageType.CHAT, baseComponents);
    }

    static @Nullable User getUser(UUID playerId) {
        return SpigotPlugin.getPlugin().getApi().getUserFactory().getUser(playerId);
    }
}
