package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.models.Player;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class PlayerDAOImpl implements PlayerDAO {

	@Override
	public Player getPlayerById(int id) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM players where players.player_id = " + id + ";";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if (result.next()) {
				Player player = new Player(result.getInt("player_id"), result.getString("player_firstName"),
						result.getString("player_lastName"), result.getString("player_position"),
						result.getInt("player_salary"), result.getBoolean("player_isBuyable"),
						result.getBoolean("player_isInjured"), null, result.getString("player_team"));
				int userID_fKey = result.getInt("FK_userID");
				if (userID_fKey != 0) {
					UserDAO userDao = new UserDAOImpl();
					User user = userDao.getUserById(userID_fKey);
					player.setUser(user);
				}
				return player;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertPlayer(Player player) {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO players " + "(player_firstName, player_lastName, player_position, "
					+ "player_salary, player_isBuyable, player_isInjured, FK_userID, player_team)"
					+ " Values (?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			int count = 0;
			statement.setString(++count, player.getFirstName());
			statement.setString(++count, player.getLastName());
			statement.setString(++count, player.getPosition());
			statement.setInt(++count, player.getSalary());
			statement.setBoolean(++count, player.isBuyable());
			statement.setBoolean(++count, player.isInjured());

			if (player.getUser() != null) {
				statement.setInt(++count, player.getUser().getUserID());
			} else {
				statement.setInt(++count, 1);
			}
			statement.setString(++count, player.getTeam());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePlayer(Player player) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "UPDATE players SET " + "player_firstName = '" + player.getFirstName() + "', "
					+ "player_lastName = '" + player.getLastName() + "', " + "player_position = '" + player.getPosition()
					+ "', " + "player_salary = '" + player.getSalary() + "', " + "player_isBuyable = '" + player.isBuyable()
					+ "', " + "player_isInjured = '" + player.isInjured() + "', " + "FK_userID = '"
					+ player.getUser().getUserID() + "', " + "player_team = '" + player.getTeam() + "' WHERE player_id = "
					+ player.getPlayerID() + ";";
			System.out.println(sql);
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Player> getAllPlayers() {
		try (Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM players LEFT JOIN users on users.user_id = players.FK_userID;";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List<Player> playerList = new LinkedList<Player>();
			while(result.next()) {
				Player player = new Player(
							result.getInt("player_id"),
							result.getString("player_firstName"),
							result.getString("player_lastName"),
							result.getString("player_position"),
							result.getInt("player_salary"),
							result.getBoolean("player_isBuyable"),
							result.getBoolean("player_isInjured"),
							null,
							result.getString("player_team")
						);
				int userID = result.getInt("FK_userID");
				if(userID!=0) {
					User user = new User();
					user.setUsername(result.getString("user_name"));
					user.setPassword(result.getString("user_password"));
					user.setBankValue(result.getInt("user_bankvalue"));
					user.setPoints(result.getInt("user_points"));
					player.setUser(user);
				}
				playerList.add(player);
			}
			return playerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Player> getPlayersByUserTeam(User user) {
		try (Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM players where players.FK_userID = " + user.getUserID() + ";";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List<Player> playerList = new LinkedList<Player>();
			while(result.next()) {
				Player player = new Player();
				player.setPlayerID(result.getInt("player_id"));
				player.setFirstName(result.getString("player_firstName"));
				player.setLastName(result.getString("player_lastName"));
				player.setPosition(result.getString("player_position"));
				player.setSalary(result.getInt("player_id"));
				player.setBuyable(result.getBoolean("player_isBuyable"));
				player.setInjured(result.getBoolean("player_isInjured"));
				player.setTeam(result.getString("player_team"));
				playerList.add(player);
			}
			return playerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		PlayerDAO playerDAO = new PlayerDAOImpl();
//		User user = userDAO.getUserById(2);
//		System.out.println(playerDAO.getAvailablePlayers());
		Player player = playerDAO.getPlayerById(2);
		System.out.println(player);
//		player.setFirstName("Stephen");
//		player.setLastName("Curry");
//		playerDAO.updatePlayer(player);
		
//		player.setFirstName("Lebron");
//		player.setLastName("James");
//		player.setPosition("Forward");
//		player.setSalary(40000000);
//		player.setBuyable(false);
//		player.setInjured(true);
//		player.setUser(user);
//		PlayerDAO playerDAO = new PlayerDAOImpl();
//		playerDAO.insertPlayer(player);
	}

	@Override
	public List<Player> getAvailablePlayers() {
		// TODO Auto-generated method stub
		try (Connection connection = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM players where players.player_isbuyable = true;";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List<Player> playerList = new LinkedList<Player>();
			while(result.next()) {
				Player player = new Player();
				player.setPlayerID(result.getInt("player_id"));
				player.setFirstName(result.getString("player_firstName"));
				player.setLastName(result.getString("player_lastName"));
				player.setPosition(result.getString("player_position"));
				player.setSalary(result.getInt("player_id"));
				player.setBuyable(result.getBoolean("player_isBuyable"));
				player.setInjured(result.getBoolean("player_isInjured"));
				player.setTeam(result.getString("player_team"));
				playerList.add(player);
			}
			return playerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
