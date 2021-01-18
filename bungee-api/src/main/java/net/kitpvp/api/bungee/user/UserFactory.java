package net.kitpvp.api.bungee.user;

import net.kitpvp.api.spigot.user.IUserFactory;
import net.kitpvp.mongodbapi.database.Collection;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class UserFactory<T extends User> implements IUserFactory<T, ProxiedPlayer> {

    private final Collection collection;
    private final BiFunction<Collection, ProxiedPlayer, T> createFunction;
    private final Map<UUID, T> loadedUsers = new ConcurrentHashMap<>();

    public UserFactory(Collection collection, BiFunction<Collection, ProxiedPlayer, T> createFunction) {
        this.collection = collection;
        this.createFunction = createFunction;
    }

    public List<T> getOnlineUsers() {
        return ProxyServer.getInstance().getPlayers().stream().map(this::getUser).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Nullable
    public T getUser(ProxiedPlayer player, boolean load, boolean store) {
        if(player == null)
            return null;

        if(this.loadedUsers.containsKey(player.getUniqueId()))
            return this.loadedUsers.get(player.getUniqueId());

        if(!load)
            return null;

        T user = this.createFunction.apply(this.collection, player);
        if(store)
            this.loadedUsers.put(player.getUniqueId(), user);

        return user;
    }

    public @NotNull T getUser(ProxiedPlayer player) {
        return this.getUser(player, false, false);
    }

    public T getUser(UUID playerId) {
        if(playerId == null)
            return null;

        return this.loadedUsers.get(playerId);
    }

    public T loadUser(ProxiedPlayer player, boolean store) {
        return this.getUser(player, true, store);
    }

    public void deleteUser(UUID playerId) {
        this.loadedUsers.remove(playerId);
    }
}
