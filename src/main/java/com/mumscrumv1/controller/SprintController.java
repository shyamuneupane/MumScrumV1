package com.mumscrumv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.repository.SprintRepository;
import com.mumscrumv1.service.SprintService;
import com.mumscrumv1.service.UserStoryService;
@Controller
public class SprintController {

	@Autowired
	SprintService SprintService;
	
	@Autowired
	UserStoryService userStoryService;
	
	@RequestMapping(value = "create.sprint", method = RequestMethod.GET)
	public String createNewSprint(Sprint sprint, Model model){		
		model.addAttribute("userStory", sprint);
		return "CreateNewSprint";
	}
	
	
	@RequestMapping(value = "save.sprint", method = RequestMethod.POST)
	public String SaveNewSprint( @ModelAttribute("sprint") Sprint sprint, Model model){	
		SprintService.addSprint(sprint);
		List<Sprint> sprintInfo=SprintService.getAllSprint();
		model.addAttribute("SprintInfo",sprintInfo);
		return "ViewSprint";

	}
	@RequestMapping(value="update.sprint", method=RequestMethod.GET)
	public String UpdateSprint(@RequestParam("id") int id, Model model){
		Sprint sprint= SprintService.getSprintById(id);
		model.addAttribute("sprint",sprint);
		return "UpdateSprint";
	}
	@RequestMapping(value="updateConfirm.sprint", method=RequestMethod.POST)
	public String UpdateConfirmSprint(@RequestParam("id") int id,Sprint updatedUserStory,Model model){
		//update code should be here
		SprintService.updateSprint(updatedUserStory,id);
		List<Sprint> sprintInfo=SprintService.getAllSprint();
		model.addAttribute("SprintInfo",sprintInfo);
		return "ViewSprint";
	}
	
	@RequestMapping(value="view.sprint", method=RequestMethod.GET)
	public String ViewSprints(Model model){
		List<Sprint> sprintInfo=SprintService.getAllSprint();
		model.addAttribute("SprintInfo",sprintInfo);
		return "ViewSprint";
	}
	@RequestMapping(value="delete.sprint", method=RequestMethod.GET)
	public String DeleteExistingSprint(@RequestParam("id") int id,Model model){		
		SprintService.deleteSprint(id);
		List<Sprint> sprintInfo=SprintService.getAllSprint();
		
		model.addAttribute("SprintInfo",sprintInfo);
		return "ViewSprint";
	}

	
	@RequestMapping(value="RemoveStoryConfirm.sprint", method=RequestMethod.GET)
	public String RemoveExistingUserStoryToSprint(@RequestParam("sprintId") int sprint_id,@RequestParam("userStroryId") int userStory_id, Model model){	
		
		Sprint sprint=SprintService.getSprintById(sprint_id);
		UserStory userstory=userStoryService.getUserStoryById(userStory_id);
		List<UserStory> allUserStory=sprint.getUserStories();
		for(UserStory s:allUserStory){
			if(s.getId()==userstory.getId())
				allUserStory.remove(userstory);
		}
		
		sprint.setUserStories(allUserStory);
		SprintService.updateSprint(sprint, sprint_id);
		//System.out.println(UserStoriesInfo.getId()+"is selected");
		List<Sprint> sprintInfo=SprintService.getAllSprint();
		model.addAttribute("SprintInfo",sprintInfo);
		return "ViewSprint";
	}


	
	
	
	


}
