package presentation;

import model.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginRegisterView extends JFrame {


    private JTextField userTextField;
    private JPasswordField passwordTextField;

    private JButton loginButton;
    private JButton registerButton;

    private JComboBox<String> userComboBox;

    public LoginRegisterView() {
        this.setBounds(100, 100, 1249, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titluLabel = new JLabel("FOOD DELIVERY MANAGEMENT SYSTEM");
        titluLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        titluLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titluLabel.setBounds(422, 11, 340, 20);
        this.getContentPane().add(titluLabel);

        JLabel lblNewLabel = new JLabel("Username :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(50, 173, 97, 20);
        this.getContentPane().add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPassword.setBounds(50, 218, 97, 20);
        this.getContentPane().add(lblPassword);

        userTextField = new JTextField();
        userTextField.setBounds(157, 172, 185, 26);
        this.getContentPane().add(userTextField);
        userTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(157, 217, 185, 26);
        this.getContentPane().add(passwordTextField);

        loginButton = new JButton("Login");
        loginButton.setBounds(253, 316, 89, 31);
        this.getContentPane().add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(157, 316, 89, 31);
        this.getContentPane().add(registerButton);

        JLabel lblUserType = new JLabel("UserType :");
        lblUserType.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUserType.setBounds(50, 261, 97, 20);
        this.getContentPane().add(lblUserType);

        userComboBox = new JComboBox();
        userComboBox.setModel(new DefaultComboBoxModel(new String[]{"REGULAR_EMPLOYEE", "CLIENT"}));
        userComboBox.setBounds(157, 262, 185, 22);
        this.getContentPane().add(userComboBox);
        this.setVisible(true);
    }

    public Role getUserComboBox() {
        String aux = userComboBox.getSelectedItem().toString();
        if (aux.equals(Role.ADMINISTRATOR.toString()))
            return Role.ADMINISTRATOR;
        if (aux.equals(Role.CLIENT.toString()))
            return Role.CLIENT;
        if (aux.equals(Role.REGULAR_EMPLOYEE.toString()))
            return Role.REGULAR_EMPLOYEE;
        return null;
    }


    public String getNameText() {
        return userTextField.getText();
    }

    public String getPasswordText() {
        String aux=String.valueOf(passwordTextField.getPassword());
        return aux;
    }

    public void loginListener(ActionListener action) {
        loginButton.addActionListener(action);
    }

    public void registerListener(ActionListener action) {
        registerButton.addActionListener(action);
    }

    public void refresh() {
        passwordTextField.setText(null);
        userTextField.setText(null);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
