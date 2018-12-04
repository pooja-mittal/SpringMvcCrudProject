package com.practice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.practice.pojo.Employee;

public class EmployeeDao {

	String connection_url = "jdbc:mysql://localhost:3306/spring_mvc?useSSL=false";

	public int saveNewEmployee(Employee emp) {
		Connection connection = null;
		emp = new Employee();
		PreparedStatement prepareStatement = null;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connection_url, "root", "root");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select max(id) from employee");
			int maxId = 0;
			while (rs.next()) {
				maxId = rs.getInt(1);
				System.out.println("id for this new employee is "+ maxId);
				maxId++;
			}
			prepareStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			prepareStatement.setInt(1, maxId);
			prepareStatement.setString(2, emp.getName());
			prepareStatement.setString(3, emp.getEmail());
			prepareStatement.setString(4, emp.getAddress());
			count=prepareStatement.executeUpdate();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
		

	}

}
