package com.example.northwind.business.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataaccess.concretes.ProductRepository;
import com.example.northwind.entities.concretes.Product;

@Service
public class ProductManager implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Map<String, Boolean> getById(Integer productId) {
		
		productRepository.findById(productId);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("id ile alındı!", Boolean.TRUE);
		
		return response;
	}
	
	@Override
	public Map <String, Boolean> add(Product product) throws Exception {		
		
		int sizeOfProductName = product.getProductName().length();
		int categoryId = product.getCategoryId();
		int lengthOfCategory = productRepository.lengthOfCategory(categoryId);
		
		
		if(sizeOfProductName < 2) {
			throw new Exception ("Hata : Ürünün ismi en az 2 harften oluşmalıdır!");
		}
		
		else if(lengthOfCategory > 10) {
			throw new Exception ("Hata : Bir kategoride en fazla 10 ürün olabilir!");
		}
			
		else {
			productRepository.save(product);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("Eklendi!", Boolean.TRUE);
			
			return response;
		}
	}

	@Override
	public Map<String, Boolean> update(Integer productId, Product product) throws Exception{
		
		Product productToUpdate =  productRepository.findById(productId).orElseThrow(() -> new Exception ("No product with id : " + productId));
		
		productToUpdate.setProductName(product.getProductName());
		productToUpdate.setQuantityPerUnit(product.getQuantityPerUnit());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Güncellendi!", Boolean.TRUE);
		
		return response;
	}

	@Override
	public Map<String, Boolean> delete(Integer productId) throws Exception {
		
		Product productToDelete = productRepository.findById(productId).orElseThrow(() -> new Exception("No product with id : " + productId));
		
		productRepository.delete(productToDelete);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Silindi!", Boolean.TRUE);
		
		return response;
	}

	

	
	
	

}
