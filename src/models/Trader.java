package models;

import collections.GoodsCollection;
import java.util.ArrayList;
import java.util.List;

public class Trader {
    private double money; // Деньги торговца
    private int capacity; // Вместимость для товаров
    private City currentCity;
    private List<Goods> goodsList;
    private int distanceTraveled;

    public Trader(double money, int capacity, City currentCity) {
        this.money = money;
        this.capacity = capacity;
        this.currentCity = currentCity;
        this.goodsList = new ArrayList<>();
        this.distanceTraveled = 0;
    }

    // Метод для покупки товара
    public boolean buyGoods(Goods goods) {
        double totalPrice = goods.getPrice();

        // Проверка, хватает ли денег и места для товара
        if (hasEnoughMoneyForGoods(goods) && hasSpaceForGoods()) {
            // Уменьшаем деньги и добавляем товар
            money -= totalPrice;
            goodsList.add(goods);
            System.out.println("Торговец купил товар: " + goods.getName());
            System.out.println("Оставшиеся деньги: " + money);
            return true;
        } else {
            System.out.println("Недостаточно денег или места для покупки товара: " + goods.getName());
            System.out.println("Текущие деньги у торговца: " + money);
            return false;
        }
    }

    // Проверка, хватает ли места для товара
    public boolean hasSpaceForGoods() {
        return goodsList.size() < capacity;
    }

    // Проверка, хватает ли денег для покупки товара
    public boolean hasEnoughMoneyForGoods(Goods goods) {
        return money >= goods.getPrice();
    }

    // Геттеры для денег и товаров
    public double getMoney() {
        return money;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    // Метод для путешествия торговца
    public void travel() {
        distanceTraveled += 10; // Пример, как может увеличиваться расстояние
    }
}
