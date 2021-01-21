package net.kitpvp.api.bungee;

import net.kitpvp.api.NetworkPlugin;
import net.kitpvp.api.bungee.user.User;
import net.md_5.bungee.api.ProxyServer;
import org.jetbrains.annotations.NotNull;

public interface BungeePlugin extends NetworkPlugin<User> {

    @Override
    @NotNull BungeeAPI getApi();

    static BungeePlugin getPlugin() {
        return (BungeePlugin) ProxyServer.getInstance().getPluginManager().getPlugin("WaterfallPlugin");
    }
}
