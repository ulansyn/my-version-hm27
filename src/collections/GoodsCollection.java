package collections;

import models.Goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GoodsCollection {
    private List<Goods> goodsList;

    public GoodsCollection() {
        this.goodsList = new ArrayList<>();
    }

    public void addGoods(Goods goods) {
        goodsList.add(goods);
    }

    // Метод деградации случайного товара
    public void degradeRandomGoods() {
        if (goodsList.isEmpty()) {
            System.out.println("Нет товаров для деградации.");
            return;
        }

        // Выбираем случайный товар из коллекции
        Random random = new Random();
        Goods randomGoods = goodsList.get(random.nextInt(goodsList.size()));

        // Деградируем качество товара
        randomGoods.degradeQuality();

        System.out.println("Качество товара " + randomGoods.getName() + " ухудшилось.");
    }

    public void displayAllGoods() {
        for (Goods goods : goodsList) {
            System.out.println("Товар: " + goods.getName() + ", Качество: " + goods.getQuality().getDescription());
        }
    }
}
