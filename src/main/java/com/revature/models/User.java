package com.revature.models;

import java.util.Objects;

public class User {

	private int userID;
	private String username;
	private String password;
	private int bankValue;
	private int points;
	private String userRole;

	public User() {
		super();
	}

	public User(int userID, String username, String password, int bankValue, int points) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.bankValue = bankValue;
		this.points = points;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public int getBankValue() {
		return bankValue;
	}

	public void setBankValue(int bankValue) {
		this.bankValue = bankValue;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bankValue, password, points, userID, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Double.doubleToLongBits(bankValue) == Double.doubleToLongBits(other.bankValue)
				&& Objects.equals(password, other.password) && points == other.points && userID == other.userID
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", bankValue="
				+ bankValue + ", points=" + points + "]";
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}