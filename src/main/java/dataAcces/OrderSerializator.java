package dataAcces;

import model.MenuItem;
import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class OrderSerializator {
    private File filename;
    public OrderSerializator()
    {
        filename = new File("order.ser");
        if (!filename.exists()) {
            try {
                FileOutputStream verify = new FileOutputStream(filename);
                verify.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*public boolean addOrders(HashMap<Order, List<MenuItem>> orderListHashMap) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(orderListHashMap);
            out.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }*/

    public boolean addOrder(Order order,List<MenuItem>menuItemList) {
        HashMap<Order, List<MenuItem>> orderListHashMap=new HashMap<>();
        try {
            orderListHashMap = getOrders();
            if (orderListHashMap.size() == 0) {
               orderListHashMap = new HashMap<>();
            }
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            orderListHashMap.put(order,menuItemList);
            out.writeObject(orderListHashMap);
            out.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public HashMap<Order, List<MenuItem>> getOrders() {
        HashMap<Order, List<MenuItem>> readCase=new HashMap<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            readCase = (HashMap<Order, List<MenuItem>>) in.readObject();
            in.close();
            file.close();
        } catch (IOException ex) {
            //System.out.println("File Empty");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return readCase;
    }
}
