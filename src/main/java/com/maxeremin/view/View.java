package com.maxeremin.view;

import com.maxeremin.controller.Controller;

import java.util.InputMismatchException;
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
            System.out.print("Type 0 Exit\n"
                    + "Type 1 Open XML\n"
                    + "Type 2 Find menu item\n"
                    + "Type 3 Add menu item\n"
                    + "Type 4 Delete menu item\n"
                    + "Type 5 Update menu item\n"
                    + "Type 6 Add data from another file\n"
                    + "Type 7 Save\n"
                    + "Type 8 Print menu\n"
            );

            try {
                input = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Type only numbers from the list");
            }

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
                case 8:
                    printMenu();
                    break;
                default:
                    continue;
            }
        }
    }

    private void save() {
        try {
            Controller.getInstance().save();
            System.out.println("Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private int chooseType() {
        System.out.print("Choose the type of the dish, you want to change the actual one to\n"
                + "Type 1 First\n"
                + "Type 2 Second\n"
                + "Type 3 Salad\n"
                + "Type 4 Sweet\n"
        );

        try {
            input = sc.nextInt();
            sc.nextLine();
            if (!(input < 5 && input > 0)) throw new Exception("Choose 1, 2, 3, or 4");
        } catch (InputMismatchException e) {
            System.err.println("Type only numbers");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return input;
    }

    /**
     * Updates the item's data
     */

    private void update() {
        System.out.println("Type the name of the dish you want to update the information about");
        String name = sc.nextLine();

        System.out.println("Type the desired name of the dish or skip this step");
        String newName = sc.nextLine();

        int type = chooseType();

        System.out.println("Type the desired price");
        try {
            double price = sc.nextDouble();
            sc.nextLine();
            Controller.getInstance().update(name, newName, type, price);
            System.out.println("Done! ");
        } catch (InputMismatchException e) {
            System.err.println("Type the numbers only");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Removes item from menu
     */

    private void remove() {
        System.out.println("Type the name of the menu item");
        String name = sc.nextLine();

        try {
            Controller.getInstance().remove(name);
            System.out.println("Done! ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void printMenu() {
        String[] strArr = Controller.getInstance().getMenu();
        int size = strArr.length;

        for(int i = 0; i < size; i++) {
            System.out.println(strArr[i] + " " + strArr[++i] + " " + strArr[++i]);
        }
    }

    private void add() {
        System.out.println("Type the name of the menu item");
        String name = sc.nextLine();

        int type = chooseType();

        System.out.println("Type the price of the menu item");

        try {
            double price = sc.nextDouble();
            sc.nextLine();
            Controller.getInstance().add(name, type, price);
            System.out.println("Done!");
        } catch (InputMismatchException e) {
            System.err.println("Type the numbers only");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void readFiles() {
        try {
            Controller.getInstance().readTypes();
            Controller.getInstance().readMenu();
            System.out.println("Done!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void search() {
        System.out.println("Type the name of the menu item");
        String name = sc.nextLine();

        try {
            String reply = Controller.getInstance().search(name);
            System.out.println(reply);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static synchronized View getInstance() {
        if (instance == null) instance = new View();
        return instance;
    }
}
