/*
 * TicTacToe class
 * @author 
 */
import java.util.*;
public class TicTacToe
{
	public static String[][] board;
	public static String winner;

	public TicTacToe()
	{
		board = new String[3][3];
		winner = null;
	}

	//resets board
	public void resetBoard()
	{
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<3; j++)
			board[i][j] = "-";
		}
	}

	//changes given row and col to given symbol
	public boolean change(int row,int col, String turn)
	{
		if (turn.equals("x"))
		{
			if (board[row-1][col-1] == "-")
			{
				board[row-1][col-1] = "x";
				return true;
			}
			//checks to see if row is taken
			else
			{
				System.out.println("That spot is taken. Try again!");
				return false;
			}
		}
		if (turn.equals("o"))
		{
			if (board[row-1][col-1] == "-")
			{
				board[row-1][col-1] = "o";
				return true;
			}
			else
			{
				System.out.println("That spot is taken. Try again!");
				return false;
			}
		}
		return true;
	}

	//checks to see if there is a winner
	public String winner()
	{
		int x = 0;
		for (int i=0; i<8; i++)
		{
			String test = null;
			switch(i)
			{
				case 0:
					test = board[0][0] + board[0][1] + board[0][2];
					break;
				case 1:
					test = board[1][0] + board[1][1] + board[1][2];
					break;
				case 2:
					test = board[2][0] + board[2][1] + board[2][2];
					break;
				case 3:
					test = board[0][0] + board[1][0] + board[2][0];
					break;
				case 4:
					test = board[0][1] + board[1][1] + board[2][1];
					break;
				case 5:
					test = board[0][2] + board[1][2] + board[2][2];
					break;
				case 6:
					test = board[0][0] + board[1][1] + board[2][2];
					break;
				case 7:
					test = board[0][2] + board[1][1] + board[2][0];
					break;
			}
			if (test.equals("xxx"))
			{
				return "x";
			}
			else if (test.equals("ooo"))
			{
				return "o";
			}
		}
		for (int i=0; i<3; i++)
		{

			for (int j=0; j<3; j++)
			{
				x++;
				if(board[i][j] == "-")
				{
					break;
				}
				else if (x==9)
				{
					return "draw";
				}
			}
		}
		return null;
	}			
	
	//displays board
	public String toString()
	{ 
		return 	"| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n| " + board[1][0] + " | " + board[1][1] + " | "+ board[1][2] + " | \n| " + board[2][0] + " | " + board[2][1] + " | "+ board[2][2] + " | ";
	}	
}
