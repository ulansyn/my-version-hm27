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
        Trader trader = new Trader(2000, 10, Utils.getRandomCity(cities)); // 30 денег, 3 места для товаров
        System.out.println("Выбран город: " + trader.getCurrentCity().getName());
        // Создаем коллекцию товаров
        GoodsCollection goodsCollection = new GoodsCollection();

        // Главный игровой цикл
        int cnt = 0;
        while (trader.hasSpaceForGoods() && trader.getMoney() > 0) {
            Goods goods = Utils.getRandomGoods();
//            System.out.println("Торговец хочет купить товар: " + goods.getName());

            // Отладочная информация: сколько денег у торговца перед покупкой
//            System.out.println("Деньги у торговца перед покупкой: " + trader.getMoney());

            if (trader.hasEnoughMoneyForGoods(goods)) {
                goodsCollection.addGoods(goods);  // Добавляем товар в коллекцию
                trader.buyGoods(goods);           // Покупаем товар
//                System.out.println("Торговец купил товар: " + goods.getName());
            } else {
//                System.out.println("Недостаточно денег для покупки товара: " + goods.getName());
                cnt += 1;
            }

            // Отладочная информация: сколько денег у торговца после попытки покупки
//            System.out.println("Деньги у торговца после попытки покупки: " + trader.getMoney());

            // Выводим все товары у торговца


            // Проверка состояния
            if (!trader.hasSpaceForGoods() || trader.getMoney() <= 0  || cnt == 6) {
                System.out.println("Торговец не может купить больше товаров.");
                break;
            }
        }
        System.out.println("Товары у торговца:");
        goodsCollection.displayAllGoods();

        // Начало путешествия торговца
        while (trader.getDistanceTraveled() < trader.getCurrentCity().getDistance()) {
            System.out.println("Торговец в пути...");
            Event event = Utils.getRandomEvent();
            trader.travel();
            System.out.println("Произошло событие: " + event.getDescription());

            // Отладочная информация
            System.out.println("Пройдено расстояние: " + trader.getDistanceTraveled() + " из " + trader.getCurrentCity().getDistance());

            // Если событие связано с испорченным товаром
            if (event.getDescription().equals("Товар испортился")) {
                goodsCollection.degradeRandomGoods(); // Деградируем случайный товар
                System.out.println("Один товар испортился.");
            }

            goodsCollection.displayAllGoods();  // Печатаем текущие товары и их состояние

            // Добавьте условие выхода из цикла, если расстояние не увеличивается
            if (trader.getDistanceTraveled() == 0) {
                System.out.println("Ошибка: Торговец не двигается вперед. Выход из цикла.");
                break;
            }
        }

        System.out.println("Торговец достиг цели!");
    }
}
