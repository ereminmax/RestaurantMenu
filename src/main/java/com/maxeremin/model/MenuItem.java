package com.maxeremin.model;

/**
 * Created by Максим on 13.11.2016.
 */
public class MenuItem {
    private String name;
    private String dishType;
    private Double price;

    public MenuItem(String name, String dishType, Double price) {
        this.name = name;
        this.dishType = dishType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDishType() {
        return dishType;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", dishType=" + dishType +
                ", price=" + price +
                '}';
    }
}
