package com.maxeremin.controller;

/**
 * @author Max Eremin
 * @since 1.0
 */
public interface ControllerInterface {

    void readTypes() throws Exception;
    void readMenu() throws Exception;
    String search(String name) throws Exception;
    void add(String name, int type, double price) throws Exception;
    void remove(String name) throws Exception;
    void update(String name, String newName, int type, double price) throws Exception;
    void save() throws Exception;
    String[] getMenu();

}
