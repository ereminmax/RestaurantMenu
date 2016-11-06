package com.maxeremin;

import java.util.logging.Logger;

class Main {

    Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String ... arg) {

        new Main().doSomeLog();
        System.out.println("Hello, Maven!");

    }

    private void doSomeLog() {
        logger.info("Greeting starts\n");
    }

}