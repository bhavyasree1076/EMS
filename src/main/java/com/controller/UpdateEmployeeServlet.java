package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.DBConnection;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE employee SET name=?, email=?, mobile=?, department=?, salary=? WHERE id=?"
            );

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, mobile);
            ps.setString(4, department);
            ps.setDouble(5, salary);
            ps.setInt(6, id);

            ps.executeUpdate();
            response.sendRedirect(request.getContextPath() + "/viewEmployee");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
