package com.reservation.ui;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;

    public LoginForm() {

        setTitle("Online Reservation System - Login");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        );

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(exitButton);

        add(panel);

        loginButton.addActionListener(e -> login());

        exitButton.addActionListener(e -> System.exit(0));
    }

    private void login() {

        String email = emailField.getText().trim();
        String password =
                new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter email and password."
            );

            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Login successful!"
        );

        new ReservationForm().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}