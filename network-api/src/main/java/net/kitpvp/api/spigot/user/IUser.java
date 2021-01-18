package net.kitpvp.api.spigot.user;

import net.kitpvp.api.Group;
import net.kitpvp.stats.mongodb.MongoStats;

import java.util.UUID;

public interface IUser {

    UUID getPlayerId();

    String getPlayerName();

    MongoStats getMongoStats();

    Group getGroup();

    boolean isLoaded();

    boolean isOnline();

    default boolean isOffline() {
        return !isOnline();
    }
}
