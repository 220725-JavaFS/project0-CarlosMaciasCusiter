package com.revature.services;

import com.revature.models.Player;
import com.revature.repositories.AuctionHouse;

public class AuctionService {

	private AuctionHouse auctionHouse = new AuctionHouse();
	
	public void sendToAuction(Player player) {
		auctionHouse.sellPlayerToAuction(player);
	}
	
	public void buyAtAuction(Player player) {
		auctionHouse.buyFromAuction(player);
	}
	
	
}
