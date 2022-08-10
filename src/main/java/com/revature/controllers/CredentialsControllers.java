package com.revature.controllers;

import java.util.Scanner;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;

public class CredentialsControllers {

	private Scanner scanner = new Scanner(System.in);
	private UserService userService = new UserService();

	public User CredentialsMenu(String choice) {
		System.out.println("Please enter your username:");
		String username = scanner.nextLine();
		System.out.println("Pleases enter your password:");
		String password = scanner.nextLine();
		if (choice.equals("2")) {
			User user = userService.registerUser(username, password);
			return user;
		} else if (choice.equals("1")) {
			User user = userService.loginUser(username, password);
			return user;
		}
		return null;
	}

}