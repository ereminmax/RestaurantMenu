package com.maxeremin;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class Main {

    Logger logger = Logger.getLogger(Main.class.getName());
    FileHandler fh;

    public static void main(String ... arg) {

        new Main().doSomeLog();
        System.out.println("Hello, Maven!");

    }

    private void doSomeLog() {

        try {

            fh = new FileHandler("C:\\Git\\NCMentor\\src\\test\\java\\MyLogFile.log");
            logger.addHandler(fh);

            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        logger.info("Greeting starts\n");

    }

}