package net.kitpvp.api.impl;

import net.kitpvp.api.NetworkAPI;
import net.kitpvp.mongodbapi.async.distribution.Distribution;

public interface PluginResolver {

    NetworkAPI getAPI();

    static PluginResolver getResolver() {
        return Distribution.isSpigot() ? new SpigotPluginResolver() : new BungeePluginResolver();
    }
}
