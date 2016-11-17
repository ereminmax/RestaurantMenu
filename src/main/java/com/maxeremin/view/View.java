package com.maxeremin.view;

import com.maxeremin.controller.ControllerInterface;
import com.maxeremin.model.ModelInterface;

import java.util.Scanner;

/**
 * Created by Максим on 13.11.2016.
 */
public class View {
    private static View instance = null;
    ModelInterface model;
    ControllerInterface controller;

    private Scanner sc = new Scanner(System.in);
    private int input;

    private View(ControllerInterface controller, ModelInterface model) {
        this.controller = controller;
        this.model = model;
    }

    public void execute() {
        while(true) {
            System.out.println("Введите 0 Выход\n"
                    + "Введите 1 Открыть XML\n"
                    + "Введите 2 Найти пункт меню");
            input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    controller.readTypes();
                    controller.readMenu();
                    System.out.println("Done!");
                    break;
                case 2:
                    search();
                    break;
                default:
                    continue;
            }
        }
    }

    private void search() {
        System.out.println("Введите имя пункта меню");

        String name = sc.nextLine();

        String reply = controller.search(name);

        System.out.println(reply);
    }

    public static synchronized View getInstance(ControllerInterface controller, ModelInterface model) {
        if (instance == null) instance = new View(controller, model);
        return instance;
    }
}
