package net.kitpvp.network.namespace;

public interface NamespacedKey {

    Namespace getNamespace();

    String getName();

    default String getIdentifier() {
        return getNamespace().getName() + ":" + getName();
    }
}
