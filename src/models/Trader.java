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
        if (money >= totalPrice && goodsList.size() < capacity) {
            money -= totalPrice;
            goodsList.add(goods);
            return true;
        }
        return false;
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

    public void travel() {
        distanceTraveled += 10; // Пример, как может увеличиваться расстояние
    }
}
