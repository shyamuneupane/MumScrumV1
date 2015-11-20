package com.mumscrumv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mumscrumv1.model.ReleaseBacklog;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.model.WorkLog;
import com.mumscrumv1.service.UserStoryService;
import com.mumscrumv1.service.WorkLogService;

@Controller
public class DeveloperController {

	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
	WorkLogService workLogService;

	@RequestMapping(value = "userStory.devEstimate/{currentUserId}", method = RequestMethod.GET)
	public  String addDevEstimation(@ModelAttribute("AllUserStories") UserStory AllUserStories,@PathVariable("currentUserId")int id,  Model model){	
		List<UserStory> UserStoryInfo=userStoryService.getAllUserStoryDev(id);
		model.addAttribute("UserStoriesInfo",UserStoryInfo);
		return "DeveloperEstimation";
	}
	
	@RequestMapping(value="userStory.devEstimate/devEstimationUpdate",method=RequestMethod.POST)
	public String addDevEstimation(@ModelAttribute("AllUserStories") UserStory userStory){
		userStoryService.updateDevEstimation(userStory);
		return "redirect:/Role.dashboard?CurrentRole=Developer";
	}
	
	@RequestMapping(value = "userStory.updateDevWrok/{currentUserId}", method = RequestMethod.GET)
	public String updateWorkLog(@ModelAttribute("workLog") WorkLog workLog, @PathVariable("currentUserId") int id,
			Model model) {
		List<UserStory> UserStoryInfo = userStoryService.getAllUserStoryDev(id);
		model.addAttribute("UserStoriesInfo", UserStoryInfo);
		return "DevWorkLogUpdate";
	}
	
	
	@RequestMapping(value = "/workDevUpdate", method = RequestMethod.POST)
	public String updateWorkLogDev(@ModelAttribute("workLog") WorkLog workLog) {
		int uid=workLog.getUserStory().getId();
		UserStory userStory=userStoryService.getUserStoryById(uid);
		workLog.setUserStory(userStory);
		userStory.getWorkLogforUserStory().add(workLog);
		workLogService.addDevWorkLog(workLog);
		return "redirect:/Role.dashboard?CurrentRole=Developer";
	}

	
}
