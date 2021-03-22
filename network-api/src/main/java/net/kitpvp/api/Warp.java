package net.kitpvp.api;

import net.kitpvp.api.utils.EnumUtils;

public enum Warp {

    NONE,
    FFA,
    PRACTICE,
    TRAINING,
    EARLYHG,
    FEAST,
    EVENT,
    HG,
    NODAMAGE
    ;

    public String getName() {
        switch(this) {
            case HG:
                return "HardcoreGames";
            case FEAST:
                return "Feast";
            case FFA:
                return "1v1fps";
            case EARLYHG:
                return "EarlyHG";
            case NONE:
                return "Spawn";
            case EVENT:
                return "Event";
            case PRACTICE:
                return "1vs1";
            case TRAINING:
                return "Training";
            case NODAMAGE:
                return "NoDamage";
            default:
                return name();
        }
    }

    public String nameToLowercase() {
        return this.name().toLowerCase();
    }

    public static Warp matchIgnoringCase(String name) {
        return EnumUtils.matchIgnoringCase(Warp.class, name);
    }

    @Deprecated
    public static Warp warpFromLowercase(String name) {
        return matchIgnoringCase(name);
    }
}
