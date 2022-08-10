package com.revature.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.PlayerDAO;
import com.revature.daos.PlayerDAOImpl;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.Player;
import com.revature.models.User;
import com.revature.services.PlayerService;

public class FantasyMenuController {

	private CredentialsControllers cc = new CredentialsControllers();
	private Scanner scanner = new Scanner(System.in);
	private User user = new User();
	private PlayerService playerService = new PlayerService();
	private PlayerDAO playerDAO = new PlayerDAOImpl();
	private List<Player> playerList = new LinkedList<Player>();

	public void FantasyMenu() {
		String choice = "";
		menuLoop: while (!choice.equals("0")) {
			System.out.println("Enter 0 at any time to quit fantasy");
			System.out.println("Would you like to login or register?\n1.Login\n2.Register");
			choice = scanner.nextLine();
			if (choice.equals("1") | choice.equals("2")) {
				user = cc.CredentialsMenu(choice);
				if (user == null) {
					System.out.println("Please enter valid credentials and try again");
					FantasyMenu();
				}
				if (user.getUserRole().equals("admin")) {
					ModeratorMenu(user);
				}

			}
			UserMenu(user);

		}
		System.out.println(user);

	}

	private void ModeratorMenu(User user2) {

		System.out.println("Welcome to the moderator Menu");
		String choice_1 = "";
		while (choice_1 != "q") {
			System.out.println("1.) Create new player ");
			System.out.println("2.) Give points to a player");
			System.out.println("q.) Exit the application ");
			choice_1 = scanner.nextLine();
			switch (choice_1) {
			case "1":
				Player new_player = new Player();
				String input = "";
				System.out.println("Enter your new player's first name");
				input = scanner.nextLine();
				new_player.setFirstName(input);
				System.out.println("Enter you new player's last name");
				input = scanner.nextLine();
				new_player.setLastName(input);
				System.out.println("What position does he play");
				input = scanner.nextLine();
				new_player.setPosition(input);
				System.out.println("What Salary is he expectin");
				input = scanner.nextLine();
				new_player.setSalary(Integer.valueOf(input));
				System.out.println("What team do they play for");
				input = scanner.nextLine();
				new_player.setTeam(input);
				new_player.setUser(null);
				playerDAO.insertPlayer(new_player);
				break;
//			case "2":
//				System.out.println("Which player would you like to assign points to");
//				playerList = playerDAO.getAllPlayers();
//				for (Player player : playerList) {
//					System.out.println(player);
//				}
//				String choice_3 = "";
//				while (!choice_3.equals("q")) {
//					System.out.println("enter q to exit the point assignment");
//					choice_3 = scanner.nextLine();
//					Player updatedPlayer = playerDAO.getPlayerById(Integer.valueOf(choice_3));
//					System.out.println("How many points did " + updatedPlayer.getFirstName() + " earn?");
//					updatedPlayer.getUser().setPoints(updatedPlayer.getUser().getPoints() += updatedPlayer.);
//				}
			case "q":
				FantasyMenu();
			default:
				ModeratorMenu(user2);
			}

		}

	}

	public void UserMenu(User user) {
		System.out.println("Welcome to the your home page");
		String choice = "";
		String choice_1 = "";
		while (choice != "q") {
			System.out.println("1.) Get your user information");
			System.out.println("2.) Get your team information");
			System.out.println("3.) Get all of the available players");
			System.out.println("4.) Buy an available player");
			System.out.println("5.) Sell one of your players");
			System.out.println("q.) Exit the application");
			choice = scanner.nextLine();
			switch (choice) {
			case "1":
				System.out.println(user);
				UserMenu(user);
				break;
			case "2":
				System.out.println("This is your team");
				playerList = playerService.getPlayersByUserTeam(user);
				for (Player player : playerList) {
					System.out.println(player);
				}
				UserMenu(user);
				break;
			case "3":
				System.out.println("These are the players that are available: ");
				playerList = playerService.getAvailablePlayers();
				for (Player player : playerList) {
					System.out.println(player);
				}
				UserMenu(user);
				break;
			case "4":
				playerList = playerService.getAvailablePlayers();
				for (Player player : playerList) {
					System.out.println(player);
				}
				System.out.println("Enter the ID of the player that you want to add to your team");
				choice_1 = "";
				while (!choice_1.equals("0")) {
					System.out.println("Enter 0 to break from the buy player screen.");
					choice_1 = scanner.nextLine();
					int player_ID = Integer.valueOf(choice_1);
					playerService.BuyAvailablePlayer(player_ID, user.getUserID());
				}
				UserMenu(user);
				break;
			case "5":
				choice_1 = "";
				playerList = playerService.getPlayersByUserTeam(user);
				for (Player player : playerList) {
					System.out.println(player);
				}
				while (!choice_1.equals("0")) {
					System.out.println("Enter 0 to break from the sell player screen.");
					choice_1 = scanner.nextLine();
					int player_ID = Integer.valueOf(choice_1);
					playerService.sellYourPlayer(player_ID, user.getUserID());
					choice_1 = "";
				}
				UserMenu(user);
				break;
			case "q":
				FantasyMenu();
			default:
				System.out.println("Please enter a valid command");
			}
			choice = scanner.nextLine();
		}

	}
}
