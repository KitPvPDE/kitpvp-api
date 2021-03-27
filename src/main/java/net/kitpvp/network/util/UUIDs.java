package net.kitpvp.network.util;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class UUIDs {

    public static UUID fromString(@Nullable String input) {
        if(input == null)
            return null;

        return UUID.fromString(input);
    }
}
