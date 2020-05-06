package com.test.springbootproject.repository;

import java.util.List;

import com.test.springbootproject.model.User;

public interface UserRepositoryCustom {

	
	public abstract List<User> findUsersByAge(int age);
}
