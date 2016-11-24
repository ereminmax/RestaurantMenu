package com.maxeremin;

import com.maxeremin.view.View;

/**
 * Console app which supports CRUD operations with data retrieved from XML file, located in Resources folder.
 * @author Max Eremin
 * @version 1.0
 */
class Main {

    public static void main(String ... arg) {

        View view = View.getInstance();
        /**
         * Runs console app
         * @see View#execute()
         */
        view.execute();

    }

}