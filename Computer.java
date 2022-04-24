/*
Program done by
Name - Abhijith T R
Entry Number - 2020CSB1062

This models the computer object. It receives a board configuration and makes a move based on the existing configuration.  
*/

public class Computer {
	/* We assume that computer always uses this symbol, as given in the question */
	private char symbol = 'O';
	
	/* The board uses numbers 1 and 2 for the players and 3 for the computer (does not matter. Just to ensure uniformity across player and computer) */
	private int number = 3;
	
	/* The computer designed here needs the win combinations in this particular order. It cannot depend on the 
	winCombinations which is present in the Board class */
	private int[][] winCombinations = {{0,4,8},{2,4,6},{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8}};
	
	/* Getter functions */
	public char getSymbol() {
		return this.symbol;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	/* The most important computer function. This function uses several other auxiliary functions
	to calculate the ideal move for the computer. Effectively we use the winCombinations that we have
	in order to calculate the number of X and O in each winCombination element. This is also the only public 
	function (apart from the getter functions), since the main program only has to get the move from the computer.
	
	We have only a few combinations of interest, which are listed below
	X=0 O=2 -- The computer can win in the next move, and will play the winning move always
	X=2 O=2 -- Computer has to respond to the player and stop him from winning
	X=1 O=0 -- Computer will try to stop the player from establishing a 2-0 position on this winCombination. (Will play adjacent to player always)
	X=0 O=1 and X=0 O=0 -- Not coded, as the bot will always encounter one of the above combinations first
	*/
	public int makeMove(char[] board) {
		// Checks if the board is full. In our current main program, this condition will NEVER occur 
		if (isBoardFull(board)) {
			return -1;
		}
		
		//Uses the function symbolCount to return the number of Xs and Os in each win combination possible on the board
		int[][] makeMove = symbolCount(board,this.winCombinations); 
		
		//Variable to store the move that the computer will make
		int location = -1;
		
		//Stop the loop (and all subsequent ones) as soon as you find a legal move, that is why all loops have an addition location==-1 condition in them
		
		//Searching for a possible winning move for the computer first
		for (int i=0;i<makeMove.length && location==-1;i++) if (makeMove[i][1]==2 && makeMove[i][0]==0) location = findLocation(this.winCombinations,i,board,0);
		
		//Searching for a possible winning move for the player and stopping it
		for (int i=0;i<makeMove.length && location==-1;i++) if (makeMove[i][1]==0 && makeMove[i][0]==2) location = findLocation(this.winCombinations,i,board,2);
		
		//Searching for a possible move to obstruct a 2-0 on any position
		for (int i=0;i<makeMove.length && location==-1;i++) if (makeMove[i][1]==0 && makeMove[i][0]==1) location = findLocation(this.winCombinations,i,board,1);
		
		//This will not be reached. 
		for (int i=0;i<makeMove.length && location==-1;i++) if (makeMove[i][1]+makeMove[i][0]!=3) location = findLocation(this.winCombinations,i,board,makeMove[i][0]);
		
		//Increment the location, as the function on the board accepts 1-9 and not 0-8 as in winCombinations
		location ++ ;
		System.out.println("Computer, enter a number[1-9] : "+location);
		return location;
	}
	
	/* Once you have found a X-O combination where you would like to make a move, you simple search for the first ' ' to make a move
	This function simply goes through the winCombination positions and tries to find a space */
	private int findLocation(int[][] winCombinations,int location,char[] board,int numberOfX) {
		//Each winCombination has only three positions. So j from 0 to 2 is enough
		// If the combination is 2-0 or 0-2, we need to find a ' '. This is sufficient
		if (numberOfX!=1) {
			for (int j=0;j<3;j++) {
				if (board[winCombinations[location][j]]==' ') {
					return winCombinations[location][j];
				}
			}
		}
		
		//If we are placing a circle on a winCombination element with only one X, we will place the O adjacent to the X
		else if (numberOfX==1) {
			if (board[winCombinations[location][0]]=='X') return winCombinations[location][1];
			else if (board[winCombinations[location][1]]=='X') return winCombinations[location][0];
			else if (board[winCombinations[location][2]]=='X') return winCombinations[location][1];
		}
		return -1;
	}
	
	/* Extremely important function. This is going to go through the board and find the X-O combination at each possible winCombination */
	private int[][] symbolCount(char[] board,int[][] winCombinations) {
	
		// Eight winCombinations available, hence length 8 and of length 2 to store count of X and O.
		int[][] makeMove = new int[8][2];
		
		// Set all the elements to 0
		for (int i=0;i<8;i++) for (int j=0;j<2;j++) makeMove[i][j] = 0;
		
		// Go through all the possible winCombinations on the board and count the number of Xs and Os at each position
		for (int i=0;i<8;i++) {
			for (int j=0;j<3;j++) {
				if (board[winCombinations[i][j]]==symbol) makeMove[i][1]++;
				else if (board[winCombinations[i][j]]!=' ') makeMove[i][0]++;
			}
		}
		return makeMove;
	}
	
	/* Just to check if there is an empty spot on the board. Just iterate through the board */
	private boolean isBoardFull(char[] board) {
		for (int i=0;i<9;i++) {
			if (board[i]==' ') {
				return false;
			}
		}
		return true;
	}
	
	
}
