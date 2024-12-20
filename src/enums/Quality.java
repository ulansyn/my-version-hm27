package enums;

public enum Quality {
    NORMAL("Хорошее", 1.2),
    SLIGHTLY_DAMAGED("Слегка повреждено", 0.95),
    HALF_DAMAGED("Наполовину испорчено", 0.55),
    ALMOST_SPOILED("Почти испорчено", 0.25),
    RUINED("Испорчено в хлам", 0.1);

    private final String description;
    private final double priceCoefficient;

    Quality(String description, double priceCoefficient) {
        this.description = description;
        this.priceCoefficient = priceCoefficient;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceCoefficient() {
        return priceCoefficient;
    }

    public Quality degrade() {
        int currentIndex = this.ordinal();
        if (currentIndex < Quality.values().length - 1) {
            return Quality.values()[currentIndex + 1];
        }
        return this;
    }
}