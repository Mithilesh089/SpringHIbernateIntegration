package com.testCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boraji.tutorial.spring.dao.UserDao;
import com.boraji.tutorial.spring.entity.User;
import com.boraji.tutorial.spring.service.UserServiceImp;

public class UserServiceImplementation {

	@Mock
	UserDao userdao;
	
	@InjectMocks
	UserServiceImp userSercice;
	

	   @Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	}
	

@Test
public void userServiceImplementtest() {
		
User user1=new User();
user1.setId(1);
user1.setEmail("lgupta065@gmail.com");
user1.setFirstName("Lokendra");
user1.setLastName("Gupta");
User user2=new User();
user2.setId(2);
user2.setEmail("lgupta065@gmail.com");
user2.setFirstName("Lokendra");
user2.setLastName("Gupta");

List<User> user=new ArrayList<User>();
user.add(user1);
user.add(user2);

when(userdao.listUsers()).thenReturn(user);
assertEquals("Lokendra",userdao.listUsers().get(0).getFirstName());

	}

}
