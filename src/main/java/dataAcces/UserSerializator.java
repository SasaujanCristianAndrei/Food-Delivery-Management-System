package dataAcces;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserSerializator {

    private File filename;

    public UserSerializator() {
        filename = new File("file.ser");
        if(!filename.exists())
        {
            try {
                FileOutputStream verify=new FileOutputStream(filename);
                verify.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean addUser(User user) {
        List<User> userList;
        try {
            userList = getUser();
            if (userList.size() == 0) {
                userList = new ArrayList<>();
            }
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            userList.add(user);
            out.writeObject(userList);
            out.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public List<User> getUser() {
        List<User> readCase = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            readCase = (List<User>) in.readObject();
            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("File Empty");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
        return readCase;
    }

}
