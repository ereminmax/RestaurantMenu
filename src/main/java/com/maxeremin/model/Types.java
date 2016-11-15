package com.maxeremin.model;

import java.util.LinkedList;

/**
 * Created by Максим on 15.11.2016.
 */
public class Types {
    private LinkedList<TypeItem> types = new LinkedList<>();

    public Types() {
    }

    public void addTypeItem(TypeItem NewTypeItem) {
        types.addLast(NewTypeItem);
    }

    public LinkedList<TypeItem> getTypes() {
        return types;
    }
}
