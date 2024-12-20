package models;

import enums.Quality;
import enums.GoodsType;

public class Goods {
    private final String name;
    private final double weight;
    private final double price;
    private Quality quality;  // Используем перечисление Quality
    private final GoodsType type;

    public Goods(String name, double weight, double price, GoodsType type) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.quality = Quality.NORMAL;  // Начальное качество товара
    }

    // Метод для ухудшения качества товара
    public void degradeQuality() {
        this.quality = this.quality.degrade();  // Используем метод degrade из перечисления
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public Quality getQuality() {
        return quality;
    }

    public GoodsType getType() {
        return type;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    // Печать информации о товаре
    public String getInfo() {
        return "Товар: " + name + ", Качество: " + quality.getDescription() + ", Цена: " + price;
    }
}
