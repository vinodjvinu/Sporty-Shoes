package com.sportyshoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
}
