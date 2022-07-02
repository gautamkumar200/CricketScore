package com.gautam.cricket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter no of Players for each team - ");

			int NO_OF_PLAYERS = Integer.parseInt(bufferedReader.readLine().trim());

			System.out.println("Enter no of Overs - ");
			int NO_OF_OVERS = Integer.parseInt(bufferedReader.readLine().trim());

			if (NO_OF_PLAYERS < 2 || NO_OF_OVERS < 1) {
				System.out.println(" Entered value is not correct ");
				return;
			}

			// start match
			MatchUtils.startMatch(NO_OF_PLAYERS, NO_OF_OVERS, bufferedReader);

		} catch (Exception ex) {

			System.err.print(ex);
		} finally {

			if (bufferedReader != null)
				bufferedReader.close();
		}

	}

}
