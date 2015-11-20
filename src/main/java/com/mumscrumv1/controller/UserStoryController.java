package com.mumscrumv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.repository.UserStroyRepository;
import com.mumscrumv1.service.EmployeeService;
import com.mumscrumv1.service.SprintService;
import com.mumscrumv1.service.UserStoryService;



@Controller
public class UserStoryController {
	
	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
	SprintService SprintService;
	

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "create.userStory", method = RequestMethod.GET)
	public String createUserStory(UserStory userStory, Model model){		
		model.addAttribute("userStory", userStory);
		return "CreateNewUserStory";
	}
	
	
	@RequestMapping(value = "save.userStory", method = RequestMethod.POST)
	public String saveUserStory( @ModelAttribute("userStory") UserStory userStory, Model model){
		
		userStoryService.addUserStory(userStory);
		List<UserStory> UserStoryInfo=userStoryService.getAllUserStory();
		model.addAttribute("UserStoriesInfo",UserStoryInfo);
		return "ViewUserStories";

	}
	@RequestMapping(value="update.userStory", method=RequestMethod.GET)
	public String UpdateUserStory(@RequestParam("id") int id, Model model){
		UserStory userStory= userStoryService.getUserStoryById(id);
		model.addAttribute("userStory",userStory);
		return "UpdateUserStory";
	}
	@RequestMapping(value="updateConfirm.userStory", method=RequestMethod.POST)
	public String UpdateConfirmUserStory(@RequestParam("id") int id,UserStory updatedUserStory,Model model){
		//update code should be here
		userStoryService.updateUserStory(updatedUserStory,id);
		List<UserStory> UserStoryInfo=userStoryService.getAllUserStory();
		model.addAttribute("UserStoriesInfo",UserStoryInfo);
		return "ViewUserStories";
	}
	
	@RequestMapping(value="view.userstory", method=RequestMethod.GET)
	public String ViewEmplyoee(Model model){
		List<UserStory> UserStoryInfo=userStoryService.getAllUserStory();
		model.addAttribute("UserStoriesInfo",UserStoryInfo);
		return "ViewUserStories";
	}
	@RequestMapping(value="delete.userStory", method=RequestMethod.GET)
	public String DeleteExistingUserStory(@RequestParam("id") int id,Model model){		
		userStoryService.deleteUserStory(id);
		List<UserStory> UserStoryInfo=userStoryService.getAllUserStory();
		model.addAttribute("UserStoriesInfo",UserStoryInfo);
		return "ViewUserStories";
	}
	@RequestMapping(value="addDelUserStories.sprint", method=RequestMethod.GET)
	public String AddExistingUserStoryToSprint(@RequestParam("sprintId") int sprintId,Model model){		

		List<UserStory> AllUserStory=userStoryService.getAllUserStory();
		List<UserStory> UserStoriesInSprint=SprintService.getSprintById(sprintId).getUserStories();
		List<UserStory> AllUserStoryNotInSprint=AllUserStory;
		for(int k=0; k < AllUserStory.size();k++)

		{
		for(int i=0;i<UserStoriesInSprint.size();i++)
		{
			UserStory usestory1 = (UserStory)AllUserStory.get(k);
			UserStory userstory2 = (UserStory)UserStoriesInSprint.get(i);
			if((usestory1.getId()==userstory2.getId()))
			AllUserStoryNotInSprint.remove(usestory1);
		
		}
		}
		
		model.addAttribute("sprintId",sprintId);
		model.addAttribute("UserStoriesInSprint",UserStoriesInSprint);
     	model.addAttribute("UserStoriesInfo",AllUserStoryNotInSprint);
		return "AddUserStoriesToSprint";
	}
	
	@RequestMapping(value="addUserStoryConfirm.sprint", method=RequestMethod.GET)
	public String AddExistingUserStoryToSprintConfirm(@RequestParam("sprintId") int sprint_id,@RequestParam("userStroryId") int userStory_id, Model model){	
		
		Sprint sprint=SprintService.getSprintById(sprint_id);
		UserStory userstory=userStoryService.getUserStoryById(userStory_id);
		List<UserStory> allUserStory=sprint.getUserStories();
		allUserStory.add(userstory);
		sprint.setUserStories(allUserStory);
		SprintService.updateSprint(sprint, sprint_id);
		//System.out.println(UserStoriesInfo.getId()+"is selected");
		List<Sprint> sprintInfo=SprintService.getAllSprint();
		model.addAttribute("SprintInfo",sprintInfo);
		return "ViewSprint";
	}
	
	@RequestMapping(value="addDelDevTester.UserStory", method=RequestMethod.GET)
	public String AssignDelUserStoryToUserStory(@RequestParam("UserStoryId") int UserStoryId,Model model){		

		List<Employee> EmployeeList=employeeService.getAllEmployeeInformation();
		
		Employee TesterForUserStory=userStoryService.getUserStoryById(UserStoryId).getAssignedTester();
		Employee DevForUserStory=userStoryService.getUserStoryById(UserStoryId).getAssignedDeveloper();
		
		model.addAttribute("UserStoryId",UserStoryId);
		model.addAttribute("EmployeeList", EmployeeList);
		model.addAttribute("TesterForUserStory", TesterForUserStory);
		model.addAttribute("DevForUserStory", DevForUserStory);
		
		return "AssignAndRemoveDevNTester";
		
	}
	
	@RequestMapping(value="AddDevNTesterConfirm.UserStory", method=RequestMethod.GET)
	public String AssignDevTesterConfirm(@RequestParam("employeeId") int employeeId,@RequestParam("UserStoryId") int userStroryId,@RequestParam("assignedAs") String assignedAs, Model model){	
		
		UserStory userstory=userStoryService.getUserStoryById(userStroryId);
		Employee employee=employeeService.getAllEmployeeInformationByID(employeeId);
		if(assignedAs.equals("Developer")){
		userstory.setAssignedDeveloper(employee);
		}
		else{
		userstory.setAssignedTester(employee);
		}
			
		userStoryService.updateUserStory(userstory, userStroryId);
		List<UserStory> UserStoryInfo=userStoryService.getAllUserStory();
		model.addAttribute("UserStoriesInfo",UserStoryInfo);
		return "ViewUserStories";
	}

	
}
