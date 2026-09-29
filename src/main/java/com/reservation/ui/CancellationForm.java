package com.reservation.ui;

import javax.swing.*;
import java.awt.*;

public class CancellationForm extends JFrame {

    private JTextField pnrField;

    public CancellationForm() {

        setTitle(
                "Online Reservation System - Cancellation"
        );

        setSize(450, 300);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        JPanel panel =
                new JPanel(new GridLayout(3, 2, 10, 10));

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        30, 30, 30, 30
                )
        );

        JLabel pnrLabel =
                new JLabel("Enter PNR:");

        pnrField =
                new JTextField();

        JButton cancelButton =
                new JButton("Cancel Reservation");

        JButton backButton =
                new JButton("Back");

        panel.add(pnrLabel);
        panel.add(pnrField);

        panel.add(cancelButton);
        panel.add(backButton);

        add(panel);

        cancelButton.addActionListener(
                e -> cancelReservation()
        );

        backButton.addActionListener(e -> {

            new ReservationForm().setVisible(true);
            dispose();

        });
    }

    private void cancelReservation() {

        String pnr =
                pnrField.getText().trim();

        if (pnr.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter PNR."
            );

            return;
        }

        int choice =
                JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to cancel "
                                + "reservation with PNR: "
                                + pnr + "?",
                        "Confirm Cancellation",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(
                    this,
                    "Reservation cancelled successfully!",
                    "Cancellation",
                    JOptionPane.INFORMATION_MESSAGE
            );

            pnrField.setText("");
        }
    }
}