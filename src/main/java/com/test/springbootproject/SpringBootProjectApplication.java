package com.test.springbootproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.springbootproject.configuration.MailProperties;
import com.test.springbootproject.model.User;
import com.test.springbootproject.repository.UserRepository;
import com.test.springbootproject.repository.UserRepositoryCustom;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(UserRepository userRepository, UserRepositoryCustom userRepositoryCustom,MailProperties mailProperties) {
		return args -> {

			//create user 1
			User user1 = new User("user 1", 21);

			userRepository.save(user1);
			
			//create user 2
			User user2 = new User("user 2", 25);
			userRepository.save(user2);
			
			//find all users has age greater than
			userRepository.findByAgeGreaterThanCustomQuery(20).forEach(e->{
				System.out.println(e);
			});
			
			//find all users has age greater than native query
			System.out.println("Native Query");
			userRepository.findByAgeGreaterThanCustomQueryNative(22).forEach(e->{
				System.out.println(e);
			});
			
			
			//find all users has age greater than With param name
			System.out.println("Param Name");
			userRepository.findByAgeGreaterThanCustomQueryNamedParam(22).forEach(e->{
				System.out.println(e);
			});
			
			
			//find all users with precise age using custom repository
			
			System.out.println("Custom Repository");
			userRepositoryCustom.findUsersByAge(21).forEach(e->{
				System.out.println(e);
			});
			
			
			//Mail Properties
			System.out.println("Mail Properties");
			System.out.println(mailProperties.toString());
		};
	}
}
