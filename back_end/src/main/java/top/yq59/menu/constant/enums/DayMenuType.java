package top.yq59.menu.constant.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DayMenuType {
    Breakfast("早餐"),
    Lunch("午饭"),
    Dinner("晚饭");

    private String name;

    DayMenuType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static DayMenuType getByValue(int value){
        for (DayMenuType a: DayMenuType.values()) {
            if(a.ordinal() == value){
                return a;
            }
        }
        return null;
    }
}
