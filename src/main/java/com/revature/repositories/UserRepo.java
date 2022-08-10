package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class UserRepo {
	
	private static List<User> userRepo = new ArrayList<> ();
	
	public void newUser(User user) {
		// construct the user in the controller class, 
		// and then clean data and save here.
		userRepo.add(user);
	}
	
	public User getUserByUsername(String username) {
		for(User user : userRepo) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}
	
}
