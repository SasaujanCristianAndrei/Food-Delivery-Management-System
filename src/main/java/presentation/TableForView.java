package presentation;

import model.BaseProduct;
import model.MenuItem;
import model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TableForView {
    JTable table;
    private String[] columnNames;
    private String[][] data;
    private HashSet<String> hashSet;

    /**
     * @param object List<T></T>
     */
    @SuppressWarnings("unchecked")
    public TableForView(List<MenuItem> object) {
        hashSet = new HashSet<>();
        columnNames = new String[8];
        data = new String[object.size()][8];
        buildTable(object);
        setData();
    }

    public TableForView(ArrayList<User> object) {
        hashSet = new HashSet<>();
        columnNames = new String[3];
        data = new String[object.size()][3];
        buildTable(object);
        setData();
    }

    public void buildTable(ArrayList<User> object) {

        columnNames[0] = "Id";
        columnNames[1] = "Name";
        columnNames[2] = "Role";
        int contorI = 0;
        int contorJ = 0;
        for (User x : object) {
            data[contorI][contorJ++] = String.valueOf(x.getId());
            data[contorI][contorJ++] = x.getName();
            data[contorI][contorJ++] = String.valueOf(x.getRole());
            contorI++;
            contorJ = 0;
        }
    }


    /**
     * @param object List<T></T>
     */
    public void buildTable(List<MenuItem> object) {

        columnNames[0] = "Id";
        columnNames[1] = "Title";
        columnNames[2] = "Rating";
        columnNames[3] = "Calories";
        columnNames[4] = "Proteins";
        columnNames[5] = "Fats";
        columnNames[6] = "Sodium";
        columnNames[7] = "Price";

        int contorI = 0;
        int contorJ = 0;
        for (MenuItem x : object) {
            data[contorI][contorJ++] = x.getId().toString();
            data[contorI][contorJ++] = x.getTitle();
            data[contorI][contorJ++] = String.format("%.2f", x.getRating());
            data[contorI][contorJ++] = String.format("%.2f", x.getCalories());
            data[contorI][contorJ++] = String.format("%.2f", x.getProteins());
            data[contorI][contorJ++] = String.format("%.2f", x.getFats());
            data[contorI][contorJ++] = String.format("%.2f", x.getSodium());
            data[contorI][contorJ] = String.format("%.2f", x.getPrice());
            contorI++;
            contorJ = 0;
        }
    }

    public void setData() {
        table = new JTable(data, columnNames);
        table.setBounds(415, 42, 781, 502);
    }

    public JTable getTable() {
        return table;
    }

}
