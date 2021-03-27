package net.kitpvp.network.mongodb;

import net.kitpvp.mongodbapi.database.Collection;
import net.kitpvp.mongodbapi.database.Database;
import net.kitpvp.stats.StatsReader;
import net.kitpvp.stats.mongodb.MongoStats;

import java.util.UUID;
import java.util.function.Consumer;

public class CallbackMongoStats extends MongoStats {

    private final Consumer<StatsReader> loadCallback;

    public CallbackMongoStats(UUID playerId, Collection collection, Consumer<StatsReader> loadCallback) {
        super(playerId, collection);
        this.loadCallback = loadCallback;
    }

    @Override
    public StatsReader load(Database database) {
        StatsReader statsReader = super.load(database);
        this.loadCallback.accept(statsReader);
        return statsReader;
    }
}
