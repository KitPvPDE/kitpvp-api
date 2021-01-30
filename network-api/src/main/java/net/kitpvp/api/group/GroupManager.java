package net.kitpvp.api.group;

import net.kitpvp.api.Group;
import net.kitpvp.chat.api.Connection;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface GroupManager {

    @NotNull Group getPlayerGroup(@NotNull UUID playerId);

    @NotNull Group getPlayerGroup(@NotNull Connection connection);
}
