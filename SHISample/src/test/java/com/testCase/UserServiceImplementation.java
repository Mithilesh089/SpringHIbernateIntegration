package com.testCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.boraji.tutorial.spring.dao.UserDao;
import com.boraji.tutorial.spring.entity.User;
import com.boraji.tutorial.spring.service.UserServiceImp;

public class UserServiceImplementation {

@Mock
UserDao userdao;
	
@InjectMocks
UserServiceImp userSercice;

@Test
public void userServiceImplementtest() {
		
User user1=new User("Lokendra","Gupta","CISCO");
User user2=new User("Loks","Gup","HP");
List<User> user=new ArrayList<User>();
user.add(user1);
user.add(user2);

when(userdao.listUsers()).thenReturn(user);
assertEquals("Lokendra",userdao.listUsers().get(0).getFirstName());

	}

}
