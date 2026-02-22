<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Employees</title>
    <link rel="stylesheet" href="css/viewEmployee.css">
</head>
<body>

<div class="container">
    <h2>Employee List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <%
            List<Employee> empList =
                (List<Employee>) request.getAttribute("empList");

            if (empList != null && !empList.isEmpty()) {
                for (Employee emp : empList) {
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getEmail() %></td>
            <td><%= emp.getMobile() %></td>
            <td><%= emp.getDepartment() %></td>
            <td><%= emp.getSalary() %></td>
            <!-- Edit Column -->
            <td class="action-col">
                <a href="editEmployee?id=<%= emp.getId() %>" 
                class="btn edit">
                    Edit
                </a>
            </td>

            <!-- Delete Column -->
            <td class="action-col">
                <a href="deleteEmployee?id=<%= emp.getId() %>"
                   class="btn delete"
                   onclick="return confirm('Are you sure you want to delete this employee?');">
                    Delete
                </a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">No employees found</td>
        </tr>
        <%
            }
        %>
    </table>

    <a href="dashboard.jsp">⬅ Back to Dashboard</a>
</div>

</body>
</html>