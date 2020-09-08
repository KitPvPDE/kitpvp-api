package net.kitpvp.api;

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
                return "FFA";
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
}
