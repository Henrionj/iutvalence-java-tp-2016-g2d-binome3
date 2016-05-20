package fr.iutvalence.henrionjulien.chess;

import java.util.Scanner;

/**
 * The main class
 *
 * @author henrion & murer
 * @version V1 
 *  
 */
public class Chess
{

	/**
	 * Run the application.
	 *
	 * @param args null
	 */
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner (System.in)) {
			System.out.println("Player 1, choose a name :");
			String player1 = scanner.nextLine();
			System.out.println("Player 2, choose a name :");
			String player2 = scanner.nextLine();
			Game game = new Game(player1, player2, scanner);
			game.run();
		}
	}

}
