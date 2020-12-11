package net.kitpvp.api.user;

import net.kitpvp.mongodbapi.database.Collection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class UserFactory<T extends User> {

    private final Collection collection;
    private final BiFunction<Collection, Player, T> createFunction;
    private final Map<UUID, T> loadedUsers = new ConcurrentHashMap<>();

    public UserFactory(Collection collection, BiFunction<Collection, Player, T> createFunction) {
        this.collection = collection;
        this.createFunction = createFunction;
    }

    public List<T> getOnlineUsers() {
        return Bukkit.getOnlinePlayers().stream().map(this::getUser).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public T getUser(Player player, boolean load, boolean store) {
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

    public T getUser(Player player) {
        return this.getUser(player, false, false);
    }

    public T getUser(UUID playerId) {
        if(playerId == null)
            return null;

        return this.loadedUsers.get(playerId);
    }

    public T loadUser(Player player, boolean store) {
        return this.getUser(player, true, store);
    }

    public void deleteUser(UUID playerId) {
        this.loadedUsers.remove(playerId);
    }
}
