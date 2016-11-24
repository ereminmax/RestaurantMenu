package com.maxeremin.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Objects;

/**
 * Created by Максим on 13.11.2016.
 */
@Root(name = "menu_item")
public class MenuItem {
    @Element
    private String name;
    @Element
    private int dishType;
    @Element
    private double price;

    public MenuItem(String name, int dishType, double price) {
        this.name = name;
        this.dishType = dishType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDishType() {
        return dishType;
    }

    public double getPrice() {
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

    @Override
    public int hashCode() {
        return Objects.hash(name, dishType, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof MenuItem)) {
            return false;
        }

        MenuItem menuItem = (MenuItem) obj;
        return price == menuItem.price &&
                Objects.equals(name, menuItem.name) &&
                dishType == menuItem.dishType;
    }
}
