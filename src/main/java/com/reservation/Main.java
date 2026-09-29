package com.reservation;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        System.out.println("Online Reservation System");

        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("Application started successfully.");

            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}