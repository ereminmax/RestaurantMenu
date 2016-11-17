package com.maxeremin;

import com.maxeremin.controller.Controller;
import com.maxeremin.controller.ControllerInterface;
import com.maxeremin.model.Model;
import com.maxeremin.model.ModelInterface;

class Main {

    public static void main(String ... arg) {

        ModelInterface model = Model.getInstance();
        ControllerInterface controller = Controller.getInstance(model);

    }

}