/* 
Program done by
Name - Abhijith T R
Entry Number - 2020CSB1062

Uses the Board, Computer and Person classes to model a game of TicTacToe
*/

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		/* Providing the user with choice */
		System.out.println("Enter 1 to play against the computer");
		System.out.println("Enter 2 to play a 2 player game");	
		System.out.print("Do you wish to play a 2 player game or against the computer : ");

		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		System.out.println();
		
		/* Initialising the new board */
		Board b1 = new Board();
		
		if (choice==1) {
			System.out.println("The player is X and the computer is O");
			b1.printBoardNumbers();
			Person p1 = new Person('X',1);
			Computer comp = new Computer();
			
			while (true) {
				/* Exactly the same as explained in the two player program */
				while (b1.set(p1.getMove(),p1.getSymbol())==0);
				if (b1.checkIfWon(p1.getSymbol(),p1.getNumber())) break;
				b1.printTheBoard();
				if (b1.checkIfFull()) break;
				
				/* The same process, except for the computer */
				b1.set(comp.makeMove(b1.getBoard()),comp.getSymbol());
				if (b1.checkIfWon(comp.getSymbol(),comp.getNumber())) break;
				b1.printTheBoard();
			}
			/* The isComputer arguement is passed by comparing the symbol from the computer object to the winner symbol stored in the 
			board which is O by default. This will not cause a problem because a draw is the default configuration of the board as set
			in the integer variable winners which is 0 to denote draw */
			b1.whoWon(comp.getSymbol()==b1.getWinnerSymbol());
		}
		
		else if (choice==2) {
			System.out.println("Player 1 is X and Player 2 is O");
			/* Creates two new person objects which have the pre-defined symbols X and O */
			b1.printBoardNumbers();
		 	Person p1 = new Person('X',1);
		 	Person p2 = new Person('O',2);
		 	
		 	while (true) {
		 		/* As long as the first player does not enter a legal move */
		 		while (b1.set(p1.getMove(),p1.getSymbol())==0);
		 		
		 		/* If the board has a winning configuration, stop the game */
		 		if (b1.checkIfWon(p1.getSymbol(),p1.getNumber())) break;
		 		
		 		/* Print the board after each turn */
		 		b1.printTheBoard();
		 		
		 		/* Case of a draw. It can only happen after the first player has made his fifth move */
		 		if (b1.checkIfFull()) break;
		 		
		 		/* Similar operations for the second player */
		 		while (b1.set(p2.getMove(),p2.getSymbol())==0);
		 		if (b1.checkIfWon(p2.getSymbol(),p2.getNumber())) break;
		 		b1.printTheBoard();
		 	}
		 	// If it a two player game, then we can just say the isComputer is false, because a computer definitely did not win
		 	b1.whoWon(false);
		}
	}
}
