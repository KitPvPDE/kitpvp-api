package net.kitpvp.network.xp;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Getter
@RequiredArgsConstructor
public class XpBooster {

    public static final long SHORT_DURATION = TimeUnit.DAYS.toMillis(1);
    public static final long SHORT_PRICE = 500;

    public static final long NORMAL_DURATION = TimeUnit.DAYS.toMillis(4);
    public static final long NORMAL_PRICE = 1500;

    public static final long LONG_DURATION = TimeUnit.DAYS.toMillis(7);
    public static final long LONG_PRICE = 3000;

    private final UUID uuid;
    private final long duration, purchased;

    public boolean isExpired() {
        return this.duration <= System.currentTimeMillis();
    }
}
