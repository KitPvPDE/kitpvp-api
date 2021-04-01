package net.kitpvp.network;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Icon {

    YIN_YANG("☯"),
    SUM("Σ"),
    HAMMER_AND_SICKLE("☭"),
    WHITE_DIAMOND("◈"),
    HEAVY_SPARKLE("❈"),
    FLORAL_HEART("❦"),
    GANG_187(""),
    STAR("✦"),
    CIRCLED_STAR("✪"),
    KOPPA("ϟ"),
    TU("ツ"),
    TM("™"),
    GAMMA("Γ"),
    INFECTED("☣"),
    HOT_SPRINGS("♨"),
    HIRAGANA_A("あ"),
    SUN_WITH_RAYS("☀"),
    UMBRELLA("☂"),
    ELECTRIC_ARROW("⌁"),
    DIAMETER_SIGN("⌀")
    ;

    @Getter
    private final String text;
}
