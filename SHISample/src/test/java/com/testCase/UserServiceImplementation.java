package com.testCase;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;

import com.boraji.tutorial.spring.dao.UserDao;

import com.boraji.tutorial.spring.entity.User;
import com.boraji.tutorial.spring.service.UserService;
import com.boraji.tutorial.spring.service.UserServiceImp;

@SuppressWarnings("deprecation")
public class UserServiceImplementation {

	@Mock
	UserDao userdao;

	@InjectMocks
	UserServiceImp userSerciceImp;

	@Autowired
	UserService userService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void userServiceImplementtest() {

		User user1 = new User();
		user1.setId(1);
		user1.setEmail("lgupta065@gmail.com");
		user1.setFirstName("Lokendra");
		user1.setLastName("Gupta");
		User user2 = new User();
		user2.setId(2);
		user2.setEmail("lgupta065@gmail.com");
		user2.setFirstName("Lokendra");
		user2.setLastName("Gupta");

		List<User> user = new ArrayList<User>();
		user.add(user1);
		user.add(user2);

		Mockito.when(userdao.listUsers()).thenReturn(user);
		System.out.println(userdao);
		assertEquals("Lokendra", userSerciceImp.listUsers().get(0).getFirstName());

	}

	@SuppressWarnings("deprecation")
	@Test
	public void saveTest() {

		User user1 = new User();
		user1.setId(1);
		user1.setEmail("lgupta065@gmail.com");
		user1.setFirstName("Lokendra");
		user1.setLastName("Gupta");
		// assertEquals(1,userdao.add(user1));
		doNothing().when(userdao).add(Matchers.any(User.class));
		userSerciceImp.add(user1);
		verify(userdao, times(1)).add(user1);

	}
	
	@Test
	public void getUserbyIdTest()
	{
		
		int id=3;
		User user=new User();
		user.setId(3);
		user.setEmail("lgupta065@gmail.com");
		user.setFirstName("Lokendra");
		user.setLastName("Gupta");
		when(userdao.getById(Matchers.any(Integer.class))).thenReturn(user);
		System.out.println(user);
		assertEquals(3,	userSerciceImp.getById(id).getId());
	}

}
