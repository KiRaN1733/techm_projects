<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "employeeProject";
String userid = "root";
String password = "adminkiran";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="home">
<h1>Employee Details</h1>
<table border="1">
<tr>
<td> ID </td>
<td> Name </td>
<td> Age </td>
<td> Salary </td>
<td> Designation </td>

</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from employees";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getInt("ID") %></td>
<td><%=resultSet.getString("Name") %></td>
<td><%=resultSet.getInt("Age") %></td>
<td><%=resultSet.getInt("Salary") %></td>
<td><%=resultSet.getString("Designation") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<br/><a href="index.html"> HOME</a>
</div>
</body>
</html>