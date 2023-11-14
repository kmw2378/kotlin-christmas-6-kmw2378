package christmas.domain.menu;

import static christmas.domain.menu.MenuType.APPETIZER;
import static christmas.domain.menu.MenuType.BEVERAGE;
import static christmas.domain.menu.MenuType.DESERT;
import static christmas.domain.menu.MenuType.MAIN;

public enum Menu {
    WHITE_MUSHROOM_SOUP(APPETIZER, "양송이수프", 6_000L),
    TAPAS(APPETIZER, "타파스", 5_500L),
    CAESAR_SALAD(APPETIZER, "시저샐러드", 8_000L),
    T_BONE_STEAK(MAIN, "티본스테이크", 55_000L),
    BARBECUE_RIBS(MAIN, "바비큐립", 54_000L),
    SEAFOOD_PASTA(MAIN, "해산물파스타", 35_000L),
    CHRISTMAS_PASTA(MAIN, "크리스마스파스타", 25_000L),
    CHOCOLATE_CAKE(DESERT, "초코케이크", 15_000L),
    ICE_CREAM(DESERT, "아이스크림", 5_000L),
    ZERO_COKE(BEVERAGE, "제로콜라", 3_000L),
    RED_WINE(BEVERAGE, "레드와인", 60_000L),
    CHAMPAGNE(BEVERAGE, "샴페인", 25_000L);

    private final MenuType type;
    private final String name;
    private final long amount;

    Menu(final MenuType type, final String name, final long amount) {
        this.type = type;
        this.name = name;
        this.amount = amount;
    }

    public MenuType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }
}
