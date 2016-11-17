package com.maxeremin.controller;

import com.maxeremin.model.ModelInterface;
import com.maxeremin.view.View;

/**
 * Created by Максим on 13.11.2016.
 */
public class Controller implements ControllerInterface{
    private static Controller instance = null;
    ModelInterface model;
    View view;

    private Controller(ModelInterface model) {
        this.model = model;
        view = View.getInstance(this, model);
        view.execute();
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

    public static synchronized Controller getInstance(ModelInterface model) {
        if (instance == null) instance = new Controller(model);
        return instance;
    }
}
