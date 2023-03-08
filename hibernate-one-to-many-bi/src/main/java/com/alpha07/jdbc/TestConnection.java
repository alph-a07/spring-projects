package com.alpha07.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/one_to_one_uni?useSSL=false&serverTimezone=UTC"; // Database JDBC URL
        String user = "root"; // mySql username
        String password = "123"; // mySql password

        try{
            System.out.println(">> Connecting to : " + jdbcURL);

            Connection connection = DriverManager.getConnection(jdbcURL, user, password); // Create connection using DriverManager

            System.out.println(">> Connection established : " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
