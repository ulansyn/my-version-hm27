import enums.EventType;
import enums.GoodsType;
import models.City;
import models.Event;
import models.Goods;

import java.util.List;
import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    public static City getRandomCity(List<City> cities) {
        return cities.get(random.nextInt(cities.size()));
    }

    public static Event getRandomEvent() {
        EventType[] eventTypes = EventType.values();
        EventType randomEventType = eventTypes[random.nextInt(eventTypes.length)];
        return new Event(randomEventType, "Описание события: " + randomEventType.name());
    }

    public static Goods getRandomGoods() {
        GoodsType[] goodsTypes = GoodsType.values();
        GoodsType randomGoodsType = goodsTypes[random.nextInt(goodsTypes.length)];
        return new Goods(randomGoodsType.name(), random.nextInt(10) + 1, random.nextInt(50) + 10, randomGoodsType);
    }
}
