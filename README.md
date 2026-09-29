# Online Reservation System

## About Project

Online Reservation System is a Java desktop application for booking and cancelling train reservations.

## Technologies Used

- Java
- Java Swing
- JDBC
- SQLite
- Maven

## Features

- User Login
- Train Reservation
- Generate Unique PNR
- View Booking Details
- Cancel Reservation
- Input Validation

## Project Structure

```text
OnlineReservationSystem
│
├── pom.xml
├── README.md
│
└── src
    └── main
        └── java
            └── com
                └── reservation
                    ├── Main.java
                    ├── DBConnection.java
                    │
                    ├── dao
                    │   ├── UserDAO.java
                    │   ├── TrainDAO.java
                    │   └── ReservationDAO.java
                    │
                    ├── model
                    │   ├── User.java
                    │   ├── Train.java
                    │   └── Reservation.java
                    │
                    └── ui
                        ├── LoginForm.java
                        ├── ReservationForm.java
                        └── CancellationForm.java
