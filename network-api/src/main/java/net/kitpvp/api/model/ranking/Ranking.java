package net.kitpvp.api.model.ranking;

import net.kitpvp.api.utils.ArrayUtils;

import java.util.Set;

public interface Ranking {

    Set<String> KITPVP_RANKINGS =
            ArrayUtils.asSet("ffa", "feast", "earlyhg");
    Set<String> HUB_RANKINGS =
            ArrayUtils.asSet("ranked", "sumo");

}
