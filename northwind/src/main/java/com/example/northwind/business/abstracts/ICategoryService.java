package com.example.northwind.business.abstracts;

import java.util.Map;

import com.example.northwind.entities.concretes.Category;

public interface ICategoryService {

	Map<String, Boolean> getById (Integer categoryId);
	Map<String, Boolean> add(Category category);
	Map<String, Boolean> update (Integer categoryId, Category category) throws Exception;
	Map<String, Boolean> delete (Integer categoryId) throws Exception;
	
}
