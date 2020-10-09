package net.kitpvp.api.utils;

import lombok.RequiredArgsConstructor;
import net.kitpvp.chat.api.MsgFormat;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Function;

public class NameUtils {

    public static <T> String joinNames(Iterable<T> iterable, Function<T, String> nameExtractor) {
        return joinNames(iterable, nameExtractor, "", "");
    }

    public static <T> String joinNames(Iterable<T> iterable, Function<T, String> nameExtractor, ChatColor prefix, ChatColor suffix) {
        return joinNames(new MappingIterable<>(iterable, nameExtractor), prefix, suffix);
    }

    public static <T> String joinNames(Iterable<T> iterable, Function<T, String> nameExtractor, MsgFormat format) {
        return joinNames(new MappingIterable<>(iterable, nameExtractor), format.getHighlightColor(), format.getNormalColor());
    }

    public static <T> String joinNames(Iterable<T> iterable, Function<T, String> nameExtractor, String prefix, String suffix) {
        return joinNames(new MappingIterable<>(iterable, nameExtractor), prefix, suffix);
    }

    public static String joinNames(Iterable<? extends String> names) {
        return joinNames(names, "", "");
    }

    public static String joinNames(Iterable<? extends String> names, ChatColor prefix, ChatColor suffix) {
        return joinNames(names, prefix.toString(), suffix.toString());
    }

    public static String joinNames(Iterable<? extends String> names, String prefix, String suffix) {
        StringBuilder builder = new StringBuilder();

        Iterator<? extends String> iterator = names.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();

            if(builder.length() > 0){
                if(iterator.hasNext()){
                    builder.append(", ");
                }else{
                    builder.append(" and ");
                }
            }

            builder.append(prefix).append(name).append(suffix);
        }

        return builder.toString();
    }

    @RequiredArgsConstructor
    private static class MappingIterable<T, R> implements Iterable<R> {

        private final Iterable<T> iterable;
        private final Function<T, R> mapping;

        @Override
        @NotNull
        public Iterator<R> iterator() {
            return new MappingIterator<>(this.iterable.iterator(), this.mapping);
        }
    }

    @RequiredArgsConstructor
    private static class MappingIterator<T, R> implements Iterator<R> {

        private final Iterator<T> iterator;
        private final Function<T, R> mapping;

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public R next() {
            return this.mapping.apply(this.iterator.next());
        }

        @Override
        public void remove() {
            this.iterator.remove();
        }
    }
}
