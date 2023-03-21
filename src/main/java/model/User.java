package model;

import presentation.ClientView;

import java.io.Serializable;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class User implements Serializable, Observer {

    private int id;
    private String name;
    private String password;
    private Role role;
    private static String afiseaza;


    public User(String name,String password,Role role,ClientView clientView)
    {
        this.name=name;
        this.password=password;
        this.role=role;
    }

    public User(String name, String password)
    {
        this.name=name;
        this.password=password;
    }

    public User(int id,String name,String password,Role role)
    {
        this.id=id;
        this.name=name;
        this.password=password;
        this.role=role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRoleString() {
        return role.toString();
    }

    public static String getAfiseaza() {
        return afiseaza;
    }

    public static void setAfiseaza(String afiseaza) {
        User.afiseaza = afiseaza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        String s="An order has been placed :"+(int)arg+" I'm the employee with id "+this.id+" named "+this.name;
        setAfiseaza(s);
    }

}
