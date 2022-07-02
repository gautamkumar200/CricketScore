package com.gautam.cricket;

import java.util.List;
import java.util.ArrayList;

public class Team {
	
	private String name;
	
	private List<Player> players;;
	
	private TeamScore teamScore;
	
	private int totalGroundedPlayer;

	public Team(String name, List<Player> players, TeamScore teamScore) {
		super();
		this.name = name;
		this.players = players;
		this.teamScore = teamScore;
		this.totalGroundedPlayer = 2;// initially two player will play @assumption
	}
	
	
	public void printScoreBoard() {
		
		// print the players scoreboard
		
		System.out.println("Player\t"+"Score\t"+"4s\t"+"6s\t"+"Balls");
		for (Player player : this.players) {
			
			System.out.println(player.getName()+"\t"+player.getScore().getScore()+"\t"+player.getScore().getNoOf4s()+
					"\t"+player.getScore().getNoOf6s()+"\t"+player.getScore().getNoOfBalls());
			
		}
		
		// team total
		System.out.println("Total: "+ teamScore.getScore()+"/"+teamScore.getWickets());
		// Overs
		System.out.println("Overs: "+ teamScore.getOvers());
		// Extras
		System.out.println("Extras: "+ teamScore.getExtras());
		
		
	}
	
	public Player getNextPlayerToBat() {
		
		Player player = null;
		if(players.size() > this.totalGroundedPlayer) {
			
			this.totalGroundedPlayer++;
			
			return players.get(totalGroundedPlayer-1);
		}
		return player;
	}

	public int getTotalGroundedPlayer() {
		return totalGroundedPlayer;
	}


	public void setTotalGroundedPlayer(int totalGroundedPlayer) {
		this.totalGroundedPlayer = totalGroundedPlayer;
	}

	

	public TeamScore getTeamScore() {
		return teamScore;
	}

	public void setTeamScore(TeamScore teamScore) {
		this.teamScore = teamScore;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	
	
}
