/*
Program done by
Name - Abhijith T R
Entry Number - 2020CSB1062

This models the human player object. The only purpose of this class is to store a symbol for the player and to get a move from the player.
*/

import java.util.Scanner;

public class Person {
	/* Sets the symbol that the character is going to be using */
	private char symbol;
	
	/* Sets the player number */
	private int number;
	
	/* Constructor function */
	public Person(char symbol,int number) {
		this.symbol = symbol;
		this.number = number;	
	}
	
	// Getter functions
	public char getSymbol() {
		return this.symbol;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	/* Function to get the move from the user, i.e., the required position on the board */
	public int getMove() {
		Scanner input = new Scanner(System.in);
		System.out.print("Player "+this.number+", enter a number [1-9] : ");
		return input.nextInt();
	}
}
