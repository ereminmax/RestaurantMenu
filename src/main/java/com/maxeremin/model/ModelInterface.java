package com.maxeremin.model;

/**
 * Created by Максим on 13.11.2016.
 */
public interface ModelInterface {

    void readTypes() throws Exception;
    void readMenus() throws Exception;
    String search(String name) throws Exception;
    void add(String name, String type, double price) throws Exception;
    void remove(String name) throws Exception;
    void update(String name, String newName, String type, double price) throws Exception;
    void save() throws Exception;

}
