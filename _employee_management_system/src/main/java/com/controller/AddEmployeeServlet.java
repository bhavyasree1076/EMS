package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.db.DBConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        System.out.println("🔥 AddEmployeeServlet HIT");

        String name = request.getParameter("empName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String department = request.getParameter("department");
        String salaryStr = request.getParameter("salary");

        System.out.println(name + " | " + email + " | " + mobile);

        try {
            double salary = Double.parseDouble(salaryStr);

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employee (name,email,mobile,department,salary) VALUES (?,?,?,?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, mobile);
            ps.setString(4, department);
            ps.setDouble(5, salary);

            ps.executeUpdate();

            System.out.println("✅ INSERT SUCCESS");

            response.sendRedirect(request.getContextPath() + "/viewEmployee");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
