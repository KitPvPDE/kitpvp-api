package net.kitpvp.api.impl;

import net.kitpvp.api.NetworkAPI;

import java.lang.reflect.Method;

public class SpigotPluginResolver implements PluginResolver {

    @Override
    public NetworkAPI getAPI() {
        try {
            Class<?> bukkitClass = Class.forName("org.bukkit.Bukkit");
            Method getPluginManager = bukkitClass.getDeclaredMethod("getPluginManager");
            Object pluginManager = getPluginManager.invoke(null);
            Class<?> pluginManagerClass = Class.forName("org.bukkit.plugin.PluginManager");
            Method getPlugin = pluginManagerClass.getDeclaredMethod("getPlugin", String.class);
            return (NetworkAPI) getPlugin.invoke(pluginManager, "PluginAPI");
        } catch(Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
