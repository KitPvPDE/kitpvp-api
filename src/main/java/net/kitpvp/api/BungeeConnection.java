package net.kitpvp.api;

import java.util.UUID;
import java.util.function.Consumer;

public interface BungeeConnection {

    void getRank(UUID uuid, Consumer<Group> callback);

}
