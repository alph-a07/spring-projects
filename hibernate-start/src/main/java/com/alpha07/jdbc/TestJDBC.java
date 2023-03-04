package com.alpha07.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC"; // Database JDBC URL
        String user = "hbstdnt"; // mySql username
        String password = "hbstdnt"; // mySql password

        try{
            System.out.println(">> Connecting to : " + jdbcURL);

            Connection connection = DriverManager.getConnection(jdbcURL, user, password); // Create connection using DriverManager

            System.out.println(">> Connection established : " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
