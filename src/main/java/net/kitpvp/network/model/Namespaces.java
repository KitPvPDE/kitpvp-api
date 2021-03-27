package net.kitpvp.network.model;

import net.kitpvp.network.namespace.Namespace;

public interface Namespaces {

    Namespace TITLES = Namespace.builder()
            .name("title")
            .build();
}
