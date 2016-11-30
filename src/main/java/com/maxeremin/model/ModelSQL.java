package com.maxeremin.model;

/**
 * @author Max Eremin
 * @since 2.0
 */
public class ModelSQL implements ModelInterface{

    @Override
    public void readTypes() throws Exception {

        System.out.println("types");
    }

    @Override
    public void readMenus() throws Exception {
        System.out.println("Menus");
    }

    @Override
    public String search(String name) throws Exception {
        return null;
    }

    @Override
    public void add(String name, int type, double price) throws Exception {

    }

    @Override
    public void remove(String name) throws Exception {

    }

    @Override
    public void update(String name, String newName, int type, double price) throws Exception {

    }

    @Override
    public void save() throws Exception {

    }

    @Override
    public String[] getMenu() {
        return new String[0];
    }
}
