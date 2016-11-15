package com.maxeremin.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Максим on 13.11.2016.
 */
public class Model implements ModelInterface{

    private Menu menu = new Menu();
    private DishType[] dishTypeArr = DishType.values();

    public Model() {
    }

    public void readMenu() {
        try {
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
                    String dishType = el.getElementsByTagName("dishType").item(0).getTextContent().trim();
                    Double price = Double.parseDouble( el.getElementsByTagName("price").item(0).getTextContent().trim() );

                    for(DishType dt : dishTypeArr) {
                        if(dishType.equals(dt.toString())) {
                            menu.addMenuItem( new MenuItem(name, dt, price) );
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String search(String name) {

        for(MenuItem el : menu.getMenu()) {
            if (name.equals(el.getName())) return el.toString();
        }

        return "Not found! ";
    }
}
