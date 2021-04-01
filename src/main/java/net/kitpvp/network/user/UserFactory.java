package net.kitpvp.network.user;

import net.kitpvp.chat.api.Connection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class UserFactory<T, Player extends Connection> {

    private final Function<Player, UUID> uuidFunction;
    private final Supplier<Collection<? extends Player>> onlineFunction;
    private final Function<UUID, T> createFunction;
    private final Map<UUID, T> loadedUsers = new ConcurrentHashMap<>();

    public UserFactory(Function<Player, UUID> uuidFunction, Supplier<Collection<? extends Player>> onlineFunction, Function<UUID, T> createFunction) {
        this.uuidFunction = uuidFunction;
        this.onlineFunction = onlineFunction;
        this.createFunction = createFunction;
    }

    public List<T> getOnlineUsers() {
        return this.onlineFunction.get().stream()
                .map(this::getUser)
                .collect(Collectors.toList());
    }

    public List<T> getUsers() {
        return new ArrayList<>(this.loadedUsers.values());
    }

    @Nullable
    public T getUser(Player player, boolean load, boolean store) {
        if (player == null)
            return null;

        return getUser(this.uuidFunction.apply(player), load, store);
    }

    @Nullable
    public T getUser(UUID uuid, boolean load, boolean store) {
        if (uuid == null)
            return null;

        if (this.loadedUsers.containsKey(uuid))
            return this.loadedUsers.get(uuid);

        if (!load)
            return null;

        T user = this.createFunction.apply(uuid);
        if (store)
            this.loadedUsers.put(uuid, user);

        return user;
    }

    public @NotNull T getUser(Player player) {
        if (player == null)
            throw new NullPointerException("player");

        T user = this.getUser(player, false, false);
        if (user == null)
            throw new IllegalStateException("User " + this.uuidFunction.apply(player) + " is not online");

        return user;
    }

    public T getUser(UUID playerId) {
        if (playerId == null)
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
