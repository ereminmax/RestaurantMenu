package com.maxeremin;

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

    public void readMenu(String value) {
        model.readMenu(value);
    }

    public String search(String name) {
        return model.search(name);
    }
}
