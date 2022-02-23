package com.sportyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {

	
}
