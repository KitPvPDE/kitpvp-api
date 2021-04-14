package net.kitpvp.network;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.network.namespace.NamespacedKey;
import net.kitpvp.network.util.EnumUtils;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public enum Title {

    SUMO_CHAMPION("title", "sumo_champion"),
    MATCHMAKING_CHAMPION("title", "matchmaking_champion"),
    KITPVP_CHAMPION("title", "kitpvp_champion")
    ;

    @Getter
    private final NamespacedKey key;

    Title(String namespace, String name) {
        this.key = NamespacedKey.key(namespace, name);
    }

    public final String getName() {
        return this.key.getKey();
    }

    public static Title getTitle(String name) {
        return EnumUtils.matchIgnoringCase(Title.class, name);
    }

    public static Title getTitle(@NotNull NamespacedKey key) {
        return getTitle(key.getKey());
    }
}
