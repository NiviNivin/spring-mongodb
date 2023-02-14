package com.nivin.spring.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nivin.spring.mongo.model.Product;
import com.nivin.spring.mongo.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository p_repo;
	
	@PostMapping("/addProduct")//adding new product
	public String saveProduct(@RequestBody Product product ) {
		p_repo.save(product);
		return "product added with id " + product.getProductId();
	}
	
	@GetMapping("/findAllProduct")//view all product
	public List<Product> getProducts(){
		return p_repo.findAll();
	}
	
	@GetMapping("/findAllProduct/{productId}")//view a product with id
	public Optional<Product> getProduct(@PathVariable int productId){
		return p_repo.findById(productId);
	}
	
	@DeleteMapping("/deleteProduct/{productId}")// delete a product with id
	public String deleteBook(@PathVariable int productId) {
		p_repo.deleteById(productId);
		return "product with " + productId + "deleted";
	}
}
