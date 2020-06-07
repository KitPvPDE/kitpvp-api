package net.kitpvp.api;

import net.kitpvp.api.bungee.IBungeeConnection;
import net.kitpvp.api.group.IGroupManager;
import net.kitpvp.api.user.User;
import net.kitpvp.api.user.UserFactory;
import org.bukkit.Bukkit;

import java.util.UUID;

public interface NetworkAPI {

    UserFactory<? extends User> getUserFactory();

    default User getUser(UUID playerId) {
        return getUserFactory().getUser(playerId);
    }

    IBungeeConnection getBungeeConnection();

    IGroupManager getGroupManager();

    @SuppressWarnings("unchecked")
    static <T extends NetworkAPI> T getAPI() {
        return (T) Bukkit.getPluginManager().getPlugin("PluginAPI");
    }
}
