package com.maxeremin.model;

import com.maxeremin.controller.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;

/**
 * Created by Максим on 13.11.2016.
 */
public class Model implements ModelInterface{
    private static Model instance = null;
    private Menu menu;
    private Types types = new Types();
    private static final Logger logger = LogManager.getLogger();
    private SearchValidator searchValidator = new SearchValidator();

    private Model() {
    }

    public void readTypes() {
        try {
            String path = "src\\main\\resources\\types.xml";
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            NodeList nList = doc.getElementsByTagName("type_item");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nNode;

                    int id = Integer.parseInt(el.getAttribute("id"));
                    String value = el.getTextContent().trim();

                    types.addTypeItem(new TypeItem(id, value));
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while reading types", e);
            Controller.getInstance().placeError(true);
        }
    }

    public void readMenus() {
        if (menu == null) {
            readMenu();
            return;
        }

        try {
            String path = "src\\main\\resources\\menu2.xml";
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            NodeList nList = doc.getElementsByTagName("menu_item");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nNode;

                    String name = el.getElementsByTagName("name").item(0).getTextContent().trim();
                    int dishType = Integer.parseInt(el.getElementsByTagName("dishType").item(0).getTextContent().trim());
                    double price = Double.parseDouble(el.getElementsByTagName("price").item(0).getTextContent().trim());

                    for (TypeItem typeItem : types.getTypes()) {
                        if (typeItem.getId() == dishType) {
                            MenuItem newMI = new MenuItem(name, typeItem.getValue(), price);
                            if (!menu.getMenu().contains(newMI)) {
                                menu.addMenuItem(newMI);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while reading types", e);
            Controller.getInstance().placeError(true);
        }
    }

    private void readMenu() {
        try {
            menu = new Menu();
            String path = "src\\main\\resources\\menu.xml";
            File file = new File(path);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);

            NodeList nList = doc.getElementsByTagName("menu_item");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nNode;

                    String name = el.getElementsByTagName("name").item(0).getTextContent().trim();
                    int dishType = Integer.parseInt(el.getElementsByTagName("dishType").item(0).getTextContent().trim());
                    double price = Double.parseDouble(el.getElementsByTagName("price").item(0).getTextContent().trim());

                    for (TypeItem typeItem : types.getTypes()) {
                        if (typeItem.getId() == dishType) {
                            menu.addMenuItem(new MenuItem(name, typeItem.getValue(), price));
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while reading types", e);
            Controller.getInstance().placeError(true);
        }
    }

    public String search(String name) {

        if (!searchValidator.validate(name)) {
            return "Error: Target sentence must contain only cyrillic letters or spaces! ";
        }

        // To remove duplicate white spaces
        String cleanName = name.replaceAll("\\s+"," ");

        for(MenuItem el : menu.getMenu()) {
            if (cleanName.equalsIgnoreCase(el.getName())) return el.toString();
        }

        return "Not found! ";
    }

    public void update(String name, String newName, String type, double price) {
        for (int i = 0; i < menu.getMenu().size(); i++) {
            if (name.replaceAll("\\s+", " ").equalsIgnoreCase(menu.getMenu().get(i).getName())) {
                if (newName == null) menu.getMenu().set(i, new MenuItem(name, type, price));
                else menu.getMenu().set(i, new MenuItem(newName, type, price));
                return;
            }
        }
        Controller.getInstance().placeError(true);
    }

    public void add(String name, String type, double price) {
        String cleanName = name.replaceAll("\\s+"," ");
        String cleanType = type.replaceAll("\\s+"," ");

        for (TypeItem ti: types.getTypes()) {
            if (cleanType.equalsIgnoreCase(ti.getValue())) {
                menu.addMenuItem(new MenuItem(cleanName, ti.getValue(), price));
                return;
            }
        }
        Controller.getInstance().placeError(true);
    }

    public void remove(String name) {
        for (int i = 0; i < menu.getMenu().size(); i++) {
            if (name.replaceAll("\\s+", " ").equalsIgnoreCase(menu.getMenu().get(i).getName())) {
                menu.getMenu().remove(i);
                return;
            }
        }
        Controller.getInstance().placeError(true);
    }

    public LinkedList<MenuItem> getMenu() {
        return menu.getMenu();
    }

    public static synchronized Model getInstance() {
        if (instance == null) instance = new Model();
        return instance;
    }
}
