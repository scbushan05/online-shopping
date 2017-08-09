package com.codingbybushan.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codingbybushan.shoppingbackend.dao.CategoryDAO;
import com.codingbybushan.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.codingbybushan.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("MP3 Players");
		category.setDescription("This is MP3 players category");
		category.setImageURL("cat_05.png");
		assertEquals("successfully added", true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category = categoryDAO.get(1);
		assertEquals("successfully fetched a single category form the table", "Mobile", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(1);
		category.setName("Television");
		assertEquals("Successfully updated the single category", true, categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(1);
		assertEquals("Successfully deleted the single category", true, categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory(){
		assertEquals("Successfully fetched all category",3, categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory(){
		//adding category
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is Mobile category");
		category.setImageURL("cat_01.png");
		assertEquals("successfully added", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is television category");
		category.setImageURL("cat_02.png");
		assertEquals("successfully added", true, categoryDAO.add(category));
		
		//fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		assertEquals("Successfully updated the single category", true, categoryDAO.update(category));
		
		//deleting the category
		assertEquals("Successfully deleted the single category", true, categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Successfully fetched all category",1, categoryDAO.list().size());
	}
}
