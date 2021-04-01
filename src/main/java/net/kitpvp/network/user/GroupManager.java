package net.kitpvp.network.user;

import net.kitpvp.chat.api.Connection;
import net.kitpvp.network.Group;

import java.util.UUID;

public interface GroupManager {

    Group getPlayerGroup(UUID uuid);

    Group getPlayerGroup(Connection connection);
}
