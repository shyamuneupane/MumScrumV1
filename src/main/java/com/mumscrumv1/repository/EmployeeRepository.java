package com.mumscrumv1.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mumscrumv1.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	@Query("SELECT u FROM Employee u WHERE u.userCredential.username = :un")
	Employee getEmployeeInformationByUsername(@Param("un")   String username);

//	@Query("SELECT u FROM Employee u WHERE u.userCredential.employeeRole.role = :role")
//	List<Employee> getEmployeeInformationByUserRole(@Param("role")   String role);
//	
	@Query("SELECT u FROM Employee u")
	List<Employee> getAllEmployeeInformation();

	@Query("SELECT u FROM Employee u where u.EmployeeID=:id")
	Employee getAllEmployeeInformationByID(@Param("id") int id);

	 @Modifying
	 @Transactional
	@Query("DELETE Employee u WHERE u.EmployeeID = :id")
	void deleteEmployeeByID(@Param("id") int id);
//	 @Query("update Employee u set u.firstName = :employee.firstName,u.middleName = :employee.middleName,u.lastName = :employee.lastName where u.EmployeeID=")
//	void updateEmployee(@Param("employee")Employee updatedEmployee);

	 @Modifying
	 @Transactional
	 @Query("update Employee u set u.firstName = :firstName,u.middleName = :middleName,u.lastName = :lastName where u.EmployeeID = :id")
	 void updateEmployee(@Param("firstName")String firstName, @Param("middleName")String middleName,@Param("lastName") String lastName,@Param("id") int id);

}

