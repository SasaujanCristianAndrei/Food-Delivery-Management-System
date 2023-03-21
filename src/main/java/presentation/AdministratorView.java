package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministratorView extends JFrame{
    private JTextField titleTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JTextField newProductName;
    private JTextField startHourField;
    private JTextField endHourField;

    private JTextArea textAreaCompute;

    private JButton addProductButton;
    private JButton deleteProductButton;
    private JButton modifyProductButton;
    private JButton importProductsButton;
    private JButton generateReportsButton;
    private JButton createProductButton;
    private JButton viewProductsButton;

    private JTable table;

    public AdministratorView() {
        //this= new Jthis();

        this.setBounds(100, 100, 1249, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titluLabel = new JLabel("FOOD DELIVERY MANAGEMENT SYSTEM");
        titluLabel.setBounds(422, 11, 340, 20);
        titluLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titluLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(titluLabel);

        JLabel lblNewLabel = new JLabel("Title :");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(49, 26, 46, 14);
        this.getContentPane().add(lblNewLabel);

        JLabel lblRating = new JLabel("Rating :");
        lblRating.setHorizontalAlignment(SwingConstants.CENTER);
        lblRating.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblRating.setBounds(35, 51, 60, 20);
        this.getContentPane().add(lblRating);

        JLabel lblNewLabel_1_1 = new JLabel("Calories :");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(26, 82, 69, 20);
        this.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Protein :");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(35, 113, 69, 14);
        this.getContentPane().add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Fat :");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(64, 138, 31, 14);
        this.getContentPane().add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sodium :");
        lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_1.setBounds(26, 170, 69, 14);
        this.getContentPane().add(lblNewLabel_1_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Price :");
        lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_1_1.setBounds(35, 201, 69, 14);
        this.getContentPane().add(lblNewLabel_1_1_1_1_1_1);

        titleTextField = new JTextField();
        titleTextField.setBounds(99, 25, 142, 20);
        this.getContentPane().add(titleTextField);
        titleTextField.setColumns(10);

        ratingTextField = new JTextField();
        ratingTextField.setBounds(99, 51, 142, 20);
        this.getContentPane().add(ratingTextField);
        ratingTextField.setColumns(10);

        caloriesTextField = new JTextField();
        caloriesTextField.setColumns(10);
        caloriesTextField.setBounds(99, 82, 142, 20);
        this.getContentPane().add(caloriesTextField);

        proteinTextField = new JTextField();
        proteinTextField.setColumns(10);
        proteinTextField.setBounds(99, 113, 142, 20);
        this.getContentPane().add(proteinTextField);

        fatTextField = new JTextField();
        fatTextField.setColumns(10);
        fatTextField.setBounds(99, 139, 142, 20);
        this.getContentPane().add(fatTextField);

        sodiumTextField = new JTextField();
        sodiumTextField.setColumns(10);
        sodiumTextField.setBounds(99, 169, 142, 20);
        this.getContentPane().add(sodiumTextField);

        priceTextField = new JTextField();
        priceTextField.setColumns(10);
        priceTextField.setBounds(99, 200, 142, 20);
        this.getContentPane().add(priceTextField);

        addProductButton = new JButton("Add Product");
        addProductButton.setBounds(21, 262, 141, 23);
        this.getContentPane().add(addProductButton);

        deleteProductButton = new JButton("Delete Product");
        deleteProductButton.setBounds(172, 262, 148, 23);
        this.getContentPane().add(deleteProductButton);

        modifyProductButton = new JButton("Modify Product");
        modifyProductButton.setBounds(21, 296, 141, 23);
        this.getContentPane().add(modifyProductButton);

        createProductButton = new JButton("Create Product");
        createProductButton.setBounds(233, 555, 116, 23);
        this.getContentPane().add(createProductButton);

        importProductsButton = new JButton("Import Products");
        importProductsButton.setBounds(21, 329, 141, 23);
        this.getContentPane().add(importProductsButton);

        generateReportsButton = new JButton("Generate Reports");
        generateReportsButton.setBounds(172, 329, 148, 23);
        this.getContentPane().add(generateReportsButton);

        viewProductsButton = new JButton("View Products");
        viewProductsButton.setBounds(172, 296, 148, 23);
        this.getContentPane().add(viewProductsButton);

        textAreaCompute = new JTextArea();
        textAreaCompute.setBounds(21, 392, 296, 118);
        this.getContentPane().add(textAreaCompute);

        JLabel lblNewLabel_1 = new JLabel("Insert the ID'S of Products (followed by ,)");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(21, 367, 299, 20);
        this.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Name of the new Product");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(21, 525, 184, 14);
        this.getContentPane().add(lblNewLabel_2);

        newProductName = new JTextField();
        newProductName.setBounds(207, 524, 163, 20);
        this.getContentPane().add(newProductName);
        newProductName.setColumns(10);

    }

    public String getNewProductName() {
        return newProductName.getText();
    }

    public String getTitleTextField() {
        return titleTextField.getText();
    }

    public Double getRatingTextField() {
        return Double.parseDouble(ratingTextField.getText());
    }

    public Double getCaloriesTextField() {
        return Double.parseDouble(caloriesTextField.getText());
    }

    public Double getProteinTextField() {
        return Double.parseDouble(proteinTextField.getText());
    }

    public Double getFatTextField() {
        return Double.parseDouble(fatTextField.getText());
    }

    public Double getSodiumTextField() {
        return Double.parseDouble(sodiumTextField.getText());
    }

    public Double getPriceTextField() {
        return Double.parseDouble(priceTextField.getText());
    }

    public void addProductListener(ActionListener action) {
        addProductButton.addActionListener(action);
    }

    public void viewProductsListener(ActionListener action){viewProductsButton.addActionListener(action);}

    public void deleteProductListener(ActionListener action) {
        deleteProductButton.addActionListener(action);
    }

    public void modifyProductListener(ActionListener action) {
        modifyProductButton.addActionListener(action);
    }

    public void createProductListener(ActionListener action) {
        createProductButton.addActionListener(action);
    }
    public void importProductListener(ActionListener action)
    {
       importProductsButton.addActionListener(action);
    }
    public void generateReportsListener(ActionListener action)
    {
        generateReportsButton.addActionListener(action);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String getTextAreaCompute() {
        return textAreaCompute.getText();
    }

    public void setTextAreaCompute(JTextArea textAreaCompute) {
        this.textAreaCompute = textAreaCompute;
    }
}
