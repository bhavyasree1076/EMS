<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("index.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/dashboard.css">
</head>
<body>
<nav class="navbar">
    <div class="navbar-left">
        <h2>Employee Management System</h2>
    </div>
    <div class="navbar-right">
        <a href="logout" class="logout-btn">Logout</a>
    </div>
</nav>
<div class="dashboard-container">
    <h2>Dashboard</h2>

    <div class="card-container">

        <a href="addEmployee.jsp" class="card">
            <h3>Add Employee</h3>
            <p>Add new employee details</p>
        </a>

        <a href="viewEmployee" class="card">
            <h3>View Employees</h3>
            <p>View employee list</p>
        </a>

    </div>
</div>

</body>
</html>