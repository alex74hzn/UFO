package com.example.interfaces.ufo;

public enum TakeOffType {
    RUN_UP_TAKE_OFF(1,"Взлет с разбега"),
    VERTICAL_TAKE_OFF(2,"Вертикальный взлет"),
    TAKE_OFF_FROM_SPOT(3,"С места");
    private final int value;
    private final String type;

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    TakeOffType(int value, String type) {
        this.value = value;
        this.type = type;
    }
}