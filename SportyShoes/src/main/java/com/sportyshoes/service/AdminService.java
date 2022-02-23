package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.*;
import com.sportyshoes.repository.*;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	//get methods
	public List<Admin> getAdmins()
	{
		return (List<Admin>) repository.findAll();
	}
		
	public Admin updateAdmin(Admin admin)
	{ 
		Admin existingAdmin = repository.findById(admin.getAdminId()).orElse(null);
		existingAdmin.setAdminId(admin.getAdminId());
		existingAdmin.setPassword(admin.getPassword());
		return repository.save(existingAdmin);
	}
	
}
