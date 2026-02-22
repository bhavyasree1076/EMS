package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.DBConnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("DELETE FROM employee WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

            response.sendRedirect("viewEmployee");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
