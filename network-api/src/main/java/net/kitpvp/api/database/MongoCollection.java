package net.kitpvp.api.database;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.mongodbapi.database.Collection;

@RequiredArgsConstructor
public enum MongoCollection implements Collection {

    // network
    HEADS("network_heads", "public_db"),

    // kitpvp
    KITPVP_STATS("stats", "kitpvp_db"),

    // norisk
    NORISK_USERS("users", "norisk_db"),

    // web
    WEB_USERS("users", "website_db"),

    // discord
    DC_USERS("users", "discord_db"),

    // ctw
    CTW_MATCHES("ctw_matches", "kitpvp_db"),
    ;

    @Getter
    private final String collectionName;
    @Getter
    private final String databaseName;

    MongoCollection(String collectionName) {
        this(collectionName, "kitpvp_db");
    }

}
