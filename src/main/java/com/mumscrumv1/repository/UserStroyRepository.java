package com.mumscrumv1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mumscrumv1.model.UserCredential;
import com.mumscrumv1.model.UserStory;

@Repository
public interface UserStroyRepository extends CrudRepository<UserStory, Integer>{

	@Query("SELECT u FROM UserStory u")
	List<UserStory> getAllUserStrory();
	
	@Query("SELECT u FROM UserStory u WHERE u.id = :id")
	UserStory getUserStroryByID(@Param("id")   int id);
	/*@Query("Update UserStory u set u.storyName=:updatedStoryName where u.id=:id")*/
	

	@Query("SELECT u.StoryName FROM UserStory u ")
	List<String> getAllUserStroryNames();
	
	
	@Query("SELECT u FROM UserStory u WHERE u.AssignedTester.EmployeeID=:id")
	List<UserStory> getAllUserStoryTester(@Param("id") int id);
	
	@Query("SELECT u FROM UserStory u WHERE u.AssignedDeveloper.EmployeeID=:id")
	List<UserStory> getAllUserStoryDev(@Param("id") int id);
	
//	
//	@Query("SELECT * FROM UserStory u WHERE u.Assinged_Developer=:id")
//	List<UserStory> getAllUserStoryByDevID(@Param("id") int id);
//	
	
	@Transactional
	@Modifying
	@Query("UPDATE UserStory u set u.TesterEstimateHour=:TesterEstimateHour WHERE u.id=:id")
	void updateTestEstimation( @Param("id") int id,@Param("TesterEstimateHour") int TesterEstimateHour);
	
	@Transactional
	@Modifying
	@Query("UPDATE UserStory u set u.DevEstimateHour=:devEstimateHour WHERE u.id=:id")
	void updateDevEstimation( @Param("id") int id,@Param("devEstimateHour") int devEstimateHour);

	
//	@Query("SELECT * FROM UserStory u WHERE u.id=:id")
//	UserStory getUserStoryById(@Param("id") int id);
	
//	@Query("SELECT * FROM UserStory u WHERE u.Assinged_Tester=:id")
//	List<UserStory> getAllUserStoryByTesterID(@Param("id") int id);
//	
//	@Query("SELECT * FROM UserStory u WHERE u.Assinged_Developer=:id")
//	List<UserStory> getAllUserStoryByDevID(@Param("id") int id);
//	
//	@Query("UPDATE UserStory u set u.Tester_Estimate_Hour=:TesterEstimateHour WHERE u.id=:id")
//	void updateTestEstimation(@Param("TesterEstimateHour")int TesterEstimateHour, @Param("id") int id );
//	
//	@Query("UPDATE UserStory u set u.Dev_Estimate_Hour=:TesterEstimateHour WHERE u.id=:id")
//	void updateDevEstimation(@Param("DevEstimateHour")int TesterEstimateHour, @Param("id") int id );
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE UserStory u set u.StoryName=:US.GETNAME() WHERE u.id=:id")
//	void updateEmployee(@Param("storyname") USERSTORY US,@Param("id") int id);
//	

	 
	 
//	@Query("SELECT u FROM userstory u WHERE u.AssignedTester_EmployeeID = :id")
//	UserCredential getUserStroryforDeveloper(@Param("id")   String DeveloperID);
//	
//	
//	@Query("SELECT u FROM userstory u WHERE u.AssignedDeveloper_EmployeeID = :id")
//	UserCredential getUserStroryforTester(@Param("id")   String TesterID);
//	
//	@Query("SELECT u.Dev_Estimate_Hour+Tester_Estimate_Hour FROM userstory u WHERE u.id = :id")
//	UserCredential getTotalEstimateForUserStory(@Param("id")   String storyId);
//	
//	@Query("SELECT u.Dev_Remaining_Hour+Tester_Remaining_Hour FROM userstory u WHERE u.id = :id")
//	UserCredential getTotalRemainingHourForUserStory(@Param("id")   String storyId);
}

