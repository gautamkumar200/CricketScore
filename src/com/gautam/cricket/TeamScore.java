package com.gautam.cricket;

public class TeamScore {

	private int score;
	
	private int overs;
	
	private int extras;
	
	private int wickets;

	
	public TeamScore(int score, int overs, int extras, int wickets) {
		super();
		this.score = score;
		this.overs = overs;
		this.extras = extras;
		this.wickets = wickets;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getOvers() {
		return overs;
	}

	public void setOvers(int overs) {
		this.overs = overs;
	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras = extras;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
}
