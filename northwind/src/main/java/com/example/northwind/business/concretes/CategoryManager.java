package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICategoryService;
import com.example.northwind.dataaccess.concretes.CategoryRepository;
import com.example.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Map<String, Boolean> getById(Integer categoryId) {
		categoryRepository.findById(categoryId);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("id ile alındı!", Boolean.TRUE);
		
		return response;
	}
	
	@Override
	public Map <String, Boolean> add(Category category) {
		categoryRepository.save(category);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Eklendi!", Boolean.TRUE);
		
		return response;
		
	}

	@Override
	public Map<String, Boolean> update(Integer categoryId, Category category) throws Exception{
		Category categoryToUpdate =  categoryRepository.findById(categoryId).orElseThrow(() -> new Exception ("No category with id : " + categoryId));
		
		categoryToUpdate.setCategoryName(category.getCategoryName());
		categoryToUpdate.setDescription(category.getDescription());
		
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Güncellendi!", Boolean.TRUE);
		
		return response;
	}

	@Override
	public Map<String, Boolean> delete(Integer categoryId) throws Exception {
		Category categoryToDelete = categoryRepository.findById(categoryId).orElseThrow(() -> new Exception("No category with id : " + categoryId));
		
		categoryRepository.delete(categoryToDelete);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Silindi!", Boolean.TRUE);
		
		return response;
	}

	

	
	
}
