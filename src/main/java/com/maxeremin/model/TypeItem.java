package com.maxeremin.model;

/**
 * Created by Максим on 13.11.2016.
 */
class TypeItem {
    private int id;
    private String value;

    TypeItem(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
