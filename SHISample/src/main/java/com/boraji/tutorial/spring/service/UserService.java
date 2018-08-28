package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.entity.User;

public interface UserService {

	public void add(User user);
  public  List<User> listUsers();
    public User getById(int id);
}
