package com.example.northwind.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/products")
	public Map <String, Boolean> getById(@PathVariable (value = "product_id") Integer productId){
		return productService.getById(productId);
	}
 	
	@PostMapping("/products")
	public Map <String, Boolean> add(@RequestBody Product product) throws Exception{
		return productService.add(product);
	}
	
	@PutMapping("/products/{product_id}")
	public Map <String, Boolean> update(@PathVariable (value = "product_id") Integer productId, @RequestBody Product product) throws Exception{
		return productService.update(productId, product);
	}
	
	@DeleteMapping("products/{product_id}")
	public Map<String, Boolean> delete(@PathVariable (value = "product_id") Integer productId) throws Exception {
		return productService.delete(productId);
	}
	
	
}
