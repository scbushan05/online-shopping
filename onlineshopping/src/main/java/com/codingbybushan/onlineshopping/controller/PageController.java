package com.codingbybushan.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codingbybushan.shoppingbackend.dao.CategoryDAO;
import com.codingbybushan.shoppingbackend.dto.Category;

@Controller
public class PageController {
		
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*methods to load category based on id*/
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		//passing the category list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategory(@PathVariable int id){
		ModelAndView mv = new ModelAndView("page");
		//fetching the single category
		Category category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		//passing the single category
		mv.addObject("category", category);
		//passing the category list
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
}
