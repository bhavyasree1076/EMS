package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstname = request.getParameter("firstname");
        String lastname  = request.getParameter("lastname");
        String mobile    = request.getParameter("mobile");
        String username  = request.getParameter("username");
        String password  = request.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO users(firstname, lastname, mobile, username, password) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, mobile);
            ps.setString(4, username);
            ps.setString(5, password);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                response.sendRedirect("index.html?success=1");
            } else {
                response.sendRedirect("register.html?error=1");
            }

        } catch (Exception e) {
            e.printStackTrace();   // 🔴 VERY IMPORTANT
            response.sendRedirect("register.html?error=1");
        }
    }
}
