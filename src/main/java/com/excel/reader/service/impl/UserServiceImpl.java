package com.excel.reader.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.reader.entities.User;
import com.excel.reader.repositories.UserRepository;
import com.excel.reader.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public void addUsers(List<User> users) {
		userRepo.saveAll(users);
	}

}
