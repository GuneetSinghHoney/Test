package lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Lottery
{
	//Private Variables 
	private double pot = 200;
	private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	private Ticket[] winner = null;
	//private int initialPotvalue = 200;
	private static Lottery obj = null;

	Lottery(int pot)
	{
		this.pot = pot;
	}
	
	//Using Singleton approach.	
	public static Lottery getInstance()
	{
		if(obj == null)
		{
			obj = new Lottery(200);
			return obj;
		}
		else
		{
			return obj;
		}
		
	}
	//Resetting the tickets.
	public void resetTickets()
	{
		hmap = new HashMap<Integer, String>();
		winner =null;
		
	}
	
	//Setters and getters.
	public double getPot() {
		return pot;
	}
	
	public HashMap<Integer, String> getSoldTickets()
	{
		return hmap;
	}	
	 
	
	//Checking if the lottery number is declared before to avoid errors. 
	public boolean checkLotteryNumber(int lotterNumber) {
		return hmap.containsKey(lotterNumber);		
	}
	
	//Buy Tickets - Random
	public int buyTicket(String name)
	{
		if(hmap.size() == 50)
		{
			return -1;
		}
		Random rand = new Random();
		while(true) {
		int  n = rand.nextInt(50) + 1;
		if(this.checkLotteryNumber(n) == false)
		{
			hmap.put(n, name);
			pot = pot+10;
			return n;
		}
		}
	}

	//Draw ticket will get tickets randomly and fill a array to be displayed.
	//doing all the calculation calculating prizes.
	public Ticket[] draw()
	{
		Ticket[] t = new Ticket[3];
		Random rand = new Random();
		int  n;
		double halfPot =pot/2;
		for(int i=0; i<3 ;i++)
		{
			 n = rand.nextInt(50) + 1;
			System.out.println(n);
			Ticket tick = new Ticket();
			if(hmap.containsKey(n))
			{
				tick.setTicketNumber(n);
				tick.setBuyerName(hmap.get(n).toUpperCase());
				tick.toString();
				
				//Pay Money
				if(i==0)
				{
					
					double win = (0.75*halfPot);
					tick.setWinningAmount(Math.round(win));
					pot = Math.round(pot - win);
				}
				else if(i==1)
				{
					double win = (0.15*halfPot);
					tick.setWinningAmount(Math.round(win));
					pot = Math.round(pot - win);
				}
				else if(i==2)
				{
					double win = (0.10*halfPot);
					tick.setWinningAmount(Math.round(win));
					pot = Math.round(pot - win);
				}
			}
			else
			{
				tick.setTicketNumber(n);
				tick.setBuyerName("NO WINNER");
			}
			
			t[i] = tick;
		}
		winner =t;
		return t;
	}
	
	//Resetting the game
	public void reset()
	{
		hmap = new HashMap<Integer,String>();
		pot = 200;
		winner = null;
		
	}
	
	//Getter
	public Ticket[] getWinners()
	{
		return winner;
	}
}
