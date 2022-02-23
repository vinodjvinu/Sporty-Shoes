package com.sportyshoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.model.Product;

public interface ProductOrderRepository extends CrudRepository<Product, Integer>  {

}
