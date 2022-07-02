package com.gautam.cricket;

import java.util.ArrayList;
import java.util.List;

public class Match {

    public final int NO_OF_PLAYERS;
	public final int NO_OF_OVERS;
	
	public int INNING = 0;
	
	private List<Team> teams;
	
	private Player onStrikePlayer;
	private Player offStrikePlayer;


	public Match(int nO_OF_PLAYERS, int nO_OF_OVERS) {
		super();
		NO_OF_PLAYERS = nO_OF_PLAYERS;
		NO_OF_OVERS = nO_OF_OVERS;
		this.teams = new ArrayList<Team>(2);// each match will have two teams only
	}

	public Player getOnStrikePlayer() {
		return onStrikePlayer;
	}


	public void setOnStrikePlayer(Player onStrikePlayer) {
		this.onStrikePlayer = onStrikePlayer;
	}

	public void rotateStrike() {
		
		Player temp = this.onStrikePlayer;
		this.onStrikePlayer = this.offStrikePlayer;
		this.offStrikePlayer = temp;
	}
	
	public Player getOffStrikePlayer() {
		return offStrikePlayer;
	}


	public void setOffStrikePlayer(Player offStrikePlayer) {
		this.offStrikePlayer = offStrikePlayer;
	}

	public int getINNING() {
		return INNING;
	}


	public void setINNING(int iNNING) {
		INNING = iNNING;
	}


	public List<Team> getTeams() {
		return teams;
	}

	public int getNO_OF_PLAYERS() {
		return NO_OF_PLAYERS;
	}


	public int getNO_OF_OVERS() {
		return NO_OF_OVERS;
	}

	
	public void printMatchResult() {
		
		String res = "";
		
		int team1_score = teams.get(0).getTeamScore().getScore();
		int team2_score = teams.get(1).getTeamScore().getScore();
		if(team1_score> team2_score) {
			int run_diff = team1_score-team2_score;
			res = teams.get(0).getName()+" won the match by "+ run_diff+" runs";
		}
		else if(team1_score < team2_score) {
			int run_diff = team2_score - team1_score;
			res = teams.get(1).getName()+" won the match by "+ run_diff+" runs";
		}
		else {
			int team1_wicket = teams.get(0).getTeamScore().getWickets();
			int team2_wicket = teams.get(1).getTeamScore().getWickets();
			
			if(team1_wicket> team2_wicket) {
				int wicket_diff = team1_wicket - team2_wicket;
				res = teams.get(1).getName()+" won the match by "+ wicket_diff+" wickets";
			}
			else if(team1_wicket< team2_wicket) {
				int wicket_diff = team2_wicket - team1_wicket;
				res = teams.get(0).getName()+" won the match by "+ wicket_diff+" wickets";
			}
			else {
				res = "Match is Tie";
			}
		}
	    System.out.println();
	    System.out.println("Result : "+ res);
	}
	
	
	
	

}
