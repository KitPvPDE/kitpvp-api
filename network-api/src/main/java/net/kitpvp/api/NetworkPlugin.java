package net.kitpvp.api;

import net.kitpvp.api.distribution.Distribution;
import net.kitpvp.api.spigot.user.IUser;
import org.jetbrains.annotations.NotNull;

public interface NetworkPlugin<T extends IUser> {

    @NotNull NetworkAPI<T> getApi();

    static NetworkPlugin<? extends IUser> getPlugin() {
        return Distribution.getPlugin();
    }
}
