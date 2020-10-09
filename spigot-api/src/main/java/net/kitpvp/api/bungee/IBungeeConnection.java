package net.kitpvp.api.bungee;

import net.kitpvp.api.Group;
import net.kitpvp.api.Warp;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public interface IBungeeConnection {

    int getOnlineCount();

    int getOnlineCount(String serverCategory);

    void getRank(UUID uuid, Consumer<Group> callback);

    void getRanks(List<UUID> uuids, Consumer<Map<UUID, Group>> callback);

    void getName(UUID uuid, Consumer<String> callback);

    void getUUID(String name, Consumer<UUID> callback);
}
