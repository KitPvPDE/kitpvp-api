package net.kitpvp.api.group;

import net.kitpvp.api.Group;
import net.kitpvp.chat.api.Connection;

import java.util.UUID;

public interface GroupManager {

    Group getPlayerGroup(UUID playerId);

    Group getPlayerGroup(Connection connection);
}
