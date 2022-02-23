package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.model.Product;
import com.sportyshoes.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	//post
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts()
	{
		return service.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping("/productByName/{name}")
	public List<Product> findByName(@PathVariable String name)
	{
		return (List<Product>) service.getProductByName(name);
	}
	
	@GetMapping("/productByBrand/{brand}")
	public List<Product> findAllByBrand(@PathVariable String brand)
	{
		return (List<Product>) service.getProductByBrand(brand);
	}
	
	@GetMapping("/productByCategory/{category}")
	public List<Product> findAllByCategory(@PathVariable String category)
	{
		return (List<Product>) service.getProductByCategory(category);
	}
	
	@GetMapping("/productByPrice/{price}")
	public List<Product> findAllByPrice(@PathVariable double price)
	{
		return (List<Product>) service.getProductByPrice(price);
	}
	
	@GetMapping("/productByColor/{color}")
	public List<Product> findAllByColor(@PathVariable String color)
	{
		return (List<Product>) service.getProductByColor(color);
	}
	
	@GetMapping("/productByDate")
	public List<Product> findAllByOrderByCreatedDateDesc()
	{
		return (List<Product>) service.getProductByCreatedDate();
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
	
	@DeleteMapping("/delete")
	public String deleteProducts()
	{
		return service.deleteProducts();
	}
}
