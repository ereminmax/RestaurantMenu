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

    public void readTypes() {
        model.readTypes();
    }

    public void readMenu() {
        model.readMenu();
    }

    public String search(String name) {
        return model.search(name);
    }

    public void placeError(boolean flag) {
        exceptionDetected = flag;
    }

    public boolean checkStatus() {
        return exceptionDetected;
    }

    public static synchronized Controller getInstance() {
        if (instance == null) instance = new Controller();
        return instance;
    }
}
