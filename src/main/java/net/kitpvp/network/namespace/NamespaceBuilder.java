package net.kitpvp.network.namespace;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

public class NamespaceBuilder {

    private String name;

    NamespaceBuilder() { }

    public NamespaceBuilder name(String name) {
        this.name = name;
        return this;
    }

    public Namespace build() {
        Preconditions.checkNotNull(this.name, "name");

        return new NamespaceImpl(this.name);
    }

    @Getter
    @RequiredArgsConstructor
    class NamespaceImpl implements Namespace {

        private final String name;

        @Override
        public @NotNull NamespacedKey getKey(String name) {
            return new NamespacedKeyImpl(this, name);
        }
    }

    @Getter
    @RequiredArgsConstructor
    class NamespacedKeyImpl implements NamespacedKey {

        private final Namespace namespace;
        private final String name;
    }
}
