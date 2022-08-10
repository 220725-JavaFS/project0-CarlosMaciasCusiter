package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Player;
import com.revature.models.User;
import com.revature.repositories.UserRepo;

public class UserService {
	private UserDAO userDAO = new UserDAOImpl();

	public User registerUser(String username, String password) {
		User user = userDAO.getUserByUsername(username);
		if (user != null) {
			System.out.println("That username is already taken");
			return null;
		} else {
			User new_user = new User();
			new_user.setUsername(username);
			new_user.setPassword(password);
			new_user.setBankValue(150000000);
			new_user.setPoints(0);
			new_user.setUserRole("player");
			userDAO.insertUser(new_user);
			return new_user;
		}
	}

	public User loginUser(String username, String password) {
		User user = userDAO.getUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			System.out.println("you did not enter valid credentials");
			return null;
		}
	}

}
