package net.kitpvp.api.utils;

public class EnumUtils {

    public static <T extends Enum<T>> String nameToLowercase(T t) {
        return t.name().toLowerCase();
    }

    public static <E extends Enum<E>> E match(Class<E> enumClass, String name) {
        for(E element : enumClass.getEnumConstants()) {
            if(name.equals(element.name()))
                return element;
        }

        return null;
    }

    public static <E extends Enum<E>> E matchIgnoringCase(Class<E> enumClass, String name) {
        for(E element : enumClass.getEnumConstants()) {
            if(name.equalsIgnoreCase(element.name()))
                return element;
        }

        return null;
    }
}
