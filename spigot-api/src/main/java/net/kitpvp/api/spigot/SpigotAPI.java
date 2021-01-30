package net.kitpvp.api.spigot;

import net.kitpvp.api.NetworkAPI;
import net.kitpvp.api.spigot.user.IUserFactory;
import net.kitpvp.api.spigot.user.User;
import net.kitpvp.api.spigot.user.UserFactory;
import org.bukkit.entity.Player;

public interface SpigotAPI extends NetworkAPI<User> {

    @Override
    UserFactory<? extends User> getUserFactory();
}
