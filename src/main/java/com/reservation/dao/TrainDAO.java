package com.reservation.dao;

import com.reservation.DBConnection;
import com.reservation.model.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrainDAO {

    // Add Train
    public void addTrain(Train train) {

        String sql = "INSERT INTO trains " +
                "(train_name, source, destination, available_seats) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, train.getTrainName());
            ps.setString(2, train.getSource());
            ps.setString(3, train.getDestination());
            ps.setInt(4, train.getAvailableSeats());

            ps.executeUpdate();

            System.out.println("Train added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find Train by ID
    public Train getTrainById(int trainId) {

        String sql = "SELECT * FROM trains WHERE train_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, trainId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Train(
                        rs.getInt("train_id"),
                        rs.getString("train_name"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getInt("available_seats")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}