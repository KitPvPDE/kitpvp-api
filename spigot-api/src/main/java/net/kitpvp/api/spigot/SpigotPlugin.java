package net.kitpvp.api.spigot;

import net.kitpvp.api.NetworkPlugin;
import net.kitpvp.api.spigot.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface SpigotPlugin extends NetworkPlugin<User> {

    @Override
    @NotNull SpigotAPI getApi();

    static SpigotPlugin getPlugin() {
        return (SpigotPlugin) Bukkit.getPluginManager().getPlugin("PluginAPI");
    }

    static @NotNull User getUser(Player player) {
        return getPlugin().getApi().getUserFactory().getUser(player);
    }

    static @Nullable User getUser(UUID playerId) {
        return getPlugin().getApi().getUserFactory().getUser(playerId);
    }
}
