package dataAcces;

import model.MenuItem;
import model.Order;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class IdSerializator {
    private File filename;
    public IdSerializator()
    {
        filename = new File("id.ser");
        if (!filename.exists()) {
            try {
                FileOutputStream verify = new FileOutputStream(filename);
                verify.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addContorId(Integer id) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(id);
            out.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public int getContorId() {
        Integer readCase=0;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            readCase = (Integer) in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return 0;
        }
        return readCase;
    }
}
