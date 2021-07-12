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
    private final Function<Player, T> createFunction;
    private final Map<UUID, T> loadedUsers = new ConcurrentHashMap<>();

    public UserFactory(Function<Player, UUID> uuidFunction, Supplier<Collection<? extends Player>> onlineFunction, Function<UUID, T> createFunction) {
        this.uuidFunction = uuidFunction;
        this.onlineFunction = onlineFunction;
        this.createFunction = player ->
                createFunction.apply(this.uuidFunction.apply(player));
    }

    public UserFactory(Function<Player, UUID> uuidFunction, Supplier<Collection<? extends Player>> onlineFunction, UserFunction<Player, T> createFunction) {
        this.uuidFunction = uuidFunction;
        this.onlineFunction = onlineFunction;
        this.createFunction = createFunction;
    }

    public List<T> getOnlineUsers() {
        return this.onlineFunction.get().stream()
                .map(this::getNullableUser)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<T> getUsers() {
        return new ArrayList<>(this.loadedUsers.values());
    }

    public @NotNull T getUser(Player player) {
        if (player == null)
            throw new NullPointerException("player");

        T user = this.getUser(this.uuidFunction.apply(player));
        if (user == null)
            throw new IllegalStateException("User " + this.uuidFunction.apply(player) + " is not online");

        return user;
    }

    public @Nullable T getNullableUser(Player player) {
        if(player == null)
            return null;

        return this.getUser(this.uuidFunction.apply(player));
    }

    public @Nullable T getUser(UUID playerId) {
        if (playerId == null)
            return null;

        return this.loadedUsers.get(playerId);
    }

    public T loadUser(Player player, boolean store) {
        T user = this.getUser(this.uuidFunction.apply(player));
        if(user != null)
            return user;

        user = this.createFunction.apply(player);
        if (user == null)
            throw new IllegalStateException("User " + this.uuidFunction.apply(player) + " was created but is null");

        if(store) {
            this.loadedUsers.put(this.uuidFunction.apply(player), user);
        }

        return user;
    }

    public void deleteUser(UUID playerId) {
        this.loadedUsers.remove(playerId);
    }
}
