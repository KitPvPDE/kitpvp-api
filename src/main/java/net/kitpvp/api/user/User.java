package net.kitpvp.api.user;

import net.kitpvp.pluginapi.modules.stats.Stats;

import java.util.UUID;

public interface User {

    UUID getPlayerId();

    String getPlayerName();

    Stats getStats();

    Group getGroup();

}
