package dataAcces;

import model.BaseProduct;
import model.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSerializator {
    private File filename;

    public ProductSerializator() {
        filename = new File("product.ser");
        if (!filename.exists()) {
            try {
                FileOutputStream verify = new FileOutputStream(filename);
                verify.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addProduct(List<MenuItem> menuItems) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(menuItems);
            out.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addProduct(MenuItem baseProduct) {
        List<MenuItem> baseProductList;
        try {
            baseProductList = getBaseProduct();
            if (baseProductList.size() == 0) {
                baseProductList = new ArrayList<>();
            }
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            baseProductList.add(baseProduct);
            out.writeObject(baseProductList);
            out.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public boolean deleteProduct(String title) {
        List<MenuItem> baseProductList;
        try {
            baseProductList = getBaseProduct();
            if (baseProductList.size() == 0) {
                baseProductList = new ArrayList<>();
            }
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            for (MenuItem x : baseProductList) {
                if (x.getTitle().equals(title)) {
                    baseProductList.remove(x);
                    break;
                }
            }
            out.writeObject(baseProductList);
            out.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public List<MenuItem> getBaseProduct() {
        List<MenuItem> readCase = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            readCase = (List<MenuItem>) in.readObject();
            in.close();
            file.close();
        } catch (IOException ex) {
            //System.out.println("File Empty");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return readCase;
    }


    public List<MenuItem> findProduct() {
        List<MenuItem> readCase = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            readCase = (List<MenuItem>) in.readObject();
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
