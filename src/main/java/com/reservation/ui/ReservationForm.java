package com.reservation.ui;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class ReservationForm extends JFrame {

    private JTextField passengerNameField;
    private JTextField trainNumberField;
    private JTextField trainNameField;
    private JComboBox<String> classTypeBox;
    private JTextField journeyDateField;
    private JTextField sourceField;
    private JTextField destinationField;

    public ReservationForm() {

        setTitle("Online Reservation System - Reservation");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel =
                new JPanel(new GridLayout(9, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 20, 20, 20
                )
        );

        panel.add(new JLabel("Passenger Name:"));
        passengerNameField = new JTextField();
        panel.add(passengerNameField);

        panel.add(new JLabel("Train Number:"));
        trainNumberField = new JTextField();
        panel.add(trainNumberField);

        panel.add(new JLabel("Train Name:"));
        trainNameField = new JTextField();
        trainNameField.setEditable(false);
        panel.add(trainNameField);

        panel.add(new JLabel("Class Type:"));

        classTypeBox = new JComboBox<>(
                new String[]{
                        "Sleeper",
                        "AC",
                        "First Class",
                        "Second Class"
                }
        );

        panel.add(classTypeBox);

        panel.add(new JLabel("Journey Date:"));
        journeyDateField = new JTextField();
        panel.add(journeyDateField);

        panel.add(new JLabel("Source:"));
        sourceField = new JTextField();
        panel.add(sourceField);

        panel.add(new JLabel("Destination:"));
        destinationField = new JTextField();
        panel.add(destinationField);

        JButton bookButton =
                new JButton("Book Reservation");

        JButton cancelButton =
                new JButton("Cancel Reservation");

        panel.add(bookButton);
        panel.add(cancelButton);

        JButton logoutButton =
                new JButton("Logout");

        panel.add(new JLabel());
        panel.add(logoutButton);

        add(panel);

        trainNumberField.addActionListener(
                e -> loadTrainName()
        );

        bookButton.addActionListener(
                e -> bookReservation()
        );

        cancelButton.addActionListener(e -> {

            new CancellationForm().setVisible(true);
            dispose();

        });

        logoutButton.addActionListener(e -> {

            new LoginForm().setVisible(true);
            dispose();

        });
    }

    private void loadTrainName() {

        String trainNumber =
                trainNumberField.getText().trim();

        if (trainNumber.isEmpty()) {
            trainNameField.setText("");
            return;
        }

        try {

            int number =
                    Integer.parseInt(trainNumber);

            if (number == 12711) {

                trainNameField.setText(
                        "Pinakini Express"
                );

            } else if (number == 12760) {

                trainNameField.setText(
                        "Charminar Express"
                );

            } else if (number == 12603) {

                trainNameField.setText(
                        "Chennai Express"
                );

            } else {

                trainNameField.setText(
                        "Train Not Found"
                );
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Train number must be numeric."
            );

            trainNameField.setText("");
        }
    }

    private void bookReservation() {

        String passengerName =
                passengerNameField.getText().trim();

        String trainNumber =
                trainNumberField.getText().trim();

        String trainName =
                trainNameField.getText().trim();

        String journeyDate =
                journeyDateField.getText().trim();

        String source =
                sourceField.getText().trim();

        String destination =
                destinationField.getText().trim();

        if (passengerName.isEmpty()
                || trainNumber.isEmpty()
                || journeyDate.isEmpty()
                || source.isEmpty()
                || destination.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields."
            );

            return;
        }

        try {

            Integer.parseInt(trainNumber);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Train number must be numeric."
            );

            return;
        }

        if (trainName.isEmpty()
                || trainName.equals("Train Not Found")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid train number."
            );

            return;
        }

        String pnr =
                "PNR"
                + UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase();

        String classType =
                (String) classTypeBox.getSelectedItem();

        JOptionPane.showMessageDialog(
                this,
                "Reservation Confirmed!\n\n"
                + "PNR: " + pnr + "\n"
                + "Passenger: " + passengerName + "\n"
                + "Train: " + trainName + "\n"
                + "Train Number: " + trainNumber + "\n"
                + "Class: " + classType + "\n"
                + "Journey Date: " + journeyDate + "\n"
                + "From: " + source + "\n"
                + "To: " + destination,
                "Booking Confirmation",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}