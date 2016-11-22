package com.maxeremin.controller;

import com.maxeremin.model.Model;
import com.maxeremin.model.ModelInterface;
import com.maxeremin.view.View;

/**
 * Created by Максим on 13.11.2016.
 */
public class Controller implements ControllerInterface{
    private static Controller instance = null;
    ModelInterface model;
    View view;
    boolean exceptionDetected;

    private Controller() {
        model = Model.getInstance();
        view = View.getInstance();
    }

    public void readTypes() throws Exception {
        model.readTypes();
    }

    public void readMenu() throws Exception {
        model.readMenus();
    }

    public String search(String name) throws Exception {
        return model.search(name);
    }

    public void placeError(boolean flag) {
        exceptionDetected = flag;
    }

    public boolean checkStatus() {
        return exceptionDetected;
    }

    public void add(String name, String type, double price) throws Exception {
        model.add(name, type, price);
    }

    public void remove(String name) throws Exception {
        model.remove(name);
    }

    public void update(String name, String newName, String type, double price) throws Exception {
        model.update(name, newName, type, price);
    }

    public void save() throws Exception {
        model.save();
    }

    public static synchronized Controller getInstance() {
        if (instance == null) instance = new Controller();
        return instance;
    }
}
