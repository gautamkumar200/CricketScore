package com.gautam.cricket;

public class PlayerScore {

	private int noOfBalls;
	private int score;
	private int noOf4s;
	private int noOf6s;
	
	
	public PlayerScore() {
		super();
		this.noOfBalls = 0;
		this.score = 0;
		this.noOf4s = 0;
		this.noOf6s = 0;
	}
	public int getNoOfBalls() {
		return noOfBalls;
	}
	public void setNoOfBalls(int noOfBalls) {
		this.noOfBalls = noOfBalls;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getNoOf4s() {
		return noOf4s;
	}
	public void setNoOf4s(int noOf4s) {
		this.noOf4s = noOf4s;
	}
	public int getNoOf6s() {
		return noOf6s;
	}
	public void setNoOf6s(int noOf6s) {
		this.noOf6s = noOf6s;
	}
	
}
