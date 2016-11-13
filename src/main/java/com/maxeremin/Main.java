package com.maxeremin;

class Main {

    public static void main(String ... arg) {

        ModelInterface model = new Model();
        ControllerInterface controller = new Controller(model);

    }

}