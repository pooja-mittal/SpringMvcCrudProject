package com.practice.SpringMvcCrudProject;

import com.practice.dao.EmployeeDao;
import com.practice.pojo.Employee;

public class EmployeeService {
	
	EmployeeDao empDao=new EmployeeDao();
	public int createEmployee(String name, String email, String address) {
		Employee emp=new Employee(name,email, address);
		return empDao.saveNewEmployee(emp);
	}

}
