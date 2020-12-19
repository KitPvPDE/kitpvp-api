package net.kitpvp.test;

import net.kitpvp.api.model.stats.*;
import net.kitpvp.stats.StatsReader;
import net.kitpvp.stats.bson.BsonStatsReader;
import net.kitpvp.stats.reader.Reader;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStats {

    @Test
    public void testStats() {
        StatsReader statsReader = new BsonStatsReader();
        assertEquals(0L, statsReader.getAlltimeLongKey(Stats.ONLINE_TIME));
        assertTrue(statsReader.getKeys(ProfileStats.PROFILE_SETTINGS).isEmpty());
        assertTrue(statsReader.getKeys(Stats.MISC_VOTINGS).isEmpty());
    }

    @Test
    public void testClanStats() {
        StatsReader statsReader = new BsonStatsReader();
        assertTrue(statsReader.getKeys(ClanStats.USER_GROUP).isEmpty());
        assertTrue(statsReader.getStatKey(ClanStats.NAME).isEmpty());
    }

    @Test
    public void testMatchmaking() {
        StatsReader statsReader = new BsonStatsReader();

        assertEquals(1000, statsReader.getIntKey(MMStats.ELO, Reader.ALLTIME));
    }

    @Test
    public void testKitPvP() {
        StatsReader statsReader = new BsonStatsReader();

        assertTrue(statsReader.getKeys(KitPvPStats.KITPVP_PATH_EXP).isEmpty());
    }
}
