package com.mag.magasin.service;

import com.mag.magasin.entities.User;
import com.mag.magasin.entities.UserRole;

public interface AccountService {
	public User saveUser(String username, String password, String confirmedPassword);
	public UserRole save(UserRole role);
	public User loadUserByUsername(String username);
	public void addRoleToUser(String username, String roleName);
}
