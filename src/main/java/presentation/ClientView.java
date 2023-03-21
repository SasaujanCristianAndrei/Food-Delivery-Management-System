package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientView extends JFrame {

    private JButton viewProductsButton;
    private JButton searchProductsButton;
    private JButton placeOrderButton;

    private JTextField titleTextFieldClient;
    private JTextField proteinTextFieldClient;
    private JTextField priceTextFieldClient;
    private JTextField sodiumTextFieldClient;
    private JTextField fatTextFieldClient;
    private JTextField ratingTextFieldClient;
    private JTextField caloriesTextFieldClient;

    private JTextArea commandTextField;

    public ClientView()
    {
        //frame = new JFrame();
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
        lblNewLabel.setBounds(55, 64, 46, 14);
        this.getContentPane().add(lblNewLabel);

        JLabel lblRating = new JLabel("Rating :");
        lblRating.setHorizontalAlignment(SwingConstants.CENTER);
        lblRating.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblRating.setBounds(41, 89, 60, 20);
        this.getContentPane().add(lblRating);

        JLabel lblNewLabel_1_1 = new JLabel("Calories :");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(32, 120, 69, 20);
        this.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("Protein :");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(32, 152, 69, 14);
        this.getContentPane().add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_1_1 = new JLabel("Fat :");
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(65, 177, 31, 14);
        this.getContentPane().add(lblNewLabel_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Sodium :");
        lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_1.setBounds(32, 202, 69, 14);
        this.getContentPane().add(lblNewLabel_1_1_1_1_1);

        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Price :");
        lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1_1_1.setBounds(43, 227, 69, 14);
        this.getContentPane().add(lblNewLabel_1_1_1_1_1_1);

        titleTextFieldClient = new JTextField();
        titleTextFieldClient.setBounds(99, 63, 142, 20);
        this.getContentPane().add(titleTextFieldClient);
        titleTextFieldClient.setColumns(10);

        ratingTextFieldClient = new JTextField();
        ratingTextFieldClient.setBounds(99, 91, 142, 20);
        this.getContentPane().add(ratingTextFieldClient);
        ratingTextFieldClient.setColumns(10);

        caloriesTextFieldClient = new JTextField();
        caloriesTextFieldClient.setColumns(10);
        caloriesTextFieldClient.setBounds(99, 122, 142, 20);
        this.getContentPane().add(caloriesTextFieldClient);

        proteinTextFieldClient = new JTextField();
        proteinTextFieldClient.setColumns(10);
        proteinTextFieldClient.setBounds(99, 151, 142, 20);
        this.getContentPane().add(proteinTextFieldClient);

        fatTextFieldClient = new JTextField();
        fatTextFieldClient.setColumns(10);
        fatTextFieldClient.setBounds(99, 177, 142, 20);
        this.getContentPane().add(fatTextFieldClient);

        sodiumTextFieldClient = new JTextField();
        sodiumTextFieldClient.setColumns(10);
        sodiumTextFieldClient.setBounds(99, 202, 142, 20);
        this.getContentPane().add(sodiumTextFieldClient);

        priceTextFieldClient = new JTextField();
        priceTextFieldClient.setColumns(10);
        priceTextFieldClient.setBounds(99, 226, 142, 20);
        this.getContentPane().add(priceTextFieldClient);

        viewProductsButton = new JButton("View Products");
        viewProductsButton.setBounds(23, 302, 130, 23);
        this.getContentPane().add(viewProductsButton);

        searchProductsButton = new JButton("Search Products");
        searchProductsButton.setBounds(175, 302, 144, 23);
        this.getContentPane().add(searchProductsButton);

        placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(109, 500, 130, 23);
        this.getContentPane().add(placeOrderButton);

        JLabel commandLabel = new JLabel("Your Command (separately by , Ex: c1,c2):");
        commandLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        commandLabel.setBounds(23, 336, 296, 20);
        this.getContentPane().add(commandLabel);

        commandTextField = new JTextArea();
        commandTextField.setBounds(23, 361, 296, 128);
        commandTextField.setLineWrap(true);
        this.getContentPane().add(commandTextField);
    }

    public void viewProductsClientListener(ActionListener action){viewProductsButton.addActionListener(action);}
    public void searchProductListener(ActionListener action){searchProductsButton.addActionListener(action);}
    public void placeOrderProductListener(ActionListener action){placeOrderButton.addActionListener(action);}

    public String getTitleTextField() {
        return titleTextFieldClient.getText();
    }

    public Double getRatingTextField() {
        try{
            return Double.parseDouble(ratingTextFieldClient.getText());
        }catch (Exception ex)
        {
            return null;
        }
    }

    public Double getCaloriesTextField() {
        try {
            return Double.parseDouble(caloriesTextFieldClient.getText());
        }catch (Exception ex)
        {
            return null;
        }

    }

    public Double getProteinTextField() {
        try {
            return Double.parseDouble(proteinTextFieldClient.getText());
        }catch (Exception ex)
        {
            return null;
        }

    }

    public Double getFatTextField() {
        try{
            return Double.parseDouble(fatTextFieldClient.getText());
        }catch (Exception ex)
        {
            return null;
        }
    }

    public Double getSodiumTextField() {

        try{
            return Double.parseDouble(sodiumTextFieldClient.getText());
        }catch (Exception ex)
        {
            return null;
        }
    }

    public Double getPriceTextField() {
        try
        {
            return Double.parseDouble(priceTextFieldClient.getText());
        }catch (Exception ex)
        {
            return null;
        }
    }

    public String getCommandTextField() {
        return commandTextField.getText();
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
