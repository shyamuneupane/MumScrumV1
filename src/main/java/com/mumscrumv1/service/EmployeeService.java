package com.mumscrumv1.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mumscrumv1.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public abstract Employee getEmployeeInformationByUserName(String username) ;
	public abstract List<Employee> getAllEmployeeInformation();
	public abstract void deleteEmployeeByID(int id);
	public abstract Employee getAllEmployeeInformationByID(int EmployeeID);	
	public void updateEmployee(Employee updatedEmployee, int id);
	public  List<Employee> getEmployeeInformationByUserRole(String role);
}
