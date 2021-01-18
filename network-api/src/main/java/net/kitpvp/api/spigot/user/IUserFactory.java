package net.kitpvp.api.spigot.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface IUserFactory<T extends IUser, Player> {

    List<T> getOnlineUsers();

    @Nullable T getUser(Player player, boolean load, boolean store);

    @NotNull T getUser(Player player);

    @Nullable T getUser(UUID playerId);

    T loadUser(Player player, boolean store);

    void deleteUser(UUID playerId);
}
