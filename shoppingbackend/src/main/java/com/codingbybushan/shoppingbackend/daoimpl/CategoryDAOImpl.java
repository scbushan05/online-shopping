package com.codingbybushan.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codingbybushan.shoppingbackend.dao.CategoryDAO;
import com.codingbybushan.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	//getting single category based on id
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try{
			//add the category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try{
			//this is for update the single category
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try{
			//this is for delete the single category
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
