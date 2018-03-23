package com.wambua.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class javaconnect {
    Connection conn;
    
    
 public static Connection ConnectDb(){
     try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/busmanagementsystem?autoReconnect=true&useSSL=false","root","123");
         return conn;
         
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
         return null;
     }
 }
}
