package com.mumscrumv1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mumscrumv1.model.Employee;
import com.mumscrumv1.model.Role;
import com.mumscrumv1.model.UserCredential;
import com.mumscrumv1.repository.LoginRepository;
import com.mumscrumv1.service.LoginService;

@Service
public class LoginServiceImpl implements  LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	
	public boolean validateUser(String username, String password) {
		UserCredential credintial = loginRepository.getCredentialByUsername(username);
		if(credintial!=null)
		return credintial.getPassword().equals(password);
		else
		return false;	
	}

	public List<Role> getUserRole(String username) {
		UserCredential credintial = loginRepository.getCredentialByUsername(username);
		if(credintial!=null)
		return credintial.getEmployeeRole();
		else
		return null;	
	}
	
}
