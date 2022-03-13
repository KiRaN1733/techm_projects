<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
</head>
<body>
	<div align="center">
		<h1>Employee Management</h1>
		<h2>
			<a href="new">Add New Employee</a> &nbsp;&nbsp;&nbsp; <a href="list">List
				All Employees</a>
		</h2>
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Employees</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Salary</th>
				<th>Designation</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="employee" items="${listEmployee}">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.age}" /></td>
					<td><c:out value="${employee.salary}" /></td>					
					<td><c:out value="${employee.designation}" /></td>
					<td><a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${employee.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>