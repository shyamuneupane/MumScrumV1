package com.mumscrumv1.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.repository.EmployeeRepository;
import com.mumscrumv1.repository.SprintRepository;
import com.mumscrumv1.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {

	@Autowired
	SprintRepository sprintRepository;
	public List<Sprint> getAllSprint() {
		// TODO Auto-generated method stub
		return (List<Sprint>) sprintRepository.getAllSprints();
	}
	
	public void addSprint(Sprint sprint) {
		sprintRepository.save(sprint) ;
	}
		
	public void deleteSprint(int id){
		sprintRepository.delete(id);
	}

	public Sprint getSprintById(int id) {
		// TODO Auto-generated method stub
		return sprintRepository.getSprintByID(id);
	}

	public void updateSprint(Sprint updatedSprint, int id) {
		sprintRepository.save(updatedSprint) ;
		
	}

	public List<String> getAllSprintsName() {
		// TODO Auto-generated method stub
		return sprintRepository.getAllSprintsName();
	}

	public int getSprintDay(int id) {
		// TODO Auto-generated method stub
		return sprintRepository.getSprintDay(id);
	}

	public List<UserStory> getListOfUserStory(int id) {
		// TODO Auto-generated method stub
		return sprintRepository.getListOfUserStory(id);
	}
//
//	public int getDeveloperDailyWorkLogForSprint(int id) {
//		// TODO Auto-generated method stub
//		return sprintRepository.getDeveloperDailyWorkLogForSprint(id);
//	}
//
//	public int getOrigionalTesterEffortForSprint(int id) {
//		// TODO Auto-generated method stub
//		return sprintRepository.getOrigionalTesterEffortForSprint(id);
//	}
//
//	public int getTesterDailyWorkLogForSprint(int id) {
//		// TODO Auto-generated method stub
//		return sprintRepository.getTesterDailyWorkLogForSprint(id);
//	}
	
	
	
}
