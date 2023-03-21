package businessLogic;

import dataAcces.UserSerializator;
import model.Role;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceBLL{
    UserSerializator userSerializator = new UserSerializator();

    /**
     * @param user
     * @return boolean
     * add the id and verify if the usser is already in our register
     */
    public boolean addUser(User user) {
        List<User> userList = new ArrayList<>();
        int lastId = 0;
        userList = userSerializator.getUser();
        int lastIndex = userList.size();
        if (userList.size() != 0)
            lastId = userList.get(lastIndex - 1).getId();
        if (!findUser(user)) {
            User userWithId = new User(++lastId, user.getName(), user.getPassword(), user.getRole());
            userSerializator.addUser(userWithId);
            return true;
        }
        return false;
    }

    /**
     * @param user
     * @return boolean
     * verify if the password is ok.
     */
    public Role verifyPassword(User user) {
        List<User> userList = new ArrayList<>();
        userList = userSerializator.getUser();
        for (User x : userList) {
            if (x.equals(user)) {
                return x.getRole();
            }
        }
        return null;
    }

    /**
     * get the users from serializator in a list
     */
    public List<User> getUser() {
        List<User> userList = new ArrayList<>();
        userList = userSerializator.getUser();
        for (User x : userList) {
            //System.out.println(x.toString());
        }
        return userList;
    }

    /**
     * true if we have that user in db
     * false if we don t have that user in db
     *
     * @param user
     * @return boolean
     */
    public boolean findUser(User user) {
        List<User> userList = new ArrayList<>();
        userList = userSerializator.getUser();
        for (User x : userList) {
            if (x.getName().equals(user.getName())) {
                return true;
            }
        }
        return false;
    }
}
