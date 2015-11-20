package com.mumscrumv1.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Role;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.service.EmployeeService;
import com.mumscrumv1.service.LoginService;
import com.mumscrumv1.service.UserStoryService;


@SessionAttributes("currentUserId")
@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserStoryService userStoryService;

	@RequestMapping(value="mumscrum.dashboard", method=RequestMethod.POST)
	public String login(HttpServletRequest request,@RequestParam("username")String username,@RequestParam("password")String password,Model model){
		if(loginService.validateUser(username, password))
		{
		 List<Role> allRoles=loginService.getUserRole(username);
		  model.addAttribute("roleInfo",allRoles);		 
		  Employee employee=employeeService.getEmployeeInformationByUserName(username);
		  model.addAttribute("currentUserId", employee.getEmployeeID());
		  model.addAttribute("EmployeeInfo", employee);			
		 return "dashboard";
		}
		else
		 return "ErrorPage";	
	}
	@RequestMapping(value="Role.dashboard", method=RequestMethod.GET)
	public String logintoHR(@RequestParam("CurrentRole") String CurrentRole,  Model model){  //@RequestParam("role")String role
		if(CurrentRole.equals("HR")){
		List<Employee> allEmployeeInfo=employeeService.getAllEmployeeInformation();
		model.addAttribute("AllEmployeeInfo", allEmployeeInfo);		
		return "ViewEmployee";
		}
		
		else if(CurrentRole.equals("ScrumMaster")){
			List<UserStory> UserStoryInfo=userStoryService.getAllUserStory();
			model.addAttribute("UserStoriesInfo",UserStoryInfo);
			return "ViewUserStories";
		}	
		else if(CurrentRole.equals("Tester")){
			
			return "TesterDashboard";
		}
		else if(CurrentRole.equals("Developer")){
			
			return "DevDashboard";
		}
		else{
			return "errorPage";
			
		}

		//userStory.devEstimate/devEstimationUpdate

	}

			
}
