package com.test.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springbootproject.exception.NotFoundException;
import com.test.springbootproject.model.User;
import com.test.springbootproject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(int id) throws NotFoundException {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new NotFoundException("The user with id "+id+" is not exist");
		
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean deleteUser(int id) throws NotFoundException {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		throw new NotFoundException("The user with id "+id+" is not exist");
		
	}

	@Override
	public List<User> getUsersByName(String name) {
		return userRepository.findByName(name);
	}

}
