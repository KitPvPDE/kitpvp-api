package net.kitpvp.api.bungee;

import net.kitpvp.api.Group;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public interface IBungeeConnection {

    void getRank(UUID uuid, Consumer<Group> callback);

    void getRanks(List<UUID> uuids, Consumer<Map<UUID, Group>> callback);
}
