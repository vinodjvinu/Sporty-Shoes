package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.User;
import com.sportyshoes.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//get methods
	public List<User> getUsers()
	{
		return (List<User>) repository.findAll();
	}
}
