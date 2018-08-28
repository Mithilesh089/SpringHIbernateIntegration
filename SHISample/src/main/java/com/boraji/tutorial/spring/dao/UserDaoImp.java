package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.entity.User;


@Repository
public class UserDaoImp implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void add(User user) {
	System.out.println("Hello");
		System.out.println(sessionFactory.getCurrentSession().save(user));
		sessionFactory.getCurrentSession().save(user);
		
	}

	public List<User> listUsers() {
		List<User> listUser=sessionFactory.getCurrentSession().createQuery("FROM User").list();
		return listUser;
	}

	@Transactional
	public User getById(int id) {
	User user=(User)sessionFactory.getCurrentSession().get(User.class,id);
		return user;
	}

}
