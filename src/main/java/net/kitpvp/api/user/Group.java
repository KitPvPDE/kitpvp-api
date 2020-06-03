package net.kitpvp.api.user;

public interface Group {

    int ordinal();

    default int getPower() {
        return this.ordinal();
    }

    default boolean isHigher(Group other) {
        return this.getPower() < other.getPower();
    }

    default boolean isHigherOrEqual(Group other) {
        return this.getPower() <= other.getPower();
    }

    default boolean isLower(Group other) {
        return this.getPower() > other.getPower();
    }

    default boolean isLowerOrEqual(Group other) {
        return this.getPower() >= other.getPower();
    }

    default boolean isEqual(Group other) {
        return this.getPower() == other.getPower();
    }
}
