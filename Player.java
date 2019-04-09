/*
 *
 * @author
 */
public class Player {
	// INSTANCE DATA: name, wins, losses, symbols
	private String name;
	private int wins;
	private int losses;
	private String symbol;

	//CONSTRUCTOR
	public Player(String playerName)
	{	
		name =  playerName;
		wins = 0;
		losses = 0;
	}
	//get and set methods for all instance data
	public String getName()
	{
		return name;
	}

	public void setName(String playerName)
	{
		name = playerName;
	}

	public int getWins()
	{
		return wins;
	}

	public void setWins(int newWins)
	{
		wins = newWins;
	}

	public int getLosses()
	{
		return losses;
	}

	public void setLosses(int newLossess)
	{
		losses = newLossess;
	}

	public String getSymbol()
	{
		return symbol;
	}

	public void setSymbol(String newSymbol)
	{
		symbol = newSymbol;
	}
	
	public String toString()
	{
		return name + "\nWins: " + wins + "\nLosses: " + losses + "\n";
	}
}
