package com.maxeremin.controller;

import com.maxeremin.model.Model;
import com.maxeremin.model.ModelInterface;
import com.maxeremin.model.ModelSQL;
import com.maxeremin.view.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Max Eremin
 * @since 1.0
 */
public class Controller implements ControllerInterface{
    private static Controller instance = null;
    ModelInterface model;
    View view;
    ApplicationContext context;
    ModelSQL obj;

    private Controller() {
        context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        model = (ModelSQL) context.getBean("modelSQL");
        //model = Model.getInstance();
        view = View.getInstance();
    }

    /**
     * Invokes {@link Model#readTypes()} from the Model
     * @throws Exception
     */

    public void readTypes() throws Exception {
        model.readTypes();
    }

    /**
     * Invokes {@link Model#readMenus()} from the Model
     * @throws Exception
     */

    public void readMenu() throws Exception {
        model.readMenus();
    }

    /**
     * Invokes {@link Model#search(String)} ()} from the Model
     * @throws Exception
     * @param name The name of the target item
     * @return String value of the item from the menu
     */

    public String search(String name) throws Exception {
        return model.search(name);
    }

    /**
     * Adds name, type and price into the Model
     * @param name
     * @param type
     * @param price
     * @throws Exception
     */

    public void add(String name, int type, double price) throws Exception {
        model.add(name, type, price);
    }

    /**
     * Sends the name of the item we want to remove to the Model
     * @param name
     * @throws Exception
     */

    public void remove(String name) throws Exception {
        model.remove(name);
    }

    /**
     * Sends the data to the Model about the item we want to update
     * @param name
     * @param newName
     * @param type
     * @param price
     * @throws Exception
     */

    public void update(String name, String newName, int type, double price) throws Exception {
        model.update(name, newName, type, price);
    }

    /**
     * Asks the Model to save the data to the file
     * @throws Exception
     */

    public void save() throws Exception {
        model.save();
    }

    /**
     * Asks the Model to get the menu into array of string
     * @return Array of the menu
     */

    public String[] getMenu() {
        return model.getMenu();
    }

    public static synchronized Controller getInstance() {
        if (instance == null) instance = new Controller();
        return instance;
    }
}
