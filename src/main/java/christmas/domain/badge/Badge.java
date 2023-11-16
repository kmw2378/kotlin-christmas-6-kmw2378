package christmas.domain.badge;

public enum Badge {
    NONE("없음", 0L),
    STAR("별", 5_000L),
    TREE("트리", 10_000L),
    SANTA("산타", 20_000L);

    private final String name;
    private final long minPrice;

    Badge(final String name, final long minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    public String getName() {
        return name;
    }

    public long getMinPrice() {
        return minPrice;
    }
}
