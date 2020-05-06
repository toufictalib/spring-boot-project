package com.test.springbootproject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.test.springbootproject.model.User;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsersByAge(int age) {
		Query sqlQuery = entityManager.createNativeQuery("select * from user where age = ?", User.class);
		sqlQuery.setParameter(1, age);
		
		return sqlQuery.getResultList();
		
		
	}

}
