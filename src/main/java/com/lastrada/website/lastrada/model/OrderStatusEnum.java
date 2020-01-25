package com.lastrada.website.lastrada.model;


public enum OrderStatusEnum{
    UNBERABEITET(0),
    BEARBEITET(1),
    UNGÜLTIG(2);

    private final int value;

    OrderStatusEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
