package com.alpha07.jdbc;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Servlet", value = "/test")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcURL = "jdbc:mysql://localhost:3306/spring_mvc_hibernate?useSSL=false&serverTimezone=UTC"; // Database JDBC URL
        String user = "root"; // mySql username
        String password = "123"; // mySql password
        PrintWriter printWriter = response.getWriter();

        try{
            printWriter.print("Connecting to : " + jdbcURL);

            // Load MySQL JDBC driver explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcURL, user, password); // Create connection using DriverManager

            printWriter.print("\nConnection established : " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
