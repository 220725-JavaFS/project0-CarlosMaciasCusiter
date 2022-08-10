package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User getUserById(int id) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users where users.user_id = " + id + ";";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				User user = new User(result.getInt("user_id"), result.getString("user_name"),
						result.getString("user_password"), result.getInt("user_bankValue"),
						result.getInt("user_points"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users;";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List<User> userList = new LinkedList<User>();
			while (result.next()) {
				User user = new User(result.getInt("user_id"), result.getString("user_name"),
						result.getString("user_password"), result.getInt("user_bankValue"),
						result.getInt("user_points"));
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertUser(User user) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO users (user_name, user_password, user_bankValue, user_points)"
					+ " VALUES (?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			int count = 0;
			statement.setString(++count, user.getUsername());
			statement.setString(++count, user.getPassword());
			statement.setInt(++count, user.getBankValue());
			statement.setInt(++count, user.getPoints());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public int countUser() {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "select count(*) from users;";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			result.next();
			int x = result.getInt("count");
			return x;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
//		User user = userDAO.getUserById(1);
//		System.out.println(user);	
//		List<User> userList = userDAO.getAllUsers();
//		for (User user : userList) {
//			System.out.println(user);
//		}
//		User user = new User();
//		user.setUsername("Jeff Wittek");
//		user.setPassword("password");
//		user.setBankValue(100000000);
//		user.setPoints(5);
//		userDAO.insertUser(user);
//		System.out.println(userDAO.countUser());;
		System.out.println(userDAO.getUserByUsername("DemoDisk"));
	}

	@Override
	public User getUserByUsername(String username) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM users where users.user_name = '" + username + "';";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				User user = new User(result.getInt("user_id"), result.getString("user_name"),
						result.getString("user_password"), result.getInt("user_bankValue"),
						result.getInt("user_points"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}