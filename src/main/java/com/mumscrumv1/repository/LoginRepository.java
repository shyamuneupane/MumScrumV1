package com.mumscrumv1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.UserCredential;

@Repository
public interface LoginRepository extends CrudRepository<UserCredential, Integer>{

	@Query("SELECT u FROM UserCredential u WHERE u.username = :un")
	UserCredential getCredentialByUsername(@Param("un") String username);
	
}
