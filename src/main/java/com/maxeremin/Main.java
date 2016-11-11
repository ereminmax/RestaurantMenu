package com.maxeremin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String ... arg) {

        doSomeLog();
        System.out.println("Hello, Maven!");

    }

    static void doSomeLog() {

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException: ", ex);
            System.err.println("Could not setup logger configuration: " + ex.toString());
        }

        logger.fine("Greeting starts.");

    }
}