package com.codingbybushan.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codingbybushan.shoppingbackend.dao.CategoryDAO;
import com.codingbybushan.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();
	
	
	static{
		Category category = new Category();
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("This is moblie category");
		category.setImageURL("cat_01.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Television");
		category.setDescription("This is television category");
		category.setImageURL("cat_02.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Tablets");
		category.setDescription("This is tablets category");
		category.setImageURL("cat_03.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		return categories;
	}
	
	@Override
	public Category get(int id) {
		for(Category category : categories){
			if(category.getId() == id){
				return category;
			}
		}
		return null;
	}

}
