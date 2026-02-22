package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.DBConnection;
import com.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM employee WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setMobile(rs.getString("mobile"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));

                // ✅ IMPORTANT
                request.setAttribute("employee", e);

                request.getRequestDispatcher("editEmployee.jsp")
                       .forward(request, response);
            } else {
                response.sendRedirect("viewEmployee");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("viewEmployee");
        }
    }
}
