package com.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.Product;
import com.sportyshoes.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository repository;
	
	//post methods
	public Product saveProduct(Product product)
	{
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products)
	{
		return (List<Product>) repository.saveAll(products);
	}
	
	//get methods
	public List<Product> getProducts()
	{
		return (List<Product>) repository.findAll();
	}
	
	public Product getProductById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public List<Product> getProductByName(String productName)
	{
		return (List<Product>) repository.findAllByName(productName);
	}
	
	public List<Product> getProductByBrand(String brand)
	{
		return (List<Product>) repository.findAllByBrand(brand);
	}
	
	public List<Product> getProductByColor(String color)
	{
		return (List<Product>) repository.findAllByColor(color);
	}
	
	public List<Product> getProductByCategory(String category)
	{
		return (List<Product>) repository.findAllByCategory(category);
	}
	
	public List<Product> getProductByCreatedDate()
	{
		return (List<Product>) repository.findByOrderByCreatedDateDesc();
	}
	
	public List<Product> getProductByPrice(double price)
	{
		return (List<Product>) repository.findAllByPrice(price);
	}
	
	//delete
	public String deleteProduct(int id)
	{
		repository.deleteById(id);
		return ("Product removed successfully !!" + id);
	}
	
	public String deleteProducts()
	{
		repository.deleteAll();
		return ("Products removed successfully !!");
	}
	
	public Product updateProduct(Product product)
	{ 
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setId(product.getId());
		existingProduct.setProductName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setBrand(product.getBrand());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setColor(product.getColor());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCreatedDate(product.getCreatedDate());
		return repository.save(existingProduct);
	}
}
