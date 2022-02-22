package com.kiran.employee;
package com.kiran.employee.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 * 
 */
@WebServlet(urlPatterns = "/deleteEmployeeServlet")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = EmpDao.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Statement stmt = connection.createStatement();
			int result = stmt.executeUpdate("delete from employees where id="+id);
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.print("<h1> Employee deleted from database</h1>");
				out.print("<a href='index.html'>HOME</a>");
			} else {
				out.print("<h1>Employee ID not found</h1>");
				out.print("<a href='index.html'>HOME</a>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
