package com.kiran.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kiran.employee.dao.EmpDao;

/**
 * Servlet implementation class CreateUserServlet
 * 
 * init params using annotation.....
 */
@WebServlet(urlPatterns = "/updateEmployeeServlet")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = EmpDao.getConnnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int salary = Integer.parseInt(request.getParameter("salary"));

		try {
			Statement stmt = connection.createStatement();
			int result = stmt.executeUpdate("update employees set salary="+ salary+ " where id="+id);
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.print("<h1> Employee Salary Updated</h1>");
			} else {
				out.print("<h1>Employee ID not found</h1>");
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
