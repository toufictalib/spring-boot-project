package com.test.springbootproject.service;

import java.util.List;

import com.test.springbootproject.exception.NotFoundException;
import com.test.springbootproject.model.User;

public interface UserService {

	public abstract User getUserById(int id) throws NotFoundException;
	
	public abstract User saveUser(User user);
	
	public abstract User updateUser(User user);
	
	public abstract boolean deleteUser(int id) throws NotFoundException;
	
	public abstract List<User> getUsersByName(String name);
	
}
