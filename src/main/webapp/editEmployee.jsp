<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.model.Employee" %>

<%
    Employee emp = (Employee) request.getAttribute("employee");
    if (emp == null) {
        response.sendRedirect("viewEmployee");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="css/editEmployee.css">
</head>
<body>

<div class="form-container">
    <h2>Edit Employee</h2>

    <form action="updateEmployee" method="post">

        <input type="hidden" name="id" value="<%= emp.getId() %>">

        <input type="text" name="name" placeholder="Name"
               value="<%= emp.getName() %>" required>

        <input type="email" name="email" placeholder="Email"
               value="<%= emp.getEmail() %>" required>

        <input type="text" name="mobile" placeholder="Mobile"
               value="<%= emp.getMobile() %>" required>

        <input type="text" name="department" placeholder="Department"
               value="<%= emp.getDepartment() %>" required>

        <input type="number" step="0.01" name="salary" placeholder="Salary"
               value="<%= emp.getSalary() %>" required>

        <input type="submit" value="Update Employee">
    </form>

    <a href="viewEmployee" class="back-link">⬅ Back to Employee List</a>
</div>

</body>
</html>
