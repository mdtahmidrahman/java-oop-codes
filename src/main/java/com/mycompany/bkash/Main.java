package com.mycompany.bkash;

import javax.swing.*;

public class Main {
    private static Bkash bkash = new Bkash();

    public static void main(String[] args) {
        showRegistrationGUI();
    }

    private static void showRegistrationGUI() {
        JTextField phoneNumberField = new JTextField(10);
        JTextField pinField = new JPasswordField(4);

        JPanel registrationPanel = new JPanel();
        registrationPanel.add(new JLabel("Phone Number:"));
        registrationPanel.add(phoneNumberField);
        registrationPanel.add(new JLabel("PIN:"));
        registrationPanel.add(pinField);

        int result = JOptionPane.showConfirmDialog(null, registrationPanel, 
            "Register for Bkash", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String phoneNumber = phoneNumberField.getText();
            String pin = pinField.getText();
            
            bkash.registerUser(phoneNumber, pin);

            JOptionPane.showMessageDialog(null, "Registered Successfully!");

            showLoginGUI();
        }
    }

    private static void showLoginGUI() {
        JTextField phoneNumberField = new JTextField(10);
        JTextField pinField = new JPasswordField(4);

        JPanel loginPanel = new JPanel();
        loginPanel.add(new JLabel("Phone Number:"));
        loginPanel.add(phoneNumberField);
        loginPanel.add(new JLabel("PIN:"));
        loginPanel.add(pinField);

        int result = JOptionPane.showConfirmDialog(null, loginPanel, 
            "Bkash Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String phoneNumber = phoneNumberField.getText();
            String pin = pinField.getText();

            BkashUser user = bkash.signIn(phoneNumber, pin);

            if (user != null) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                showMainMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                showLoginGUI(); 
            }
        }
    }

    private static void showMainMenu() {
        JFrame mainMenuFrame = new JFrame("Bkash Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(300, 200);

        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.add(new JLabel("Welcome to Bkash Main Menu!"));

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton sendMoneyButton = new JButton("Send Money");

        mainMenuPanel.add(checkBalanceButton);
        mainMenuPanel.add(sendMoneyButton);

        mainMenuFrame.add(mainMenuPanel);
        mainMenuFrame.setVisible(true);
    }
}
