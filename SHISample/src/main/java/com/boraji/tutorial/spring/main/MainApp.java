package com.boraji.tutorial.spring.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.boraji.tutorial.spring.config.AppConfig;
import com.boraji.tutorial.spring.entity.User;
import com.boraji.tutorial.spring.service.UserService;

public class MainApp {
		   public static void main(String[] args) {
			   int id;
		      AnnotationConfigApplicationContext context = 
		            new AnnotationConfigApplicationContext(AppConfig.class);

		      UserService userService = context.getBean(UserService.class);

		      // Add Users
		      userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
		      userService.add(new User("David", "Miller", "david.miller@example.com"));
		      userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
		      userService.add(new User("Paul", "Smith", "paul.smith@example.com"));
		    //  System.out.println("User2");
System.out.println("User Added");
// Get Users
		      List<User> users = userService.listUsers();
		      for (User user : users) {
		         System.out.println("Id = "+user.getId());
		         System.out.println("First Name = "+user.getFirstName());
		         System.out.println("Last Name = "+user.getLastName());
		         System.out.println("Email = "+user.getEmail());
		         System.out.println();
		      }
		      System.out.print("Enter the Id of data you want to search : ");
		      Scanner scanner=new Scanner(System.in);
		      id=scanner.nextInt();
User user=userService.getById(id);
System.out.println("Search by ID: ");
System.out.println(user.getId()+"  "+user.getFirstName()+"  "+user.getLastName()+"  "+user.getEmail());
		      context.close();
		   }
		}

