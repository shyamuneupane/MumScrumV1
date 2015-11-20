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
import com.mumscrumv1.model.ReleaseBacklog;
import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.service.ReleaseService;
import com.mumscrumv1.service.SprintService;
@Controller
public class ReleaseController {

	
        @Autowired
        private ReleaseService releaseSrevice;
        
        @Autowired
        private SprintService sprintService;

	@RequestMapping(value = "create.release", method = RequestMethod.GET)
	public String addRelease( ReleaseBacklog newRelease, Model model){		
		model.addAttribute("release", newRelease);
		return "CreateNewRelease";
	}
	

	@RequestMapping(value = "save.release", method = RequestMethod.POST)
	public String saveRelease( @ModelAttribute ReleaseBacklog release, Model model){
           
		releaseSrevice.addRelease(release);
              
		List<ReleaseBacklog> releaseList=releaseSrevice.getAllRelelases();
		model.addAttribute("releases", releaseList);	
		return "ViewRelease";

	}
	@RequestMapping(value="update.release", method=RequestMethod.GET)
	public String UpdateRelease(@RequestParam("id") int id,Model model){
		//employeeService.addEmployee(updatedEmployee);
		ReleaseBacklog release=releaseSrevice.getAllReleaseByID(id);
		model.addAttribute("release",release);
		return "UpdateRelease";
	}
	@RequestMapping(value="updateConfirm.release", method=RequestMethod.POST)
	public String UpdateConfirmRelease(@RequestParam("id") int id,ReleaseBacklog release,Model model){
		//update code should be here
		releaseSrevice.updateRelease(release, id);
		List<ReleaseBacklog> releaseList=releaseSrevice.getAllRelelases();
		model.addAttribute("releases", releaseList);	
		return "ViewRelease";
	}
	
	
	@RequestMapping(value="view.release", method=RequestMethod.GET)
	public String ViewEmplyoee(Model model){
		List<ReleaseBacklog> releaseList=releaseSrevice.getAllRelelases();
		model.addAttribute("releases", releaseList);
		return "ViewRelease";
	}
	@RequestMapping(value="delete.release", method=RequestMethod.GET)
	public String DeleteExistingRelease(@RequestParam("id") int id,Model model){		
            releaseSrevice.deleteReleaseByID(id);
            //employeeService.deleteEmployeeByID(id);
		List<ReleaseBacklog> releaseList=releaseSrevice.getAllRelelases();
		model.addAttribute("releases", releaseList);		
		return "ViewRelease";
	}
	@RequestMapping(value="AddRemoveSprinton.Release", method=RequestMethod.GET)
	public String AddRemoveSprintonRelease(@RequestParam("ReleaseID") int ReleaseID,Model model){		


		List<Sprint> SprintList=sprintService.getAllSprint();
		List<Sprint> SprintListInRelease=releaseSrevice.getAllReleaseByID(ReleaseID).getReleasedSprints();
		List<Sprint> SprintListNotInRelease=SprintList;
		for(int k=0; k < SprintList.size();k++)

		{
		for(int i=0;i<SprintListInRelease.size();i++)
		{
			Sprint sprint1 = (Sprint)SprintList.get(k);
			Sprint sprint2 = (Sprint)SprintListInRelease.get(i);
			if((sprint1.getId()==sprint2.getId()))
				SprintListNotInRelease.remove(sprint1);
		
		}
		}
		
		model.addAttribute("ReleaseId",ReleaseID);
		model.addAttribute("SprintListInRelease",SprintListInRelease);
     	model.addAttribute("SprintListNotInRelease",SprintListNotInRelease);
		
		return "AddRemoveSprintonRelease";
		
	}
	@RequestMapping(value="AddSprintConfirm.release", method=RequestMethod.GET)
	public String AddSprintConfirmRelease(@RequestParam("sprintId") int sprintId,@RequestParam("releaseId") int releaseID, Model model){	
		
		ReleaseBacklog release=releaseSrevice.getAllReleaseByID(releaseID);
		Sprint sprint=sprintService.getSprintById(sprintId);
		List<Sprint> allSprints=release.getReleasedSprints();
		allSprints.add(sprint);
		release.setReleasedSprints(allSprints);
		releaseSrevice.updateRelease(release, releaseID);
		//System.out.println(UserStoriesInfo.getId()+"is selected");
		List<ReleaseBacklog> releaseList=releaseSrevice.getAllRelelases();
		model.addAttribute("releases", releaseList);		
		return "ViewRelease";
	}
	
	@RequestMapping(value="RemoveSprintConfirm.release", method=RequestMethod.GET)
	public String RemoveSprintConfirmRelease(@RequestParam("sprintId") int sprintId,@RequestParam("releaseId") int releaseID, Model model){	
		
		ReleaseBacklog release=releaseSrevice.getAllReleaseByID(releaseID);
		Sprint sprint=sprintService.getSprintById(sprintId);
		List<Sprint> allSprints=release.getReleasedSprints();
		allSprints.remove(sprint);
		release.setReleasedSprints(allSprints);
		releaseSrevice.updateRelease(release, releaseID);
		//System.out.println(UserStoriesInfo.getId()+"is selected");
		List<ReleaseBacklog> releaseList=releaseSrevice.getAllRelelases();
		model.addAttribute("releases", releaseList);		
		return "ViewRelease";
	}

	
	
	

}
