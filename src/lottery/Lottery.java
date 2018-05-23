package lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Lottery
{
	private double pot = 200;
	private HashMap<Integer, String> hmap = new HashMap<Integer, String>();

	//private int initialPotvalue = 200;
	private static Lottery obj = null;

	Lottery(int pot)
	{
		this.pot = pot;
	}
	
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
	
	public double getPot() {
		return pot;
	}
	
	public HashMap<Integer, String> getSoldTickets()
	{
		return hmap;
	}	
	 
	
	 
	public boolean checkLotteryNumber(int lotterNumber) {
		return hmap.containsKey(lotterNumber);		
	}
	
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
					pot = Math.round(pot -(0.75*(halfPot)));
				}
				else if(i==1)
				{
					pot = Math.round(pot -(0.15*(halfPot)));
				}
				else if(i==2)
				{
					pot = Math.round(pot -(0.10*(halfPot)));
				}
			}
			else
			{
				tick.setTicketNumber(n);
				tick.setBuyerName("NO WINNER");
			}
			
			t[i] = tick;
		}
		return t;
	}
	
	public void reset()
	{
		hmap = new HashMap<Integer,String>();
		
	}

}
