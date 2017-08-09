package com.codingbybushan.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.codingbybushan.shoppingbackend.dao.ProductDAO;
import com.codingbybushan.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.codingbybushan.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	/*@Test
	public void textCRUDProduct(){
		product = new Product();
		
		product.setName("oppo selfie S53");
		product.setBrand("Opop");
		product.setDescription("this is some description for oppo mobile phone");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("something went wrong while inserting product", true, productDAO.add(product));
		
		product = productDAO.get(2);
		product.setName("Samsung galaxy S7");
		assertEquals("something went wrong while updating existing record", true, productDAO.update(product));
		
		assertEquals("something went wrong while deleting existing record", true, productDAO.delete(product));
		
		assertEquals("something went wrong while fetching list of record", 6, productDAO.list().size());
	
	}*/
	
	/*@Test
	public void testListOfActiveProducts(){
		assertEquals("something went wrong while fetching list of active products", 5, productDAO.listActiveProducts().size());
	
	}*/
	
	/*@Test
	public void testListOfActiveProductsByCategoryId(){
		assertEquals("something went wrong while fetching list of active products by category id", 3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("something went wrong while fetching list of active products by category id", 2, productDAO.listActiveProductsByCategory(1).size());
	
	}*/
	
	@Test
	public void testGetLatestActiveProducts(){
		assertEquals("something went wrong while fetching list of latest active products", 4, productDAO.getLatestActiveProducts(4).size());
	
	
	}
}
