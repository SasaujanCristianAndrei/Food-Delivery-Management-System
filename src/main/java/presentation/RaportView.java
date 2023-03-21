package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RaportView extends JFrame {

    private JTextField startHourTextField;
    private JTextField endHourTextField;
    private JTextField moreThanJTextField;
    private JTextField valueTextField;
    private JTextField dateTextField;
    private JTextField numberTimesTextField;

    private JTextArea raport4TextArea;

    private JButton raport1Button;
    private JButton raport2Button;
    private JButton raport3Button;
    private JButton raport4Button;


    public RaportView()
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

        startHourTextField = new JTextField();
        startHourTextField.setBounds(112, 96, 86, 20);
        this.getContentPane().add(startHourTextField);
        startHourTextField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Start Hour:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(30, 97, 84, 14);
        this.getContentPane().add(lblNewLabel);

        JLabel lblEndHour = new JLabel("End Hour:");
        lblEndHour.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEndHour.setBounds(40, 127, 84, 14);
        this.getContentPane().add(lblEndHour);

        endHourTextField = new JTextField();
        endHourTextField.setBounds(112, 127, 86, 20);
        this.getContentPane().add(endHourTextField);
        endHourTextField.setColumns(10);

        raport1Button = new JButton("Raport 1");
        raport1Button.setBounds(66, 152, 132, 23);
        this.getContentPane().add(raport1Button);

        JLabel lblCommand = new JLabel("More than:");
        lblCommand.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCommand.setBounds(30, 277, 84, 14);
        this.getContentPane().add(lblCommand);

        moreThanJTextField = new JTextField();
        moreThanJTextField.setBounds(112, 276, 86, 20);
        this.getContentPane().add(moreThanJTextField);
        moreThanJTextField.setColumns(10);

        JLabel lblValue = new JLabel("Value:");
        lblValue.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblValue.setBounds(62, 307, 52, 14);
        this.getContentPane().add(lblValue);

        valueTextField = new JTextField();
        valueTextField.setColumns(10);
        valueTextField.setBounds(112, 301, 86, 20);
        this.getContentPane().add(valueTextField);

        raport3Button = new JButton("Raport 3");
        raport3Button.setBounds(66, 332, 132, 23);
        this.getContentPane().add(raport3Button);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDate.setBounds(66, 380, 43, 14);
        this.getContentPane().add(lblDate);

        dateTextField = new JTextField();
        dateTextField.setBounds(112, 379, 86, 20);
        this.getContentPane().add(dateTextField);
        dateTextField.setColumns(10);

        raport4Button = new JButton("Raport 4");
        raport4Button.setBounds(66, 410, 132, 23);
        this.getContentPane().add(raport4Button);

        JLabel numberTimesLabel = new JLabel("Number of Times:");
        numberTimesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        numberTimesLabel.setBounds(10, 206, 140, 14);
        this.getContentPane().add(numberTimesLabel);

        numberTimesTextField = new JTextField();
        numberTimesTextField.setColumns(10);
        numberTimesTextField.setBounds(138, 205, 86, 20);
        this.getContentPane().add(numberTimesTextField);

        raport2Button = new JButton("Raport 2");
        raport2Button .setBounds(66, 231, 132, 23);
        this.getContentPane().add( raport2Button );

        raport4TextArea = new JTextArea();
        raport4TextArea.setBounds(22, 488, 400, 162);
        raport4TextArea.setLineWrap(true);
        this.getContentPane().add(raport4TextArea);

        JLabel lblNewLabel_1 = new JLabel("Raport 4:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(21, 465, 66, 20);
        this.getContentPane().add(lblNewLabel_1);
    }

    public Integer getStartHourField() {
        return Integer.parseInt(startHourTextField.getText());
    }
    public Integer getNumberTimesField() {
        return Integer.parseInt(numberTimesTextField.getText());
    }
    public Integer getEndHourField() {
        return Integer.parseInt(endHourTextField.getText());
    }
    public Integer getMoreThanField() {
        return Integer.parseInt(moreThanJTextField.getText());
    }
    public Double getValueTextField() {
        return Double.parseDouble(valueTextField.getText());
    }
    public Integer getDayTextField(){return Integer.parseInt(dateTextField.getText());}

    public void raport1Listener(ActionListener action) {
        raport1Button.addActionListener(action);
    }
    public void raport2Listener(ActionListener action) {
        raport2Button.addActionListener(action);
    }
    public void raport3Listener(ActionListener action) {
        raport3Button.addActionListener(action);
    }
    public void raport4Listener(ActionListener action) {
        raport4Button.addActionListener(action);
    }

    public JTextArea getRaport4TextArea() {
        return raport4TextArea;
    }

    public void setRaport4TextArea(String string) {
       raport4TextArea.setText(string);
    }
}
