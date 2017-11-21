package com.wambua.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * This class deals with all db access and transaction needs.
 *
 * @Author Rodgers
 *
 * ACCESS MODIFIERS public,static,private,protected
 *
 * public allows you to access anywhere in the project. static allows you to
 * access without instantiation/object. works with public i.e public static ...
 * private - cannot be accessed out of the original class. protected - can be
 * accessed in all classes of a particular package.
 * @author wcb family
 */
public class DatabaseAccessObjects {

    public static void main(String[] args) {
        System.err.println(Boolean.hashCode(true));
    }

    /**
     * Update seat booking status for all buses.
     *
     * @param seatNo - Integer
     * @param coachType - String
     * @param isBooked - Boolean
     */
    public static void updateCoachSeatBookingStatus(Integer seatNo, Boolean isBooked, String busname) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanagementsystem?autoReconnect=true&useSSL=false","root","")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + busname + " SET isBooked = ? WHERE seat_No = ?;");
            preparedStatement.setInt(1, getBooleanIntValue(isBooked));
            preparedStatement.setInt(2, seatNo);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Seat Booking status Updated Successfully!!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static Boolean checkBusSeatBookingStatus(Integer seatNo, String busname, String dot) {
        Integer isBooked = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanagementsystem?autoReconnect=true&useSSL=false", "root", "")) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT isBooked FROM " + busname + " WHERE seat_No = ? AND  TravelDate = ?;");
            preparedStatement.setInt(1, seatNo);
            preparedStatement.setString(2, dot);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                isBooked = resultSet.getInt(1);
            }
            return getIntValueFromBoolean(isBooked);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public static Boolean getIntValueFromBoolean(Integer isBooked) {
        Boolean value = false;
        if (isBooked.equals(1)) {
            value = true;
        } else if (isBooked.equals(0)) {
            value = false;
        } else {
            JOptionPane.showMessageDialog(null, "Unexpected Boolean value.");
        }
        return value;
    }

    public static Integer getBooleanIntValue(Boolean booleanValue) {
        Integer value = 0;
        if (booleanValue.equals(true)) {
            value = 1;
        } else if (booleanValue.equals(false)) {
            value = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Unexpected Boolean value.");
        }
        return value;
    }

    public static void createBussBookingEntry(HashMap<String, String> hashMap) {
        String sql = "Insert into buses (Regno, Bus_Name, Departure, VIP_seat, Normal_seat, VIP_fare, Normal_fare, `From`, Destination, DOT ) values ( ?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = javaconnect.ConnectrDb();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, hashMap.get("regno"));
            preparedStatement.setString(2, hashMap.get("bus_name"));
            preparedStatement.setString(3, hashMap.get("depature"));
            preparedStatement.setString(4, hashMap.get("vip_seat"));
            preparedStatement.setString(5, hashMap.get("normal_seat"));
            preparedStatement.setString(6, hashMap.get("vip_fare"));
            preparedStatement.setString(7, hashMap.get("normal_fare"));
            preparedStatement.setString(8, hashMap.get("from"));
            preparedStatement.setString(9, hashMap.get("destination"));
            preparedStatement.setString(10, hashMap.get("dot"));
            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, " New Bus Added in to the system");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static HashSet<String> getBusNames() {
        HashSet<String> busHashSet = new HashSet<>();
        try {
            Connection conn = javaconnect.ConnectrDb();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT bus_name FROM buses;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                busHashSet.add(resultSet.getString(1));
            }
            return busHashSet;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            return new HashSet<>();

        }
    }

    public static boolean isBookingExists(String dot) {
        int count = 0;
        try {
            Connection conn = javaconnect.ConnectrDb();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    " SELECT COUNT(*) FROM buses WHERE dot = ?");
            preparedStatement.setString(1, dot);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public static HashSet<String> getBussNamesBasedOnTravelDate(String dot){
        HashSet<String> busNamesHashSet = new HashSet<>();
        try {
            Connection conn = javaconnect.ConnectrDb();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT bus_name FROM buses WHERE dot = ?;");
            preparedStatement.setString(1, dot);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                busNamesHashSet.add(resultSet.getString(1));
            }
            return busNamesHashSet;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            return new HashSet<>();

        }
    }
    
    /**
     * SQL INJECTION
     * @param from
     * @param destination
     * @param dot
     * @return 
     */
    public static List<String> getBussNamesBasedOnTravelDateAndDestination(String from,String destination,String dot){
        List<String> busNamesHashSet = new ArrayList<>();
        try {
            Connection conn = javaconnect.ConnectrDb();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT bus_name FROM buses WHERE `from`= ? AND Destination = ? OR DOT = ? ORDER BY Departure ASC;");
            preparedStatement.setString(1, from);
            preparedStatement.setString(2,destination);
            preparedStatement.setString(3, dot);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                busNamesHashSet.add(resultSet.getString(1));
            }
            return busNamesHashSet;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            return new ArrayList<>();

        }
    }
}
