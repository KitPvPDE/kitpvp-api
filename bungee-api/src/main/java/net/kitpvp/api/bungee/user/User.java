package net.kitpvp.api.bungee.user;

import net.kitpvp.api.bungee.BungeePlugin;
import net.kitpvp.api.spigot.user.IUser;
import net.kitpvp.chat.api.Connection;
import net.kitpvp.network.translation.LocaleManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.UUID;

public interface User extends IUser, Connection {

    default boolean isOnline() {
        return ProxyServer.getInstance().getPlayer(this.getPlayerId()) != null;
    }

    @Override
    default Locale getLocale() {
        Connection connection = ProxyServer.getInstance().getPlayer(this.getPlayerId());
        if(connection != null){
            return connection.getLocale();
        }
        return LocaleManager.DEFAULT;
    }

    @Override
    default void sendMessage(BaseComponent... baseComponents) {
        Connection connection = ProxyServer.getInstance().getPlayer(this.getPlayerId());
        if(connection != null){
            connection.sendMessage(baseComponents);
        }
    }

    static @Nullable User getUser(UUID playerId) {
        return BungeePlugin.getPlugin().getNetworkApi().getUserFactory().getUser(playerId);
    }
}
