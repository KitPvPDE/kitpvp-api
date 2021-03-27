package net.kitpvp.network;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kitpvp.network.model.Namespaces;
import net.kitpvp.network.namespace.Namespace;
import net.kitpvp.network.namespace.NamespacedKey;
import net.kitpvp.network.util.EnumUtils;
import org.jetbrains.annotations.NotNull;

@RequiredArgsConstructor
public enum Title {

    SUMO_CHAMPION(Namespaces.TITLES, "sumo_champion"),
    MATCHMAKING_CHAMPION(Namespaces.TITLES, "matchmaking_champion"),
    KITPVP_CHAMPION(Namespaces.TITLES, "kitpvp_champion")
    ;

    @Getter
    private final NamespacedKey key;

    Title(Namespace namespace, String name) {
        this.key = namespace.getKey(name);
    }

    public final String getName() {
        return this.key.getName();
    }

    public static Title getTitle(String name) {
        return EnumUtils.matchIgnoringCase(Title.class, name);
    }

    public static Title getTitle(@NotNull NamespacedKey key) {
        return getTitle(key.getName());
    }
}
