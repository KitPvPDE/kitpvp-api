package net.kitpvp.network.namespace;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NamespacedKey {

    public static NamespacedKey key(String namespace, String name) {
        return new NamespacedKey(namespace, name);
    }

    public static NamespacedKey key(String identifier) {
        int index = identifier.indexOf(':');
        if(index <= 0)
            throw new IllegalArgumentException("Unknown key spec: '" + identifier + "'");

        return key(identifier.substring(0, index), identifier.substring(index + 1));
    }

    private final String namespace;
    private final String key;

    public String toString() {
        return namespace + ":" + key;
    }
}
