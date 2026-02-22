<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link rel="stylesheet" href="css/addEmployee.css">
</head>
<body>

<div class="container">
    <h2>Add Employee</h2>

    <form action="addEmployee" method="post">
        <input type="text" name="empId" placeholder="Employee ID" required>
        <input type="text" name="empName" placeholder="Employee Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="text" name="mobile" placeholder="Mobile Number" required>
        <input type="text" name="department" placeholder="Department" required>
        <input type="number" name="salary" placeholder="Salary" required>

        <input type="submit" value="Add Employee">
    </form>

    <a href="dashboard.jsp">⬅ Back to Dashboard</a>
</div>

</body>
</html>
