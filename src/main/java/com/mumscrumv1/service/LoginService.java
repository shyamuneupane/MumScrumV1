package com.mumscrumv1.service;

import java.util.List;


import com.mumscrumv1.model.Role;

public interface LoginService {

	public abstract boolean validateUser(String username,String password);
	public abstract List<Role> getUserRole(String username);
	
}
