# Tic-Tac-Toe

Program done by
Name - Abhijith T R
Entry Number - 2020CSB1062

The directory contains 4 .java files and 4 .class files. 

Only TicTacToe.java has a main function and only it can be run in the terminal.

Directly run the program using java TicTacToe
If not possible, use javac TicTacToe.java and then java TicTacToe
If still not possible, compile all the files separately using javac filename.java and then run using java TicTacToe

# ASSUMPTIONS

1. Computer goes second when game is player v/s computer. 

# FILES PRESENT IN THE DIRECTORY

1. Board.java - Models the Board object. It contains the board configuration and all possible winning configurations. 
   It contains the functions to set a particular position on the board to a particular symbol, the function to check 
   if someone has won and figure out who has won and also the function to print the board beautifully. 
   
2. Person.java - Models the human player. Has a symbol to store the playing symbol and a player number.
   Only one important function to get the move from the player and return it. 
   
3. Computer.java - Models the computer. Stores the computer symbol and its own combinations to win (where order is important).
   Contains a function that receives a board configuration and figures out the best move to play. It uses some private auxiliary 
   functions to do this. 
   
4. TicTacToe.java - Uses the above mentioned classes to model the player and computer and play the game. 

  (Detailed description of code is mentioned in the comments in the program)

# INSTRUCTIONS WHILE THE PROGRAM IS RUNNING

1. On running TicTacToe, you will be asked to enter a number i.e., 1 or 2. If 1 is entered, the game vs the computer will commence. 
   Enter 2 for a 2 player game and press enter. Do not enter any other number. 
   e.g.
  	Enter 1 to play against the computer
	Enter 2 to play a 2 player game
	Do you wish to play a 2 player game or against the computer : 1
	
2. If 1 is entered, the user will be asked to enter a number. Enter a number ONLY between 1-9 and press enter. The board will display 
   twice. Once after the player enters it and once to signify the computers move. No input is required until the program prompts the 
   user to enter the next number. Skip to instruction 4. 
   e.g. 
   	The player is X and the computer is O
	Player 1, enter a number [1-9] : 1
	 X |   |  
	---|---|---
	   |   |  
	---|---|---
	   |   |  

	Computer, enter a number[1-9] : 5
	 X |   |  
	---|---|---
	   | O |  
	---|---|---
	   |   |  

	Player 1, enter a number [1-9] : 9
	
3. If 2 is entered, player 1 will be asked to enter a number. Enter a number ONLY between 1-9 and press enter. The board will display 
   once. Then, player 2 will be prompted to enter a input, if the game has not ended. Enter a number ONLY between 1-9 and press enter. 
   The board will display again. If the game has not ended, player 1 will be prompted to enter a number.
   e.g. 
   	Player 1 is X and Player 2 is O
	Player 1, enter a number [1-9] : 1
	 X |   |  
	---|---|---
	   |   |  
	---|---|---
	   |   |  

	Player 2, enter a number [1-9] : 2
	 X | O |  
	---|---|---
	   |   |  
	---|---|---
	   |   |  

	Player 1, enter a number [1-9] : 

4. Once a winning configuration is reached, the game will end by itself without any input from the user. Run again using java TicTacToe to play again.


