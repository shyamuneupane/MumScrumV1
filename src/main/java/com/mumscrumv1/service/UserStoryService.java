package com.mumscrumv1.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mumscrumv1.model.UserStory;

public interface UserStoryService {

	public List<UserStory> getAllUserStory();
	public UserStory getUserStoryById(int id);
	public void addUserStory(UserStory userStory);
	public void deleteUserStory(int id);
	public void updateUserStory(UserStory updatedUserStory, int id);
	public List<String> getAllUserStroryNames();
	public List<UserStory> getAllUserStoryTester(int id);
	public List<UserStory> getAllUserStoryDev(int id);
	public void updateTestEstimation(UserStory userStory);
	public void updateDevEstimation(UserStory userStory);

}
