package enums;

public enum EventType {
    NORMAL_DAY("Normal Day"),
    RAIN("Rain"),
    FLAT_ROAD("Flat road"),
    WHEEL_BROKEN("Wheel broken"),
    RIVER("River"),
    LOCAL_MEETING("Local meeting"),
    HIGHWAY_ROBBERS("Highway robbers"),
    INN("Inn");

    private String name;

    EventType(String name) {
        this.name = name;
    }
}
;