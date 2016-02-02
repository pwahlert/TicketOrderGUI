import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Paula
 *
 */
public class TicketOrderFrameBintner extends JFrame {

	StatusBarBintner status = new StatusBarBintner();
	private TicketBintner Tickets;
	private static final int INITIAL_BALANCE = 75;
	private JLabel instrLabel = new JLabel("Enter how many tickets you'd like to purchase (1-6)              ");
	private JTextField Amount = new JTextField(15);
	private JLabel message1 = new JLabel();

	public TicketOrderFrameBintner() {
		Tickets = new TicketBintner(INITIAL_BALANCE);
		JPanel p = new JPanel();
		JButton Purchase = new JButton("Purchase Tickets");

		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		status.setPreferredSize(new Dimension(300, 300));

		p.add(instrLabel);
		p.add(Amount);
		p.add(Purchase);
		p.add(message1);
		p.add(status);

		add(p);
		setSize(400, 400);

		ActionListener pt = new purchaseListener();
		Purchase.addActionListener(pt);
	}

	class purchaseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Purchase Order Button clicked");
			String a = Amount.getText();
			System.out.println(a);
			System.out.println(Tickets.getTicketsSold());
			System.out.println(Tickets.getMax_Available());
			if (!(a.equals(""))){
				try {
						if (Tickets.getTicketsSold()==Tickets.getMax_Available()){
							message1.setText("Tickets are sold out");
							Amount.setText("");
						}else {
								int ticketAmt = Integer.parseInt(a);
								double compareTicket = Tickets.getTickets();
								if (ticketAmt <= 6) {
									if (ticketAmt > 0) {
										if (ticketAmt <= Tickets.getTickets()) {
											Tickets.purchase(ticketAmt);
											double TicketsPurch = Tickets.getTicketsSold();
											double MaxTickets = Tickets.getMax_Available();
											double tempX = ((TicketsPurch / MaxTickets) * 200);
											System.out.println("tempX = " + tempX);
											status.setNewValues(tempX);
											System.out.println(ticketAmt);
											System.out.println(compareTicket);
											System.out.println(Tickets.getTicketsSold());
											message1.setText(ticketAmt + " tickets purchased. " + Tickets.getTickets() + " tickets remaining.     ");
											Amount.setText("");
										} else {
											System.out.println(ticketAmt);
											System.out.println(compareTicket);
											message1.setText(ticketAmt + " is greater than number of tickets remaining. " + compareTicket + " tickets remaining.     ");
											Amount.setText("");
											}
									} else {
										message1.setText("Please enter a positive number between 1 and 6.");
										Amount.setText("");
										}
								} else {
									if (ticketAmt > 6) {
										message1.setText("Only 1-6 tickets may be pruchased at a time");
										Amount.setText("");
										}
									}
								}	
						 
				} catch (NumberFormatException ex) {
					message1.setText("Please enter a number only.");
					Amount.setText("");
			}
		}
	}
	}
}
