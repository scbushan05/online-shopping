package com.codingbybushan.shoppingbackend.dao;

import java.util.List;

import com.codingbybushan.shoppingbackend.dto.Product;

public interface ProductDAO {
	//basic methods or crud mehtods
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
