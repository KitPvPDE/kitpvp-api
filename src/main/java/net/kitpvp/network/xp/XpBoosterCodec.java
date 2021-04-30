package net.kitpvp.network.xp;

import net.kitpvp.stats.Key;
import net.kitpvp.stats.StatsReader;
import net.kitpvp.stats.bson.BsonStatsWriter;
import net.kitpvp.stats.bson.codec.BsonCodec;
import org.jetbrains.annotations.NotNull;

public class XpBoosterCodec implements BsonCodec<XpBooster> {

    public static final XpBoosterCodec CODEC = new XpBoosterCodec();

    @Override
    public void encode(XpBooster xpBooster, BsonStatsWriter writer) {
        writer.setStatKey(Key.identity(), "uuid", xpBooster.getUuid());
        writer.setStatKey(Key.identity(), "duration", xpBooster.getDuration());
        writer.setStatKey(Key.identity(), "purchased", xpBooster.getPurchased());
    }

    @Override
    public @NotNull XpBooster decode(StatsReader statsReader) {
        return null;
    }
}
