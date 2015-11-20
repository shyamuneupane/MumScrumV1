package com.mumscrumv1.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.repository.SprintRepository;
import com.mumscrumv1.repository.UserStroyRepository;
import com.mumscrumv1.service.UserStoryService;

@Service
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	UserStroyRepository userStoryRepository;
	
	@Autowired
	SprintRepository sprintRepository;
	public List<UserStory> getAllUserStory() {
		// TODO Auto-generated method stub
		return (List<UserStory>) userStoryRepository.getAllUserStrory();
	}
	
	public void addUserStory(UserStory userStory) {
		userStoryRepository.save(userStory) ;
	}
	
	public void deleteUserStory(int id){
		userStoryRepository.delete(id);
	}

	public UserStory getUserStoryById(int id) {
		// TODO Auto-generated method stub
		return userStoryRepository.getUserStroryByID(id);
	}

	public void updateUserStory(UserStory updatedUserStory, int id) {
		// TODO Auto-generated method stub
		//userStoryRepository.updateEmployee(updatedUserStory.getStoryName(),id);
//		Sprint removedSprintConnection;
//		List<Sprint> allSprints=sprintRepository.getAllSprints();
//		for(Sprint sprint : allSprints){
//			List<UserStory> UserStoryInSprint=sprint.getUserStories();
//			for(UserStory us:UserStoryInSprint){
//				if(us.getId()==updatedUserStory.getId()){
//					removedSprintConnection=sprint;
//				
//					
//				}
//			}
//		}
		
		userStoryRepository.save(updatedUserStory);
	
			
	}

	public List<String> getAllUserStroryNames() {
		// TODO Auto-generated method stub
		return userStoryRepository.getAllUserStroryNames();
	}
	
	public List<UserStory> getAllUserStoryTester(int id) {
		// TODO Auto-generated method stub
		return userStoryRepository.getAllUserStoryTester(id);
	}

	public List<UserStory> getAllUserStoryDev(int id) {
		// TODO Auto-generated method stub
		return userStoryRepository.getAllUserStoryDev(id);
	}

	public void updateDevEstimation(UserStory userStory) {
		
		userStoryRepository.updateDevEstimation(userStory.getId(), userStory.getDevEstimateHour()) ;
		
	}

	public void updateTestEstimation(UserStory userStory) {
		
		userStoryRepository.updateTestEstimation(userStory.getId(), userStory.getTesterEstimateHour()) ;
	}


	
}
