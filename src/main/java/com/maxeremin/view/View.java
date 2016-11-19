package com.maxeremin.view;

import com.maxeremin.controller.Controller;

import java.util.Scanner;

/**
 * Created by Максим on 13.11.2016.
 */
public class View {
    private static View instance = null;
    private Scanner sc = new Scanner(System.in);
    private int input;

    private View() {
    }

    public void execute() {
        while(true) {
            System.out.println("Введите 0 Выход\n"
                    + "Введите 1 Открыть XML\n"
                    + "Введите 2 Найти пункт меню"
                    //+ "Введите 3 Добавить пункт меню"
                    //+ "Введите 4 Удалить пункт меню"
                    //+ "Введите 5 Изменить пункт меню"

            );
            input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    readFiles();
                    break;
                case 2:
                    search();
                    break;
                /*case 3:
                    controller.add();
                    if (Controller.getInstance().checkStatus()) {
                        System.err.println("Dish with specified name does not exist! ");
                        return;
                    }
                    break;*/
                /*case 4:
                    Controller.getInstance().remove(name);*/
                default:
                    continue;
            }
        }
    }

    private void readFiles() {
        Controller.getInstance().readTypes();
        Controller.getInstance().readMenu();
        if (Controller.getInstance().checkStatus()) {
            System.err.println("Error occurred while reading files! ");
            return;
        }
        System.out.println("Done!");
    }

    private void search() {
        System.out.println("Введите имя пункта меню");

        String name = sc.nextLine();

        String reply = Controller.getInstance().search(name);

        System.out.println(reply);
    }

    public static synchronized View getInstance() {
        if (instance == null) instance = new View();
        return instance;
    }
}
