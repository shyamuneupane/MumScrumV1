package com.mumscrumv1.service;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserStory;

public interface SprintService {
	
	public List<Sprint> getAllSprint();
	public void addSprint(Sprint sprint);
	public void deleteSprint(int id);
	public Sprint getSprintById(int id);
	public void updateSprint(Sprint updatedSprint, int id);
	public List<String> getAllSprintsName();
	public int getSprintDay( int id);
	
	public List<UserStory> getListOfUserStory(int id);
//	
//	public int getDeveloperDailyWorkLogForSprint(  int id);
//	
//	public int getOrigionalTesterEffortForSprint( int id);
//	
//	public int getTesterDailyWorkLogForSprint(int id);
}
