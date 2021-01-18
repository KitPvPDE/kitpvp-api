package net.kitpvp.api;

import net.kitpvp.api.group.GroupManager;
import net.kitpvp.api.spigot.user.IUser;
import net.kitpvp.api.spigot.user.IUserFactory;
import net.kitpvp.chat.api.Connection;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public interface NetworkAPI<T extends IUser> {

    IUserFactory<T, ?> getUserFactory();

    GroupManager getGroupManager();

    int getOnlineCount();

    int getOnlineCount(String serverCategory);

    void getRank(UUID uuid, Consumer<Group> callback);

    void getRanks(List<UUID> uuids, Consumer<Map<UUID, Group>> callback);

    void getName(UUID uuid, Consumer<String> callback);

    void getUUID(String name, Consumer<UUID> callback);

    default Group getGroup(Connection connection) {
        return getGroupManager().getPlayerGroup(connection);
    }

    default Group getGroup(UUID playerId) {
        return getGroupManager().getPlayerGroup(playerId);
    }
}
