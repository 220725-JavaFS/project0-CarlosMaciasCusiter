package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.User;

public class FantasyMenuController {

	private CredentialsControllers cc = new CredentialsControllers();
	private Scanner scanner = new Scanner(System.in);
	private User user = new User();

	public User FantasyMenu() {
		String choice = "";
		menuLoop: while (!choice.equals("0")) {
			System.out.println("Enter 0 at any time to quit fantasy");
			System.out.println("Would you like to login or register?\n1.Login\n2.Register");
			choice = scanner.nextLine();
			if (choice.equals("1") | choice.equals("2")) {
				user = cc.CredentialsMenu(choice);
				if (user == null) {
					System.out.println("Please enter valid credentials and try again");
				} else {
					UserMenu(user);
				}
			}
		}
		System.out.println(user);
		return user;
	}
	public void UserMenu(User user) {
		
	}
}
