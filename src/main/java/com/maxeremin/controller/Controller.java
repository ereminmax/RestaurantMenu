package com.maxeremin.controller;

import com.maxeremin.model.ModelInterface;
import com.maxeremin.view.View;

/**
 * Created by Максим on 13.11.2016.
 */
public class Controller implements ControllerInterface{
    ModelInterface model;
    View view;

    public Controller(ModelInterface model) {
        this.model = model;
        view = new View(this, model);
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
}
