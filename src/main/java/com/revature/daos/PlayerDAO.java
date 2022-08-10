package com.revature.daos;

import java.util.List;

import com.revature.models.Player;
import com.revature.models.User;

public interface PlayerDAO {
	/*
	 * 0. Get a player by id 
	 * 1. Insert a player
	 * 2. Add a player to a user's roster
	 * 3. give points to a player
	 * 4. Injure a player
	 * 5. get all players
	 * 6. get all players by team
	 * */
	
	public abstract Player getPlayerById(int id);
	
	public abstract void insertPlayer(Player player);
	
	public abstract void updatePlayer(Player player);
	
	public abstract List<Player> getAllPlayers();
	
	public abstract List<Player> getAvailablePlayers();
	
	public abstract List<Player> getPlayersByUserTeam(User user);
	
}
