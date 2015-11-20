package com.mumscrumv1.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.ReleaseBacklog;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.model.WorkLog;
import com.mumscrumv1.service.EmployeeService;
import com.mumscrumv1.service.UserStoryService;
import com.mumscrumv1.service.WorkLogService;

@Controller
public class TesterController {

	@Autowired
	UserStoryService userStoryService;
	
	@Autowired
	WorkLogService workLogService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "userStory.estimate/{currentUserId}", method = RequestMethod.GET)
	public String addEstimation(@ModelAttribute("AllUserStories") UserStory AllUserStories,
			@PathVariable("currentUserId") int id, Model model) {

		List<UserStory> UserStoryInfo = userStoryService.getAllUserStoryTester(id);
		model.addAttribute("UserStoriesInfo", UserStoryInfo);
		return "TesterEstimation";
	}

	@RequestMapping(value = "userStory.estimate/estimationUpdate", method = RequestMethod.POST)
	public String addEstimation(@ModelAttribute("AllUserStories") UserStory userStory) {

		userStoryService.updateTestEstimation(userStory);
		return "redirect:/Role.dashboard?CurrentRole=Tester";
	}

	@RequestMapping(value = "userStory.updateWrok/{currentUserId}", method = RequestMethod.GET)
	public String updateWorkLog(@ModelAttribute("workLog") WorkLog workLog, @PathVariable("currentUserId") int id,
			Model model) {
		List<UserStory> UserStoryInfo = userStoryService.getAllUserStoryTester(id);
		model.addAttribute("UserStoriesInfo", UserStoryInfo);
		return "TesterWorkLogUpdate";
	}

	@RequestMapping(value = "userStory.updateWrok/workUpdate", method = RequestMethod.POST)
	public String updateWorkLog(@ModelAttribute("workLog") WorkLog workLog) {
		int uid=workLog.getUserStory().getId();
		UserStory userStory=userStoryService.getUserStoryById(uid);
		workLog.setUserStory(userStory);
		userStory.getWorkLogforUserStory().add(workLog);
		workLogService.addTestWorkLog(workLog);
		return "redirect:/Role.dashboard?CurrentRole=Tester";
	}

}
