package net.kitpvp.api.distribution;

import lombok.RequiredArgsConstructor;
import net.kitpvp.api.NetworkPlugin;
import net.kitpvp.api.spigot.user.IUser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public enum Distribution {

    SPIGOT("org.bukkit.Bukkit", "net.kitpvp.pluginapi.NetworkPlugin"),
    BUNGEE("net.md_5.bungee.api.ProxyServer", "net.kitpvp.network.waterfall.WaterfallPlugin"),
    UNKNOWN("java.lang.Object", "java.lang.String");

    private final String distributionClass, pluginClass;
    private final Class<?> distribution, plugin;
    private final NetworkPlugin<? extends IUser> pluginImpl;

    Distribution(String distributionClass, String pluginClass) {
        this.distributionClass = distributionClass;
        this.pluginClass = pluginClass;

        this.distribution = this.loadClass(this.distributionClass);
        this.plugin = this.loadClass(this.pluginClass);
        this.pluginImpl = this.loadPlugin();
    }

    public boolean isLive() {
        return this.distribution != null;
    }

    public NetworkPlugin<? extends IUser> getPluginImpl() {
        return this.pluginImpl;
    }

    private Class<?> loadClass(String qualifiedName) {
        try{
            return Class.forName(qualifiedName);
        }catch(ClassNotFoundException cause){
            return null;
        }
    }

    private NetworkPlugin<? extends IUser> loadPlugin() {
        if(this == UNKNOWN || this.plugin == null)
            return null;

        try{
            Method getInstance = this.plugin.getDeclaredMethod("getInstance");
            Object instance = getInstance.invoke(null);

            if(instance instanceof NetworkPlugin){
                NetworkPlugin<?> plugin = (NetworkPlugin<?>) instance;
                return plugin;
            }
        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored){ }
        return null;
    }

    private static final Distribution live;

    static {
        Distribution found = null;
        for(Distribution distribution : values()){
            if(distribution.isLive()){
                found = distribution;
                break;
            }
        }

        live = found;

        if(live.getPluginImpl() == null){
            System.err.println("[WARN] Could not load plugin despite being on platform " + live);
        }
    }

    public static NetworkPlugin<? extends IUser> getPlugin() {
        return live.getPluginImpl();
    }

    public static void main(String[] args) {
        System.out.println(getPlugin());
    }
}
