package com.codingbybushan.shoppingbackend.dao;

import java.util.List;

import com.codingbybushan.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();

	Category get(int id);
}
