package project;

import java.util.ArrayList;

public class Player {
	int score;
	String name;
	ArrayList<Matches> MatchesList = new ArrayList<Matches>();
	ArrayList<Games> GamesList = new ArrayList<Games>();
	ArrayList<Sets> SetsList = new ArrayList<Sets>();

	public ArrayList<Sets> getSetsList() {
		return SetsList;
	}

	public void setSetsList(ArrayList<Sets> setsList) {
		SetsList = setsList;
	}

	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ArrayList<Games> getGamesList() {
		return GamesList;
	}
	public void setGamesList(ArrayList<Games> gamesList) {
		GamesList = gamesList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Matches> getMatchesList() {
		return MatchesList;
	}
	public void setMatchesList(ArrayList<Matches> matchesList) {
		MatchesList = matchesList;
	}
	

}

