package com.gautam.cricket;

public class Player {

	private String name;
	
	private PlayerScore score ;

	public Player(String name, PlayerScore score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerScore getScore() {
		return score;
	}

	public void setScore(PlayerScore score) {
		this.score = score;
	}
	
}
