package com.maxeremin.view;

import com.maxeremin.controller.Controller;
import com.maxeremin.model.MenuItem;
import com.maxeremin.model.Model;

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
            System.out.print("Введите 0 Выход\n"
                    + "Введите 1 Открыть XML\n"
                    + "Введите 2 Найти пункт меню\n"
                    + "Введите 3 Добавить пункт меню\n"
                    + "Введите 4 Удалить пункт меню\n"
                    + "Введите 5 Изменить пункт меню\n"
                    + "Введите 6 Добавить данные из другого файла\n"
                    + "Введите 7 Сохранить\n"
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
                case 3:
                    add();
                    break;
                case 4:
                    remove();
                    break;
                case 5:
                    update();
                    break;
                case 6:
                    readFiles();
                    break;
                case 7:
                    save();
                    break;
                default:
                    continue;
            }
        }
    }

    private void save() {
        Controller.getInstance().save();
        if (Controller.getInstance().checkStatus()) {
            System.err.println("Exception occurred while writing the file! Check if the actual file was read first");
            return;
        }
        System.out.println("Done! ");
    }

    private String chooseType() {
        String type = null;
        System.out.print("Выберите тип пункта меню, на которое требуется заменить исходное значение\n"
                + "Введите 1 Первое\n"
                + "Введите 2 Второе\n"
                + "Введите 3 Салат\n"
                + "Введите 4 Сладкое\n"
        );
        int typeID = sc.nextInt();
        sc.nextLine();

        switch (typeID) {
            case 1:
                type = "First";
                break;
            case 2:
                type = "Second";
                break;
            case 3:
                type = "Salad";
                break;
            case 4:
                type = "Sweet";
                break;
            default:
                System.err.println("Выберите один из предложенных вариантов!");
        }
        return type;
    }

    private void update() {
        System.out.println("Введите имя пункта меню, название которого требуется изменить");
        String name = sc.nextLine();

        System.out.println("Введите новое имя пункта меню, либо оставьте поле пустым");
        String newName = sc.nextLine();
        if (newName.equals("")) newName = null;

        String type = chooseType();
        if (type == null) return;

        System.out.println("Введите цену пункта меню, на которое требуется заменить исходное значение\n");
        double price = sc.nextDouble();
        sc.nextLine();

        Controller.getInstance().update(name, newName, type, price);

        if (Controller.getInstance().checkStatus()) {
            System.err.println("Dish with specified name does not exist! ");
            return;
        }
        System.out.println("Done! ");
        printMenu();
    }

    private void remove() {
        System.out.println("Введите имя пункта меню");
        String name = sc.nextLine();
        Controller.getInstance().remove(name);
        if (Controller.getInstance().checkStatus()) {
            System.err.println("Dish with specified name does not exist! ");
            return;
        }
        System.out.println("Done! ");
        printMenu();
    }

    private void printMenu() {
        for(MenuItem mi: Model.getInstance().getMenu()) {
            System.out.println(mi.toString());
        }
    }

    private void add() {

        System.out.println("Введите имя пункта меню");
        String name = sc.nextLine();

        String type = chooseType();
        if (type == null) return;

        System.out.println("Введите цену пункта меню");
        double price = sc.nextDouble();
        sc.nextLine();
        Controller.getInstance().add(name, type, price);

        if (Controller.getInstance().checkStatus()) {
            System.err.println("Dish with specified name does not exist! ");
            return;
        }
        System.out.println("Done! ");
        printMenu();
    }

    private void readFiles() {
        Controller.getInstance().readTypes();
        Controller.getInstance().readMenu();
        if (Controller.getInstance().checkStatus()) {
            System.err.println("Error occurred while reading files! ");
            return;
        }
        System.out.println("Done!");
        printMenu();
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
