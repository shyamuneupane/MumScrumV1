package com.mumscrumv1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Role;
import com.mumscrumv1.service.EmployeeService;
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "create.employee", method = RequestMethod.GET)
	public String createEmployee( Employee newEmployee, Model model){		
		model.addAttribute("employee", newEmployee);
		return "CreateNewEmployee";
	}

	@RequestMapping(value = "save.employee", method = RequestMethod.POST)
	public String employeForm( @ModelAttribute Employee employee, 
			 Model model, @RequestParam("userRole") String[] roles){
		
	
		
		List<Role> myRole = new ArrayList<Role>();
        
            for(String str : roles){
                if(str.equalsIgnoreCase("Developer")){
                    //Developer dev = new Developer();
                    Role dev = new Role();
                    dev.setRole("Developer");
                    dev.setRoleDescription("Developer is responsible for creating application functionalities");
                    myRole.add(dev);
                }
                else if(str.equalsIgnoreCase("Tester")){
                    Role dev = new Role();
                    dev.setRole("Tester");
                    dev.setRoleDescription("Test is responsible To Test Complete Application");
                    
                    myRole.add(dev);
                }
                else if(str.equalsIgnoreCase("ScrumMaster")){
                    Role dev = new Role();
                    dev.setRole("ScrumMaster");
                    dev.setRoleDescription("Scrum Master is responsible for creating and updating userstories and sprint");
                    myRole.add(dev);
                }
                else if(str.equalsIgnoreCase("ProductOwner")){
                    Role dev = new Role();
                    dev.setRole("ProductOwner");
                    dev.setRoleDescription("Product owner is responsible for creating and updating backlog and assigning role to Scrum Master");
                    
                    myRole.add(dev);
                }
            }
            
            System.out.println("I am here babay");
            System.out.println(employee.getUserCredential().getID());
            System.out.println(employee.getUserCredential().getPassword());
            System.out.println(employee.getUserCredential().getUsername());
            
            employee.getUserCredential().setEmployeeRole(myRole);
		
		employeeService.addEmployee(employee);
		List<Employee> allEmployeeInfo=employeeService.getAllEmployeeInformation();
		model.addAttribute("AllEmployeeInfo", allEmployeeInfo);	
		return "ViewEmployee";

	}

	
//	@RequestMapping(value = "save.employee", method = RequestMethod.POST)
//	public String saveEmployee( @ModelAttribute Employee employee, Model model){
//		employeeService.addEmployee(employee);
//		List<Employee> allEmployeeInfo=employeeService.getAllEmployeeInformation();
//		model.addAttribute("AllEmployeeInfo", allEmployeeInfo);	
//		return "ViewEmployee";
//
//	}
	@RequestMapping(value="update.employee", method=RequestMethod.GET)
	public String UpdateEmplyoee(@RequestParam("id") int id,Model model){
		//employeeService.addEmployee(updatedEmployee);
		Employee employee=employeeService.getAllEmployeeInformationByID(id);
		model.addAttribute("EmployeeInfo",employee);
		return "UpdateEmployee";
	}
	@RequestMapping(value="updateConfirm.employee", method=RequestMethod.POST)
	public String UpdateConfirmEmplyoee(@RequestParam("id") int id,Employee updatedEmployee,Model model){
		//update code should be here
		employeeService.updateEmployee(updatedEmployee,id);
		List<Employee> allEmployeeInfo=employeeService.getAllEmployeeInformation();
		model.addAttribute("AllEmployeeInfo", allEmployeeInfo);	
		return "ViewEmployee";
	}
	
	@RequestMapping(value="view.employee", method=RequestMethod.GET)
	public String ViewEmplyoee(Model model){
		List<Employee> allEmployeeInfo=employeeService.getAllEmployeeInformation();
		model.addAttribute("AllEmployeeInfo", allEmployeeInfo);
		return "ViewEmployee";
	}
	@RequestMapping(value="delete.employee", method=RequestMethod.GET)
	public String DeleteExistingEmplyoee(@RequestParam("id") int id,Model model){		
		employeeService.deleteEmployeeByID(id);
		List<Employee> allEmployeeInfo=employeeService.getAllEmployeeInformation();
		model.addAttribute("AllEmployeeInfo", allEmployeeInfo);		
		return "ViewEmployee";
	}

}
