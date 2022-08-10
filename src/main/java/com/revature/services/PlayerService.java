package com.revature.services;

import java.util.List;

import com.revature.daos.PlayerDAO;
import com.revature.daos.PlayerDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Player;
import com.revature.models.User;

public class PlayerService {

	private PlayerDAO playerDAO = new PlayerDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	
	public List<Player> getPlayersByUserTeam(User user){
		return playerDAO.getPlayersByUserTeam(user);
	}
	
	public List<Player> getAvailablePlayers() {
		return playerDAO.getAvailablePlayers();
	}

	public void BuyAvailablePlayer(int player_ID, int userID) {
		if (player_ID == 0) {
			System.out.println("Please enter a valid ID");
			return;
		}
		User user = userDAO.getUserById(userID);
		Player player = playerDAO.getPlayerById(player_ID);
		if (player.getSalary() <= user.getBankValue() & player.isBuyable()) {
			player.setUser(user);
			player.setBuyable(false);
			playerDAO.updatePlayer(player);
			user.setBankValue(user.getBankValue()-player.getSalary());
			userDAO.updateUser(user);
		} else {
			System.out.println("you do not have enough money or the player isn't available now");
		}
	}

	public void sellYourPlayer(int player_ID, int userID) {
		User user = userDAO.getUserById(userID);
		if (player_ID == 0) {
			System.out.println("Please enter a valid ID");
			
		}
		Player player = playerDAO.getPlayerById(player_ID);
		if (player.isBuyable()==false & player.getUser().getUserID() == userID) {
			player.setBuyable(true);
			player.setUser(null);
			playerDAO.updatePlayer(player);
			user.setBankValue(user.getBankValue() + player.getSalary());
			userDAO.updateUser(user);
		} else {
			System.out.println("You do not own that player");
		}
	}
}
