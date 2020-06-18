package net.kitpvp.api;

import net.kitpvp.api.bungee.IBungeeConnection;
import net.kitpvp.api.group.IGroupManager;
import net.kitpvp.api.user.User;
import net.kitpvp.api.user.UserFactory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface NetworkAPI {

    UserFactory<? extends User> getUserFactory();

    IBungeeConnection getBungeeConnection();

    IGroupManager getGroupManager();

    default User getUser(UUID playerId) {
        return getUserFactory().getUser(playerId);
    }

    default Group getGroup(Player player) {
        return getGroupManager().getPlayerGroup(player);
    }

    @SuppressWarnings("unchecked")
    static <T extends NetworkAPI> T getAPI() {
        return (T) Bukkit.getPluginManager().getPlugin("PluginAPI");
    }

    static Group getPlayerGroup(Player player) {
        return getAPI().getGroup(player);
    }
}
