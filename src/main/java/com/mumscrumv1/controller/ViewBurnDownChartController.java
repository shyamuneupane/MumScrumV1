package com.mumscrumv1.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContext;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Role;
import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.model.WorkLog;

import com.mumscrumv1.service.EmployeeService;
import com.mumscrumv1.service.LoginService;
import com.mumscrumv1.service.SprintService;
import com.mumscrumv1.service.UserStoryService;
import com.mysql.fabric.xmlrpc.base.Value;



@Controller
public class ViewBurnDownChartController {
	
	@Autowired
	SprintService sprintService;
	
	
	
	@Autowired
	UserStoryService userStoryService;
	@RequestMapping(value="view.SelectAttributeForBurnDown", method=RequestMethod.GET)
	public String viewSelectAttribute(@ModelAttribute Sprint sprint, Model model)
	{
		List<Sprint> sprintInfo=sprintService.getAllSprint();
		model.addAttribute("SprintInfo",sprintInfo);
		return "SelectAttributeForBurnDown";
		
	}

	@RequestMapping(value="view.BurnDownChart", method=RequestMethod.POST)
	public String ViewBurnDown(@RequestParam("sprintId") int sprintId,  @ModelAttribute Sprint sprint, Model model){
	
		model.addAttribute("sprint", sprint);
		
		String Days=""; int i;
		for( i=1; i<sprintService.getSprintDay(sprintId);i++)
		{
			Days=Days+"\\\"Day"+i+"\\\",";
		}
		Days=Days+"\\\"Day"+i+"\\\"";
		System.out.println(Days);
		
		int DeveloperOrigionalEstimation=0;
		int TesterOrigionalEstimation=0;
		
		
	int[] DeveloperWorkLog = new int[]{ 0,0,0,0,0};
	int[] TesterWorkLog = new int[]{ 0,0,0,0,0 };
		
		List<UserStory> UserStories=sprintService.getListOfUserStory(sprintId);
		for(UserStory us :UserStories ){
			DeveloperOrigionalEstimation=DeveloperOrigionalEstimation+us.getDevEstimateHour();
			List<WorkLog> workLog=us.getWorkLogforUserStory();
			for(WorkLog work:workLog){				
				DeveloperWorkLog[work.getWorkDay()-1]=DeveloperWorkLog[work.getWorkDay()-1]+work.getDevEffort();
				TesterWorkLog[work.getWorkDay()-1]=TesterWorkLog[work.getWorkDay()-1]+work.getTestingEffort();
				
			}
		}
		
		for(UserStory us :UserStories ){
			TesterOrigionalEstimation=TesterOrigionalEstimation+us.getTesterEstimateHour();
		}
		
		
		String devEstimation="";
		for(int ds:DeveloperWorkLog){
			devEstimation= devEstimation+String.valueOf(DeveloperOrigionalEstimation)+",";
			DeveloperOrigionalEstimation=DeveloperOrigionalEstimation-ds;
		}
		devEstimation=devEstimation.substring(0, devEstimation.length()-1);
		System.out.println(devEstimation);
		
		String TestEstimation="";
		for(int ds:TesterWorkLog){
			TestEstimation= TestEstimation+String.valueOf(TesterOrigionalEstimation)+",";
			TesterOrigionalEstimation=TesterOrigionalEstimation-ds;
		}
		TestEstimation=TestEstimation.substring(0, TestEstimation.length()-1);
		System.out.println(TestEstimation);
		
		//String dataforKendoUI=burnDownService.createJsonForBurnDown(devEstimation, TestEstimation);
		 String dataforKendoUI="{ " + 
					"            title: { " + 
					"                text: \"Developer/Tester Estimation for Sprint 1/ Use Case 1\" " + 
					"            }, " + 
					"            legend: { " + 
					"                position: \"bottom\" " + 
					"            }, " + 
					"            seriesDefaults: { " + 
					"                type: \"column\" " + 
					"            }, " + 
					"            series: [{ " + 
					"                name: \"Developer\", " + 
					"                data: ["+devEstimation+"] " + 
					"            }, { " + 
					"                name: \"Tester\", " + 
					"                data: ["+TestEstimation+"] " + 
					"            }], " + 
					"            valueAxis: { " + 
					"                line: { " + 
					"                    visible: false " + 
					"                } " + 
					"            }, " + 
					"            categoryAxis: { " + 
					"                categories: [\"Day1\",\"Day2\",\"Day3\",\"Day4\",\"Day5\"], " + 
					"                majorGridLines: { " + 
					"                    visible: false " + 
					"                } " + 
					"            }, " + 
					"            tooltip: { " + 
					"                visible: true, " + 
					"                format: \"{0}\" " + 
					"            } " + 
					"        }";
		model.addAttribute("DataforKendoChart",dataforKendoUI);		
		return "ViewBurnDown";
		
	}


			
}
