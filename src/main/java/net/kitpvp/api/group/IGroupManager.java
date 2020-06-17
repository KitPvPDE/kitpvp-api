package net.kitpvp.api.group;

import net.kitpvp.api.Group;

import java.util.UUID;

public interface IGroupManager {

    Group getPlayerGroup(UUID playerId);

    /*Group getPlayerGroup(Player player);

    Group getPlayerGroup(CommandSender sender);*/
}
