import collections.GoodsCollection;
import models.City;
import models.Event;
import models.Goods;
import models.Trader;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создаем список городов
        List<City> cities = Arrays.asList(
                new City("City A", 60),
                new City("City B", 80),
                new City("City C", 100)
        );

        // Создаем торговца
        Trader trader = new Trader(30, 3, cities.get(0)); // 30 денег, 3 места для товаров

        // Создаем коллекцию товаров
        GoodsCollection goodsCollection = new GoodsCollection();

        // Главный игровой цикл
        while (trader.hasSpaceForGoods() && trader.getMoney() > 0) {
            Goods goods = Utils.getRandomGoods();
            System.out.println("Торговец хочет купить товар: " + goods.getName());
            if (trader.hasEnoughMoneyForGoods(goods)) {
                goodsCollection.addGoods(goods);  // Добавляем товар в коллекцию
                trader.buyGoods(goods);           // Покупаем товар
                System.out.println("Торговец купил товар: " + goods.getName());
            } else {
                System.out.println("Недостаточно денег для покупки товара: " + goods.getName());
            }

            // Выводим все товары у торговца
            System.out.println("Товары у торговца:");
            goodsCollection.displayAllGoods();

            // Проверка состояния
            if (!trader.hasSpaceForGoods() || trader.getMoney() <= 0) {
                System.out.println("Торговец не может купить больше товаров.");
                break;
            }
        }

        // Начало путешествия торговца
        while (trader.getDistanceTraveled() < trader.getCurrentCity().getDistance()) {
            System.out.println("Торговец в пути...");
            Event event = Utils.getRandomEvent();
            trader.travel();
            System.out.println("Произошло событие: " + event.getDescription());

            // Если событие связано с испорченным товаром
            if (event.getDescription().equals("Товар испортился")) {
                goodsCollection.degradeRandomGoods(); // Деградируем случайный товар
            }

            goodsCollection.displayAllGoods();  // Печатаем текущие товары и их состояние

            // Отладочная информация
            System.out.println("Пройдено расстояние: " + trader.getDistanceTraveled() + " из " + trader.getCurrentCity().getDistance());
        }

        System.out.println("Торговец достиг цели!");
    }
}
