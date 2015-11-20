package com.mumscrumv1.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.repository.EmployeeRepository;
import com.mumscrumv1.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService {

	@Autowired
	EmployeeRepository EmployRepository;

	public void addEmployee(Employee employee) {
		EmployRepository.save(employee);
	}


	public List<Employee> getAllEmployees() {
		List<Employee> employeelist = (List<Employee>) EmployRepository.findAll();
		return employeelist;
	}
	public Employee getEmployeeInformationByUserName(String username) {
		return EmployRepository.getEmployeeInformationByUsername(username);
			
	}
	public List<Employee> getAllEmployeeInformation() {
		return EmployRepository.getAllEmployeeInformation();
			
	}

	public void deleteEmployeeByID(int id) {
		// TODO Auto-generated method stub
		EmployRepository.delete(id);
	}

	public Employee getAllEmployeeInformationByID(int EmployeeID) {
		return EmployRepository.getAllEmployeeInformationByID(EmployeeID);
	}

	public void updateEmployee(Employee updatedEmployee, int id) {
		 EmployRepository.updateEmployee(updatedEmployee.getFirstName(),updatedEmployee.getMiddleName(),updatedEmployee.getLastName(),id);
			
	}


	public List<Employee> getEmployeeInformationByUserRole(String role) {
		//return EmployRepository.getEmployeeInformationByUserRole(role);
		return  EmployRepository.getAllEmployeeInformation();
		
	}

}
