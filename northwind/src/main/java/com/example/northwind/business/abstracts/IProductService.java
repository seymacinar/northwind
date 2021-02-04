package com.example.northwind.business.abstracts;

import java.util.Map;

import com.example.northwind.entities.concretes.Product;

public interface IProductService {

	Map<String, Boolean> getById (Integer productId);
	Map<String, Boolean> add(Product product) throws Exception;
	Map<String, Boolean> update (Integer productId, Product product) throws Exception;
	Map<String, Boolean> delete (Integer productId) throws Exception;
	
}
