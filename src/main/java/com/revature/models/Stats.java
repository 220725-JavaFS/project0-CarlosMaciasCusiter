package com.revature.models;

import java.util.Objects;

public class Stats {
	
	private int gamesPlayed;
	private double minPerGame;
	private double pointsPerGame;
	private double fieldGoalPercentage;
	private double threePointPercentage;
	private double reboundsPerGame;
	private double assistsPerGame;
	private double stealsPerGame;
	private double blocksPerGame;
	
	public Stats() {
		super();
	}
	
	public Stats(int gamesPlayed, double minPerGame, double pointsPerGame, double fieldGoalPercentage,
			double threePointPercentage, double reboundsPerGame, double assistsPerGame, double stealsPerGame,
			double blocksPerGame) {
		super();
		this.gamesPlayed = gamesPlayed;
		this.minPerGame = minPerGame;
		this.pointsPerGame = pointsPerGame;
		this.fieldGoalPercentage = fieldGoalPercentage;
		this.threePointPercentage = threePointPercentage;
		this.reboundsPerGame = reboundsPerGame;
		this.assistsPerGame = assistsPerGame;
		this.stealsPerGame = stealsPerGame;
		this.blocksPerGame = blocksPerGame;
	}
	
	public void setStats(int gamesPlayed, double minPerGame, double pointsPerGame, double fieldGoalPercentage,
			double threePointPercentage, double reboundsPerGame, double assistsPerGame, double stealsPerGame,
			double blocksPerGame) {
		this.gamesPlayed = gamesPlayed;
		this.minPerGame = minPerGame;
		this.pointsPerGame = pointsPerGame;
		this.fieldGoalPercentage = fieldGoalPercentage;
		this.threePointPercentage = threePointPercentage;
		this.reboundsPerGame = reboundsPerGame;
		this.assistsPerGame = assistsPerGame;
		this.stealsPerGame = stealsPerGame;
		this.blocksPerGame = blocksPerGame;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	public double getMinPerGame() {
		return minPerGame;
	}
	
	public void setMinPerGame(double minPerGame) {
		this.minPerGame = minPerGame;
	}
	
	public double getPointsPerGame() {
		return pointsPerGame;
	}
	
	public void setPointsPerGame(double pointsPerGame) {
		this.pointsPerGame = pointsPerGame;
	}
	
	public double getFieldGoalPercentage() {
		return fieldGoalPercentage;
	}
	
	public void setFieldGoalPercentage(double fieldGoalPercentage) {
		this.fieldGoalPercentage = fieldGoalPercentage;
	}
	
	public double getThreePointPercentage() {
		return threePointPercentage;
	}
	
	public void setThreePointPercentage(double threePointPercentage) {
		this.threePointPercentage = threePointPercentage;
	}
	
	public double getReboundsPerGame() {
		return reboundsPerGame;
	}
	
	public void setReboundsPerGame(double reboundsPerGame) {
		this.reboundsPerGame = reboundsPerGame;
	}
	
	public double getAssistsPerGame() {
		return assistsPerGame;
	}
	
	public void setAssistsPerGame(double assistsPerGame) {
		this.assistsPerGame = assistsPerGame;
	}
	
	public double getStealsPerGame() {
		return stealsPerGame;
	}
	
	public void setStealsPerGame(double stealsPerGame) {
		this.stealsPerGame = stealsPerGame;
	}
	
	public double getBlocksPerGame() {
		return blocksPerGame;
	}
	
	public void setBlocksPerGame(double blocksPerGame) {
		this.blocksPerGame = blocksPerGame;
	}

	public String toStringStats() {
		return "Stats [gamesPlayed=" + gamesPlayed + ", minPerGame=" + minPerGame + ", pointsPerGame=" + pointsPerGame
				+ ", fieldGoalPercentage=" + fieldGoalPercentage + ", threePointPercentage=" + threePointPercentage
				+ ", reboundsPerGame=" + reboundsPerGame + ", assistsPerGame=" + assistsPerGame + ", stealsPerGame="
				+ stealsPerGame + ", blocksPerGame=" + blocksPerGame + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(assistsPerGame, blocksPerGame, fieldGoalPercentage, gamesPlayed, minPerGame, pointsPerGame,
				reboundsPerGame, stealsPerGame, threePointPercentage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stats other = (Stats) obj;
		return Double.doubleToLongBits(assistsPerGame) == Double.doubleToLongBits(other.assistsPerGame)
				&& Double.doubleToLongBits(blocksPerGame) == Double.doubleToLongBits(other.blocksPerGame)
				&& Double.doubleToLongBits(fieldGoalPercentage) == Double.doubleToLongBits(other.fieldGoalPercentage)
				&& gamesPlayed == other.gamesPlayed
				&& Double.doubleToLongBits(minPerGame) == Double.doubleToLongBits(other.minPerGame)
				&& Double.doubleToLongBits(pointsPerGame) == Double.doubleToLongBits(other.pointsPerGame)
				&& Double.doubleToLongBits(reboundsPerGame) == Double.doubleToLongBits(other.reboundsPerGame)
				&& Double.doubleToLongBits(stealsPerGame) == Double.doubleToLongBits(other.stealsPerGame)
				&& Double.doubleToLongBits(threePointPercentage) == Double.doubleToLongBits(other.threePointPercentage);
	}
	
}
