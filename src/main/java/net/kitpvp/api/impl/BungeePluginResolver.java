package net.kitpvp.api.impl;

import net.kitpvp.api.NetworkAPI;

import java.lang.reflect.Method;

public class BungeePluginResolver implements PluginResolver {

    @Override
    public NetworkAPI getAPI() {
        try {
            Class<?> proxyClass = Class.forName("net.md_5.bungee.api.ProxyServer");
            Class<?> pluginManagerClass = Class.forName("net.md_5.bungee.api.plugin.PluginManager");
            Method getInstance = proxyClass.getDeclaredMethod("getInstance");
            Object instance = getInstance.invoke(null);
            Method getPluginManager = proxyClass.getDeclaredMethod("getPluginManager");
            Object pluginManager = getPluginManager.invoke(instance);
            Method getPlugin = pluginManagerClass.getDeclaredMethod("getPlugin", String.class);

            return (NetworkAPI) getPlugin.invoke(pluginManager, "WaterfallPlugin");
        } catch(Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
