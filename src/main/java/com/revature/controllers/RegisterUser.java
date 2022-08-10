package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;

public class RegisterUser {
	
	private Scanner scanner = new Scanner(System.in);
	private UserService userService = new UserService();
	
	public void register() {
		
		System.out.println("============User Registration Service============");
		
		System.out.println("username: ");
		String user_username = scanner.nextLine();
		System.out.println("password: ");
		String user_password = scanner.nextLine();
		
		User user = new User(user_username, user_password);
		userService.newUser(user);
		
		System.out.println((user.toString()));
	}
}
