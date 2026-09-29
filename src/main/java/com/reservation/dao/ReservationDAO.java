package com.reservation.dao;

import com.reservation.DBConnection;
import com.reservation.model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservationDAO {

    // Make Reservation
    public void addReservation(Reservation reservation) {

        String sql = "INSERT INTO reservations " +
                "(user_id, train_id, journey_date, number_of_seats, status) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reservation.getUserId());
            ps.setInt(2, reservation.getTrainId());
            ps.setString(3, reservation.getJourneyDate());
            ps.setInt(4, reservation.getNumberOfSeats());
            ps.setString(5, reservation.getStatus());

            ps.executeUpdate();

            System.out.println("Reservation successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find Reservation by ID
    public Reservation getReservationById(int reservationId) {

        String sql = "SELECT * FROM reservations WHERE reservation_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reservationId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("user_id"),
                        rs.getInt("train_id"),
                        rs.getString("journey_date"),
                        rs.getInt("number_of_seats"),
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Cancel Reservation
    public void cancelReservation(int reservationId) {

        String sql = "UPDATE reservations SET status = 'CANCELLED' " +
                "WHERE reservation_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, reservationId);

            ps.executeUpdate();

            System.out.println("Reservation cancelled successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}