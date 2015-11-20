package com.mumscrumv1.repository;

import com.mumscrumv1.model.ReleaseBacklog;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReleaseRepository extends CrudRepository<ReleaseBacklog, Integer> {
//	@Query("SELECT u FROM ReleaseD u WHERE u.userCredential.username = :un")
//	ReleaseD getEmployeeInformationByUsername(@Param("un")   String username);
//
	@Query("SELECT r FROM ReleaseBacklog r")
	List<ReleaseBacklog> getAllRelase();
	
	

//	@Query("SELECT u FROM ReleaseD u where u.id=:id")
//	ReleaseD getAllEmployeeInformationByID(@Param("id") int id);
//
//	 @Modifying
//	 @Transactional
//	@Query("DELETE Relase u WHERE u.id = :id")
//	void deleteReleaseByID(@Param("id") int id);
////	 @Query("update Employee u set u.firstName = :employee.firstName,u.middleName = :employee.middleName,u.lastName = :employee.lastName where u.EmployeeID=")
////	void updateEmployee(@Param("employee")Employee updatedEmployee);
//
//	 @Modifying
//	 @Transactional
//	 @Query("update ReleaseD u set u.firstName = :firstName,u.middleName = :middleName,u.lastName = :lastName where u.EmployeeID = :id")
//	 void updateRelase(@Param("firstName")String firstName, @Param("middleName")String middleName,@Param("lastName") String lastName,@Param("id") int id);

    @Modifying
    @Transactional
    @Query("update ReleaseBacklog u set u.ReleaseName = :ReleaseName,u.Status = :Status,u.EstimatedReleseDate = :EstimatedReleseDate,u.ActualReleaseDate = :ActualReleaseDate where u.id = :id")
    void updateRelease(@Param("ReleaseName") String ReleaseName, @Param("Status") String Status, @Param("EstimatedReleseDate") String EstimatedReleseDate, @Param("ActualReleaseDate") String ActualReleaseDate, @Param("id") int id);

}
