package com.maxeremin.model;

/**
 * Created by Максим on 13.11.2016.
 */
public interface ModelInterface {

    void readTypes();
    void readMenus();
    String search(String name);
    void add(String name, String type, double price);
    void remove(String name);
    void update(String name, String newName, String type, double price);
    void save();

}
