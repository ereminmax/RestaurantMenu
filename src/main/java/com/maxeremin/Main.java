package com.maxeremin;

import com.maxeremin.controller.Controller;
import com.maxeremin.view.View;

class Main {

    public static void main(String ... arg) {

        Controller.getInstance();
        View view = View.getInstance();
        view.execute();

    }

}