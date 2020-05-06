package com.test.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.springbootproject.dto.UserRequest;
import com.test.springbootproject.exception.NotFoundException;
import com.test.springbootproject.model.User;
import com.test.springbootproject.service.UserService;

@RestController
public class UserContoller {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public ResponseEntity<String> helloWorld(){
		return ResponseEntity.ok("Hello World");
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		
		try {
			User user = userService.getUserById(id);
			return ResponseEntity.ok(user);
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<User> getUserByIdParam(@RequestParam int id){
		return getUserById(id);
	}
	
	@GetMapping("/user/name")
	public ResponseEntity<List<User>> getUserByName(@RequestParam String name){
		return ResponseEntity.ok(userService.getUsersByName(name));
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest userRequest) {
		User user = userService.saveUser(userRequest.toUser());
		return ResponseEntity.ok(UserRequest.fromUser(user));
		
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<UserRequest> updateUser(@RequestBody UserRequest userRequest, @PathVariable int id){
		
		User user = userRequest.toUser();
		user.setId(id);
		userService.updateUser(user);
		
		return ResponseEntity.ok(UserRequest.fromUser(user));
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		
		try {
			userService.deleteUser(id);
			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	
	
}
