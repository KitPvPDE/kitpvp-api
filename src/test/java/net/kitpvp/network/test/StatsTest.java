package net.kitpvp.network.test;

import net.kitpvp.network.model.Statistics;
import net.kitpvp.stats.Key;
import net.kitpvp.stats.keys.LongStageKey;
import net.kitpvp.stats.keys.LongStatsKey;
import org.junit.Assert;
import org.junit.Test;

public class StatsTest {

    @Test
    public void testRemap() {
        LongStageKey<String> stageKey = LongStatsKey.<String>builder()
                .keyBuilder(builder -> builder.prefix("prefix").function(Key.identity()).suffix("suffix"))
                .offset(1000)
                .stage(Statistics.Remap.seasonPass());

        Assert.assertTrue(stageKey.alltime().key("test").startsWith("alltime."));
        Assert.assertTrue(stageKey.season().key("test").startsWith("seasons."));
        Assert.assertTrue(stageKey.stage().key("test").startsWith("seasonpass."));
    }
}
