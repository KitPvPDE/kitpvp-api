package net.kitpvp.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public interface BungeeConnection {

    void getRank(UUID uuid, Consumer<Group> callback);

    void getRanks(List<UUID> uuids, Consumer<Map<UUID, Group>> callback);
}
