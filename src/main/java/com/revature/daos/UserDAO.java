package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {

	public abstract User getUserById(int id);
	
	public abstract User getUserByUsername(String username);
	
	public abstract List<User> getAllUsers();
	
	public abstract void insertUser(User user);
	
	public abstract int countUser();
	
	public abstract void updateUser(User user);
	
}
