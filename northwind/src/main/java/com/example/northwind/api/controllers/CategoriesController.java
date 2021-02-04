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

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.entities.concretes.Category;

@RestController
@RequestMapping("/api/v1")
public class CategoriesController {
	
	@Autowired
	ICategoryService categoryService;
	
	@GetMapping("/categories")
	public Map <String, Boolean> getById(@PathVariable (value = "category_id") Integer categoryId){
		return categoryService.getById(categoryId);
	}
 	
	@PostMapping("/categories")
	public Map <String, Boolean> add(@RequestBody Category category) {
		return categoryService.add(category);
	}
	
	@PutMapping("/categories/{category_id}")
	public Map <String, Boolean> update(@PathVariable (value = "category_id") Integer categoryId, @RequestBody Category category) throws Exception{
		return categoryService.update(categoryId, category);
	}
	
	@DeleteMapping("categories/{category_id}")
	public Map<String, Boolean> delete(@PathVariable (value = "category_id") Integer categoryId) throws Exception {
		return categoryService.delete(categoryId);
	}
}
