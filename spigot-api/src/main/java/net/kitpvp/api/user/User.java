package net.kitpvp.api.user;

import net.kitpvp.api.Group;
import net.kitpvp.api.NetworkAPI;
import net.kitpvp.pluginapi.modules.stats.Stats;
import org.bukkit.Bukkit;

import java.util.UUID;

public interface User {

    UUID getPlayerId();

    String getPlayerName();

    Stats getStats();

    Group getGroup();

    boolean isLoaded();

    default boolean isOnline() {
        return Bukkit.getPlayer(this.getPlayerId()) != null;
    }

    default boolean isOffline() {
        return !isOnline();
    }

    static User getUser(UUID playerId) {
        return NetworkAPI.getAPI().getUser(playerId);
    }
}
