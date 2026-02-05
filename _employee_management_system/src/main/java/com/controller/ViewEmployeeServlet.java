package com.controller;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.model.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/viewEmployee")
public class ViewEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        List<Employee> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement("SELECT * FROM employee");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setMobile(rs.getString("mobile"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getDouble("salary"));
                list.add(e);
            }

            request.setAttribute("empList", list);
            request.getRequestDispatcher("viewEmployee.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
