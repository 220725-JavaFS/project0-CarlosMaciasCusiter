package com.revature;

import com.revature.controllers.FantasyMenuController;
import com.revature.controllers.RegisterUser;
import com.revature.models.Player;
import com.revature.repositories.AuctionHouse;

public class Driver {

	public static void main(String[] args) {
		
		// Entry Point of your project
		System.out.println("=================Welcome to the NBA fantasy app=================");
		FantasyMenuController fmc = new FantasyMenuController();
		fmc.FantasyMenu();
		
	}

}
