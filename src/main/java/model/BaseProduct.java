package model;

import java.io.Serializable;

public class BaseProduct extends MenuItem implements Serializable  {


    public BaseProduct(String title, Double rating, Double calories, Double proteins, Double fats, Double sodium, Double price) {
        super(title,rating,calories,proteins,fats,sodium,price);
    }



}
