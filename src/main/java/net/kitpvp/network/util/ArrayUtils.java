package net.kitpvp.network.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class ArrayUtils {

    public static <T, C extends Collection<T>> C asCollection(T[] values, Supplier<C> supplier) {
        C c = supplier.get();
        c.addAll(Arrays.asList(values));

        return c;
    }

    @SafeVarargs
    public static <T> Set<T> asSet(T... values) {
        return asSet(HashSet::new, values);
    }

    @SafeVarargs
    public static <T, C extends Set<T>> C asSet(Supplier<C> supplier, T... values) {
        return asCollection(values, supplier);
    }

}
