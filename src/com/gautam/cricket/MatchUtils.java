package com.gautam.cricket;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.gautam.exception.AllReadyWonTheMatchException;
import com.gautam.exception.NoPlayerFoundException;

public class MatchUtils {

	static final String VALID_BALL_INPUT[] = { "w", "wd", "nb", "0", "1", "2", "3", "4", "6" };

	public static void startMatch(int NO_OF_PLAYERS, int NO_OF_OVERS, BufferedReader bufferedReader)
			throws IOException {

		Match match = new Match(NO_OF_PLAYERS, NO_OF_OVERS);

		// each match has 2 innings
		for (int inning_no = 0; inning_no < 2; inning_no++) {

			// set innings
			match.setINNING(inning_no);

			// create team
			Team team = new Team("Team - " + (inning_no + 1), new ArrayList<Player>(), new TeamScore(0, 0, 0, 0));

			// add players in team
			System.out.println("Add batting orders of team: " + (inning_no + 1));

			for (int i = 0; i < NO_OF_PLAYERS; i++) {

				// get players name
				String playerName = bufferedReader.readLine().trim();
				// add players to the team with initial score
				team.getPlayers().add(new Player(playerName, new PlayerScore()));

			}
			// finally add the team to the match
			match.getTeams().add(team);

			// set onstrike offstrike player
			match.setOnStrikePlayer(match.getTeams().get(inning_no).getPlayers().get(0));
			match.setOffStrikePlayer(match.getTeams().get(inning_no).getPlayers().get(1));

			try {
				startOver(match, inning_no, NO_OF_OVERS, bufferedReader);
			} catch (NoPlayerFoundException ex) {
				// continue to the next innings
				
				// print scoreboard of the current team
				match.getTeams().get(inning_no).printScoreBoard();
			}
			catch (AllReadyWonTheMatchException ex) {
					// continue to the next innings
					
					// print scoreboard of the current team
					match.getTeams().get(inning_no).printScoreBoard();
					break;
		   }

		}
		// match result 
		match.printMatchResult();
	}

	private static void startOver(Match match, int inning_no, int NO_OF_OVERS, BufferedReader bufferedReader)
			throws IOException, NoPlayerFoundException, AllReadyWonTheMatchException {
		// TODO Auto-generated method stub
		//
		for (int over = 1; over <= NO_OF_OVERS; over++) {

			// play this over
			System.out.println("Over " + over + " : ");

			BallCount ballCount = new BallCount();

			// @assumption assuming 6 ball per over
			while (ballCount.ballCount < 6) {
				
				//check if this is second inning and score is more than 1 team
				if (inning_no == 1 ) {
				   int	team_1_score= match.getTeams().get(0).getTeamScore().getScore();
				   int team_2_score = match.getTeams().get(1).getTeamScore().getScore();
				   if(team_1_score < team_2_score) {
					  throw new AllReadyWonTheMatchException(" Team has already won the match");
				   }
				}
				
				String ball_input = bufferedReader.readLine().trim();
				if (validateBallInput(ball_input)) {
					// update score of team and player and rotate strikes
					
					updateScores(match, inning_no, ball_input, ballCount);
				} else {
					System.out.println(" Last input was not valid. Only Accepted values are " + Arrays.toString(VALID_BALL_INPUT));
					System.out.println(" Please provide the input again.. ");
				}
			}

			// update team overs
			match.getTeams().get(inning_no).getTeamScore()
			.setOvers(match.getTeams().get(inning_no).getTeamScore().getOvers() + 1);
			
			// print scoreboard
			match.getTeams().get(inning_no).printScoreBoard();
			
			// rotate strike 
			match.rotateStrike();
		}

	}

	private static void updateScores(Match match, int inning_no, String ball_input, BallCount ballCount)
			throws NoPlayerFoundException {
		// TODO Auto-generated method stub
		// update team and player scores
		switch (ball_input.toLowerCase()) {
		case "0":
			// update no of balls to onstrike player only
			match.getOnStrikePlayer().getScore().setNoOfBalls(match.getOnStrikePlayer().getScore().getNoOfBalls() + 1);

			// update ball_count
			ballCount.ballCount++;
			break;
		case "1":
			// update the team score , update player score - no of balls ,score and change
			// the on strike player
			match.getTeams().get(inning_no).getTeamScore()
					.setScore(match.getTeams().get(inning_no).getTeamScore().getScore() + 1);
			match.getOnStrikePlayer().getScore().setNoOfBalls(match.getOnStrikePlayer().getScore().getNoOfBalls() + 1);
			match.getOnStrikePlayer().getScore().setScore(match.getOnStrikePlayer().getScore().getScore() + 1);
			// rotate strike
			match.rotateStrike();

			// update ball_count
			ballCount.ballCount++;
			break;
		case "2":
			// update the team score , update player score - no of balls ,score
			match.getTeams().get(inning_no).getTeamScore()
					.setScore(match.getTeams().get(inning_no).getTeamScore().getScore() + 2);
			match.getOnStrikePlayer().getScore().setNoOfBalls(match.getOnStrikePlayer().getScore().getNoOfBalls() + 1);
			match.getOnStrikePlayer().getScore().setScore(match.getOnStrikePlayer().getScore().getScore() + 2);

			// update ball_count
			ballCount.ballCount++;
			break;
		case "3":
			// update the team score , update player score - no of balls ,score and change
			// the on strike player
			match.getTeams().get(inning_no).getTeamScore()
					.setScore(match.getTeams().get(inning_no).getTeamScore().getScore() + 3);
			match.getOnStrikePlayer().getScore().setNoOfBalls(match.getOnStrikePlayer().getScore().getNoOfBalls() + 1);
			match.getOnStrikePlayer().getScore().setScore(match.getOnStrikePlayer().getScore().getScore() + 3);
			// rotate strike
			match.rotateStrike();

			// update ball_count
			ballCount.ballCount++;
			break;
		case "4":
			// update the team score , update player score - no of balls ,score
			match.getTeams().get(inning_no).getTeamScore()
					.setScore(match.getTeams().get(inning_no).getTeamScore().getScore() + 4);
			match.getOnStrikePlayer().getScore().setNoOfBalls(match.getOnStrikePlayer().getScore().getNoOfBalls() + 1);
			match.getOnStrikePlayer().getScore().setScore(match.getOnStrikePlayer().getScore().getScore() + 4);
			// update 4s
			match.getOnStrikePlayer().getScore().setNoOf4s(match.getOnStrikePlayer().getScore().getNoOf4s() + 1);

			// update ball_count
			ballCount.ballCount++;
			break;
		case "6":
			// update the team score , update player score - no of balls ,score
			match.getTeams().get(inning_no).getTeamScore()
					.setScore(match.getTeams().get(inning_no).getTeamScore().getScore() + 6);
			match.getOnStrikePlayer().getScore().setNoOfBalls(match.getOnStrikePlayer().getScore().getNoOfBalls() + 1);
			match.getOnStrikePlayer().getScore().setScore(match.getOnStrikePlayer().getScore().getScore() + 6);
			// update 6s
			match.getOnStrikePlayer().getScore().setNoOf6s(match.getOnStrikePlayer().getScore().getNoOf6s() + 1);

			// update ball_count
			ballCount.ballCount++;
			break;
		case "w":
			// update no of ball consume
			match.getOnStrikePlayer().getScore().setNoOfBalls(match.getOnStrikePlayer().getScore().getNoOfBalls() + 1);

			// update team wickets down
			match.getTeams().get(inning_no).getTeamScore()
					.setWickets(match.getTeams().get(inning_no).getTeamScore().getWickets() + 1);

			// update ball_count
			ballCount.ballCount++;

			// get next player on strike
			Player next_player = match.getTeams().get(inning_no).getNextPlayerToBat();
			if (next_player!=null)
				match.setOnStrikePlayer(next_player);
			else {
				throw new NoPlayerFoundException("No player is available");
			}
			break;
		case "wd":
			// update the team score and extra
			match.getTeams().get(inning_no).getTeamScore()
					.setScore(match.getTeams().get(inning_no).getTeamScore().getScore() + 1);
			//update team extras
			match.getTeams().get(inning_no).getTeamScore()
					.setExtras(match.getTeams().get(inning_no).getTeamScore().getExtras() + 1);

			break;
		case "nb":
			// update the team score and extra
			match.getTeams().get(inning_no).getTeamScore()
					.setScore(match.getTeams().get(inning_no).getTeamScore().getScore() + 1);
			match.getTeams().get(inning_no).getTeamScore()
					.setExtras(match.getTeams().get(inning_no).getTeamScore().getExtras() + 1);
			break;
		}

	}

	private static boolean validateBallInput(String ball_input) {
		// TODO Auto-generated method stub
		for (int i = 0; i < VALID_BALL_INPUT.length; i++) {
			if (ball_input.toLowerCase().equals(VALID_BALL_INPUT[i]))
				return true;
		}

		return false;
	}
}
