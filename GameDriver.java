import java.util.*;

public class GameDriver 
{
	public static void main(String[] args)
	{
		//Instance data
		TicTacToe board = new TicTacToe();
		Player player1, player2 = null;
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int player1Wins=0;
		int player2Wins=0;
		boolean playAgain = true;

		//ask for player names and prints them out
		System.out.print("> Enter the name of Player1: ");
		String name1 = scan.next();
		System.out.print("> Enter the name of Player2: ");
		String name2 = scan.next();
		player1 = new Player(name1);
		player2 = new Player(name2);
		System.out.println("Welcome Player 1: "+player1.getName());
		System.out.println("Welcome Player 2: "+player2.getName());

		//play again function
		while (playAgain)
		{
			//resets game
			System.out.print(player1);
			System.out.print(player2);
			String winner = null;
			String turn = "x";
			System.out.println("=======================");
			System.out.println("LET'S PLAY TIC TAC TOE!");
			System.out.println("=======================");
			board.resetBoard();
			System.out.println(board);

			//randomly generates who starts
			int num = rand.nextInt(2);
			if (num==1)
			{
				player1.setSymbol(turn);
				player2.setSymbol("o");
				System.out.print(player1.getName() + " is '" + turn + "' and " + player2.getName() + " is 'o'" + "\n" + player1.getName() + " goes first\n");
			}
			else
			{
				player2.setSymbol(turn);
				player1.setSymbol("o");
				System.out.print(player2.getName() + " is ''" + turn + "' and " + player1.getName() + " is 'o'" + "\n" + player2.getName() + " goes first\n");
			} 

			//Keeps the game running while there is no winner
			while (winner == null)
			{
				//Displays symbol's turn and then takes in user input
				System.out.print("It is " + turn + "'s turn. \nEnter a row: ");
				int row = scan.nextInt();
				System.out.print("Enter a column: ");
				int col = scan.nextInt();
				
				//Checks to see if user input is valid
				if (!(row<=3 && row >= 1 && col <=3 && col>=1))
				{
					System.out.println("ERROR. Input out of bounds. Please enter another.");
				}
				else
				{
					//Changes the board to symbol
					boolean flag = board.change(row,col,turn);
					System.out.println(board);
					winner = board.winner();
					
					//changes turn
					if (flag)
					{
						if (turn == "x")
						{
							turn = "o";
						}
						else
						{
							turn = "x";
						}
					}
				}
			}
			
			//Displays for who wins
			if (winner == "x")
			{
				if (player1.getSymbol()=="x")
				{
				System.out.println(player1.getName() + " won!");
				player1Wins +=1;
				player1.setWins(player1Wins);
				player2.setLosses(player1Wins);
				}
				else
				{
					System.out.println(player2.getName() + " won!");
					player2Wins +=1;
					player2.setWins(player2Wins);
					player1.setLosses(player2Wins);
				}
			}
			if (winner == "o")
			{
				if (player1.getSymbol()=="o")
				{
				System.out.println(player1.getName() + " won!");
				player1Wins +=1;
				player1.setWins(player1Wins);
				player2.setLosses(player1Wins);
				}
				else
				{
					System.out.println(player2.getName() + " won!");
					player2Wins +=1;
					player2.setWins(player2Wins);
					player1.setLosses(player2Wins);
				}
			}
			if (winner == "draw")
			{
				System.out.println("It is a draw!");
			}

			//asks the user to play again
			System.out.print("Enter 1 to play again. Enter anything else to quit: ");
			int again = scan.nextInt();

			if (again == (1))
			{
				playAgain = true;
			}
			else
			{
				playAgain = false;
				System.out.print(player1);
				System.out.print(player2);
				System.out.println("Thanks for playing!");
			}
		}
	}
}
