package lottery;

public class Ticket
{
	int ticketNumber = 0;
	int ticketSerialNumber;// Future Use
	String buyerName;
	
	public Ticket()
	{
	}
	
	public Ticket(int ticketNumber, String buyerName) {
		super();
		this.ticketNumber = ticketNumber;
		this.buyerName = buyerName;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getTicketSerialNumber() {
		return ticketSerialNumber;
	}

	public void setTicketSerialNumber(int ticketSerialNumber) {
		this.ticketSerialNumber = ticketSerialNumber;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNumber=" + ticketNumber + ", buyerName=" + buyerName + "]";
	}

}
