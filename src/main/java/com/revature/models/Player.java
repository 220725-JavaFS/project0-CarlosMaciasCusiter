package com.revature.models;

import java.util.Objects;

public class Player {

	private int playerID;
	private String	firstName;
	private String lastName;
	private String position;
	private int salary;
	private boolean isBuyable;
	private boolean isInjured;
	private User user;
	private String team;
	
	public Player() {
		super();
	}

	public Player(int playerID, String firstName, String lastName, String position, int salary, boolean isBuyable,
			boolean isInjured, User user) {
		super();
		this.playerID = playerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.salary = salary;
		this.isBuyable = isBuyable;
		this.isInjured = isInjured;
		this.user = user;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isBuyable() {
		return isBuyable;
	}

	public void setBuyable(boolean isBuyable) {
		this.isBuyable = isBuyable;
	}

	public boolean isInjured() {
		return isInjured;
	}

	public void setInjured(boolean isInjured) {
		this.isInjured = isInjured;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, isBuyable, isInjured, lastName, playerID, position, salary, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(firstName, other.firstName) && isBuyable == other.isBuyable
				&& isInjured == other.isInjured && Objects.equals(lastName, other.lastName)
				&& playerID == other.playerID && Objects.equals(position, other.position) && salary == other.salary
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Player [playerID=" + playerID + ", firstName=" + firstName + ", lastName=" + lastName + ", position="
				+ position + ", salary=" + salary + ", isBuyable=" + isBuyable + ", isInjured=" + isInjured + ", user="
				+ user + "]";
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	

}
