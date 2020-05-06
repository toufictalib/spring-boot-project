package com.test.springbootproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.springbootproject.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByName(String name);
	
	List<User> findByNameIgnoreCase(String name);
	
	List<User> findByAge(int age);
	
	List<User> findByAgeLessThan(int age);
	
	@Query("select u from User u where age > ?1")
	List<User> findByAgeGreaterThanCustomQuery(int age);
	
	@Query(value = "select * from User u where age > ?1", nativeQuery = true)
	List<User> findByAgeGreaterThanCustomQueryNative(int age);
	
	@Query("select u from User u where age > :age")
	List<User> findByAgeGreaterThanCustomQueryNamedParam(@Param("age") int age);
	
}
