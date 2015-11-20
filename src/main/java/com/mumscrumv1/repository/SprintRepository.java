package com.mumscrumv1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Sprint;
import com.mumscrumv1.model.UserCredential;
import com.mumscrumv1.model.UserStory;
import com.mumscrumv1.model.WorkLog;

@Repository
public interface SprintRepository extends CrudRepository<Sprint, Integer>{

	@Query("SELECT s FROM Sprint s")
	List<Sprint> getAllSprints();
	
	@Query("SELECT s.SprintName FROM Sprint s")
	List<String> getAllSprintsName();
	
	@Query("SELECT s FROM Sprint s WHERE s.id = :id")
	Sprint getSprintByID(@Param("id")   int id);
	
	@Query("SELECT s.NoOfWorkDayInSprint FROM Sprint s WHERE s.id = :id")
	int getSprintDay(@Param("id")   int id);
	
	@Query("SELECT s.UserStories FROM Sprint s WHERE s.id = :id")
	List<UserStory> getListOfUserStory(@Param("id")   int id);
	
//	@Query("SELECT sum(DevEffort) FROM Worklog as w inner join Sprint as s on w.id = s.id where s.id = :id order by w.WorkDay desc ")	
//	int[] getDeveloperDailyWorkLogForSprint();
	
//	@Query("SELECT sum(s.UserStories.TesterEstimateHour) FROM Sprint s WHERE s.id = :id")
//	int getOrigionalTesterEffortForSprint(@Param("id")   int id);
//	
//	@Query("SELECT sum(w.TestingEffort) FROM Worklog w inner join Sprint s on w.id = s.id where s.id = :id order by w.WorkDay desc")
//	int getTesterDailyWorkLogForSprint(@Param("id")   int id);
}
