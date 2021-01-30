package net.kitpvp.api;

import net.kitpvp.api.group.GroupManager;
import net.kitpvp.api.spigot.user.IUser;
import net.kitpvp.api.spigot.user.IUserFactory;
import net.kitpvp.chat.api.Connection;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public interface NetworkAPI<T extends IUser> {

    IUserFactory<? extends T, ?> getUserFactory();

    GroupManager getGroupManager();

    int getOnlineCount();

    int getOnlineCount(Warp warp);

    void getRanks(List<UUID> uuids, Consumer<Map<UUID, Group>> callback);

    void getName(UUID uuid, Consumer<String> callback);

    void getUUID(String name, Consumer<UUID> callback);

    default void getRank(UUID uuid, Consumer<Group> callback) {
        this.getRanks(Collections.singletonList(uuid), (map) -> callback.accept(map.getOrDefault(uuid, Group.DEFAULT)));
    }

    default @NotNull Group getGroup(Connection connection) {
        return getGroupManager().getPlayerGroup(connection);
    }

    default @NotNull Group getGroup(UUID playerId) {
        return getGroupManager().getPlayerGroup(playerId);
    }

    static @NotNull Group getPlayerGroup(@NotNull Connection connection) {
        return NetworkPlugin.getPlugin().getApi().getGroup(connection);
    }

    static @NotNull Group getPlayerGroup(@NotNull UUID playerId) {
        return NetworkPlugin.getPlugin().getApi().getGroup(playerId);
    }
}
