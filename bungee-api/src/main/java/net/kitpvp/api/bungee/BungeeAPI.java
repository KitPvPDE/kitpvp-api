package net.kitpvp.api.bungee;

import net.kitpvp.api.NetworkAPI;
import net.kitpvp.api.bungee.user.User;
import net.kitpvp.api.spigot.user.IUserFactory;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public interface BungeeAPI extends NetworkAPI<User> {

    @Override
    IUserFactory<? extends User, ProxiedPlayer> getUserFactory();
}
