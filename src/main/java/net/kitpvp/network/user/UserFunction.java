package net.kitpvp.network.user;

import java.util.function.Function;

@FunctionalInterface
public interface UserFunction<Player, T> extends Function<Player, T> {

    @Override
    T apply(Player player);
}
