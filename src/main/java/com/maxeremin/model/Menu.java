package com.maxeremin.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.LinkedList;

/**
 * Created by Максим on 13.11.2016.
 */
@Root(name = "menu_list")
public class Menu {
    @ElementList(inline = true)
    private LinkedList<MenuItem> menu = new LinkedList<>();

    public Menu() {
    }

    public void addMenuItem(MenuItem NewMenuItem) {
        menu.addLast(NewMenuItem);
    }

    public LinkedList<MenuItem> getMenu() {
        return menu;
    }

}
