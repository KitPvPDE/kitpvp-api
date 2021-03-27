package net.kitpvp.network.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiPredicate;

public class EnumUtils {

    public static <T extends Enum<T>> String nameToLowercase(T t) {
        return t.name().toLowerCase();
    }

    public static <E extends Enum<E>> E match(@NotNull Class<E> enumClass, @Nullable String name) {
        return match(enumClass, String::equals, name);
    }

    public static <E extends Enum<E>> E matchIgnoringCase(@NotNull Class<E> enumClass, @Nullable String name) {
        return match(enumClass, String::equalsIgnoreCase, name);
    }

    public static <E extends Enum<E>> E match(@NotNull Class<E> enumClass, @NotNull BiPredicate<String, String> test, @Nullable String name) {
        if(name == null)
            return null;

        for(E element : enumClass.getEnumConstants()) {
            if(test.test(element.name(), name)) {
                return element;
            }
        }
        return null;
    }
}
