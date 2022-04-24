/* 
   Program done by
   Name - Abhijith T R
   Entry Number - 2020CSB1062
   
   This object is used to model the board on which the game is played 
   The players must be able to tell whether they have won by looking at the board
   They should also be able to set one of the nine possible squares to a particular symbol (if that square is available to use)
*/

import java.util.Scanner;

public class Board {
	// Just a representation of the board at any instant of time during the game
	private char[] board = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
	
	/* Just a array that stores all the possible winning combinations i.e.
	 all the possible combinations of X and O that could win the game */
	private int[][] winCombinations = {{0,4,8},{2,4,6},{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8}};
	
	// A variable that stores the number of squares that are left and available at any instant of time
	private int emptySquares = 9;
	
	// If at any point during the game someone wins, it has to be noted. winnerSymbol is a useless variable until a winning configuration is achieved.
	private int winner = 0;
	private char winnerSymbol = 'O';
	
	/* Getter Functions */
	public int getEmptySquares() {
		return this.emptySquares;
	}
	
	public int[][] getWinCombinations() {
		return this.winCombinations;
	}
	
	public char[] getBoard() {
		return this.board;
	}
	
	public char getWinnerSymbol() {
		return this.winnerSymbol;
	}
	
	/* Function used to set a particular location on the board to a particular symbol
	If that square is empty, simply use that square, otherwise tell the player that this is not possible */
	public int set(int location,char symbol) {
		// If the square is empty, set that location to symbol
		if (board[location-1]==' ') {
			this.board[location-1] = symbol;
			this.emptySquares--;
		}
		
		// If the location is not empty, tell that the position is filled
		else {
			System.out.println("Position already filled. Try again");
			System.out.println();
			return 0;
		}
		return 1; 
	} 
	
	/* Function used to check whether either of the two players has won using the
	 array of win combinations */
	public boolean checkIfWon(char symbol,int playerNumber) {
		/* Iterate through all the winCombinations and try to figure out if the symbol that has been received as arguement has won */
		for (int i=0;i<8;i++) {
			// The three positions in each winCombination element
			int loc1,loc2,loc3;
			loc1 = winCombinations[i][0];
			loc2 = winCombinations[i][1];
			loc3 = winCombinations[i][2];
			
			if (board[loc1]==board[loc2] && board[loc2]==board[loc3] && board[loc1]==symbol) {
				this.winner = playerNumber;
				this.winnerSymbol = symbol;
				return true;
			}
		}
		return false;
	}
	
	/* Function to print the winner once the game is over */
	public void whoWon(boolean isComputer) {
		System.out.println();
		//Default value is 0 to signify drawn state
		if (winner==0) System.out.println("The game is a draw!");
		
		// We use isComputer to denote whether or not computer has won or the player
		else if (!isComputer) System.out.println("The winner is player "+winner+"!");
		else System.out.println("The winner is the computer!");
		printTheBoard();
	}
	
	/* Function to check if all 9 squares have been used or not */
	public boolean checkIfFull() {
		return this.emptySquares==0;
	}
	
	/* Function to let the user know how the board is numbered 
	Function is identical to the printTheBoard function below. */
	public void printBoardNumbers() {
		System.out.println();
		System.out.println("The board is numbered as given below" );
		for (int i=0;i<9;i++) {
			if (i%3==0) System.out.print(" ");
			System.out.print(i+1);
			if (i%3==2 && i!=8) {
				System.out.println();
				System.out.println("---|---|---");
			}
			else if (i%3==2) System.out.println();
			else System.out.print(" | ");
		}
		System.out.println();
	}
	
	/* Function to print the board in an appealing manner */
	public void printTheBoard() {
		for (int i=0;i<9;i++) {
			if (i%3==0) System.out.print(" ");
			// Print the symbol in the corresponding position
			System.out.print(this.board[i]);
			// If 3 items are printed print the pattern below
			if (i%3==2 && i!=8) {
				System.out.println();
				System.out.println("---|---|---");
			}
			else if (i%3==2) System.out.println();
			// print this after every element
			else System.out.print(" | ");
		}
		System.out.println();
	}
}

