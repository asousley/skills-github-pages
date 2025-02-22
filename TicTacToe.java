package TicTacToe;
import java.util.Scanner; 

public class TicTacToe {
	
	static String[] board;
	static String turn;
	
	public static void main(String args[]) {
		
		boolean winner;
		int boxChoice;
		boolean breakLoop = true;
		board = new String[9];
		int boxFilled = 0;
		
		Scanner scnr = new Scanner(System.in);
		for( int i = 0; i < 9; i++) {
			board[i] = "-";
		}
		while(breakLoop) {
			System.out.println("Who do you want to go first? O or X");
			String first = scnr.nextLine();
			
			if(first.equals("X")) {
				turn = "X";
				breakLoop = true;
			}
			else if(first.equals("O")) {
				turn = "O";
				breakLoop = false;
			}
			else {
				System.out.println("ERROR: Enter a valid value");
			}
			breakLoop = true;
			while(breakLoop) {
				
				printBoard();
				System.out.println("Which box do you want to go to, Player " + turn);
				boxChoice = scnr.nextInt();
				
				if (boxChoice >= 9 || boxChoice < 0) {
					System.out.println();
					System.out.println("ERROR: Invalid value");
				}
				else {
					boxFilled++;
					board[boxChoice] = turn;
					winner = checkWinner();
					if(winner == true) {
						printBoard();
						System.out.println("Player " + turn + " won!");
						break;
					}
				
					if (boxFilled >= 9) {
						printBoard();
						System.out.println("Tie!");
						break;
					}
					else if (turn == "X") {
						turn = "O";
					}
					else {
						turn = "X";
					}
				}
			}
		}
	}
	
		
	
	static boolean checkWinner() {
		for (int a = 0; a < 8; a++) {
			String line = "";
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2] + line;
				break;
			case 1:
				line = board[3] + board[4] + board[5] + line;
				break;
			case 2:
				line = board[6] + board[7] + board[8] + line;
				break;
			case 3:
				line = board[0] + board[3] + board[6] + line;
				break;
			case 4:
				line = board[1] + board[4] + board[7] + line;
				break;
			case 5:
				line = board[2] + board[5] + board[8] + line;
				break;
			case 6:
				line = board[0] + board[4] + board[8] + line;
				break;
			case 7:
				line = board[2] + board[4] + board[6] + line;
				break;
			}
			//For X winner
			if (line.equals("XXX")) {
				return true;
			}
			
			// For O winner
			else if (line.equals("OOO")) {
				return true;
			}
		}
		return false;
		}
	
	static void printBoard() {
		System.out.println(" 0  1  2");
		for(int i = 1; i <= 9; i++) {
			System.out.print("|" + board[i - 1] + "|");
			if (i % 3 == 0) {
				System.out.println();
			}
		}
	}
}
