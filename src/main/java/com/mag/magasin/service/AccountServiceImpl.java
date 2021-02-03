package com.mag.magasin.service;

import com.mag.magasin.dao.UserRepository;
import com.mag.magasin.dao.UserRoleRepository;
import com.mag.magasin.entities.User;
import com.mag.magasin.entities.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	
	public AccountServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	@Override
	public User saveUser(String username, String password, String confirmedPassword) {
		User user = userRepository.findByUsername(username);
		User appUser = new User();
		appUser.setUsername(username);
		appUser.setActived(true);
		userRepository.save(appUser);
		addRoleToUser(username, "nonAdmin");
		
		return appUser;
	}

	@Override
	public UserRole save(UserRole role) {
		return userRoleRepository.save(role);
	}

	@Override
	public User loadUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User appUser = userRepository.findByUsername(username);
		UserRole appRole = userRoleRepository.findByRoleName(roleName);
		appUser.getRoles().add(appRole);
	}

}
