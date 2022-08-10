package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Player;

public class AuctionHouse {
	
	private static List<Player> playersAtAuction = new ArrayList<> ();
	
	public List<Player> getPlayersAtAuction() {
		return playersAtAuction;
	}
	
	public void sellPlayerToAuction(Player player) {
		playersAtAuction.add(player);
	}
	
	public void buyFromAuction(Player player) {
		playersAtAuction.remove(player);
	}
	
	public void printOutAuctionHouse( ) {
		for (Player player : playersAtAuction) {
			System.out.println(player.toString());
			System.out.println(player.toStringStats());
		}
	}
	
}
