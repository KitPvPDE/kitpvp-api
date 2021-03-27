package net.kitpvp.network.namespace;

import org.jetbrains.annotations.NotNull;

public interface Namespace {

    static NamespaceBuilder builder() {
        return new NamespaceBuilder();
    }

    @NotNull String getName();

    @NotNull NamespacedKey getKey(String name);
}
