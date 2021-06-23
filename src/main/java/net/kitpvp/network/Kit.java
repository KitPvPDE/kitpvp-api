package net.kitpvp.network;

import lombok.Getter;

import java.util.Locale;

@Getter
public enum Kit {

    AGENT(500, 373, 8270),
    AMATERASU(500, 153),
    ANCHOR(2500, 145),
    ARCHER(500, 261),
    BARBARIAN(500, 268),
    BERSERKER(500, 373, 8201),
    BLAZE(1500, 378),
    BLINK(1500, 399),
    CAMEL(500, 12),
    CANNIBAL(1500, 367),
    COMBO(1500, 283),
    COPYCAT(500, 383, 98),
    DROWNED(500, 380),
    ENDERMAGE(2500, 120),
    FIREMAN(1500, 327),
    FISHERMAN(2500,346),
    FLASH(1500, 76),
    FROSTY(500, 174),
    GAMBLER(500, 143),
    GLADIATOR(2500, 101),
    GRANDPA(500, 280),
    GRAPPLER(2500, 420),
    HULK(1500, 329),
    HYDRA(500, 379),
    JEDI(1500, 369),
    KANGAROO(2500, 401),
    MADMAN(2500, 32),
    MONK(2500, 2256),
    NEO(500, 262),
    NINJA(2500, 331),
    NONE(500, 276),
    NOOB(500, 397, 3),
    NYANCAT(500, 383, 98),
    PARAGLIDER(2500, 318),
    PHANTOM(1500, 288),
    POSEIDON(500, 111),
    RELAXO(1500, 281),
    ROGUE(500, 376),
    SCOUT(1500, 373, 8258),
    SNAIL(500, 373, 8266),
    SNOWMAN(1500, 332),
    SPIDERMAN(1500, 30),
    SPY(250, 345),
    STOMPER(2500, 313),
    STRONGMAN(500, 145, 2),
    SWITCHER(1500, 332),
    TANK(500, 46),
    THOR(1500, 271),
    TURTLE(500, 311),
    VIPER(1500, 375);

    private final String name;
    private final int price, icon, iconData;

    Kit(int price, int icon) {
        this.price = price;
        this.name = name().toLowerCase(Locale.ROOT);
        this.icon = icon;
        this.iconData = 0;
    }

    Kit(int price, int icon, int iconData) {
        this.price = price;
        this.name = name().toLowerCase(Locale.ROOT);
        this.icon = icon;
        this.iconData = iconData;
    }
}
