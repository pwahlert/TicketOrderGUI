/**
 * 
 */

/**
 * @author Paula
 *
 */
public class TicketBintner {
	private int tickets;
	private int Max_Available= 75;
	private int ticketsSold = 0;

	
	/**
	 * @return the ticketsSold
	 */
	public int getTicketsSold() {
		return ticketsSold;
	}
	/**
	 * @param ticketsSold the ticketsSold to set
	 */
	public void setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}
	
	/**
	 * @return the max_Available
	 */
	public int getMax_Available() {
		return Max_Available;
	}
	/**
	 * @param max_Available the max_Available to set
	 */
	public void setMax_Available(int max_Available) {
		Max_Available = max_Available;
	}
	public TicketBintner(){
		tickets = 0;
	}
	public TicketBintner(int INITIAL_BALANCE){
		tickets = INITIAL_BALANCE;
	}
	/**
	 * @return the tickets
	 */
	public int getTickets() {
		return tickets;
	}
	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	

	void purchase(int Amount){
		 int newtickets = (getTickets() - Amount);
		 int soldTickets = (getTicketsSold() + Amount);
		 this.setTickets(newtickets);
		 this.setTicketsSold(soldTickets);
		 
	 }
	
	

}
