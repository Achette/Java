package entities;

public class Bill {

	public static char gender;
	public static int beer;
	public static int barbecue;
	public static int softDrink;

	public static double Cover() {
		return 4.00;
	}

	public static double Feeding() {
		return (beer * 5.00) + (barbecue * 7.00) + (softDrink * 3.00);
	}

	public static double Ticket() {
		double ticket = 0;

		if (gender == 'F' || gender == 'f') {
			ticket = 8.00;
		} else if (gender == 'M' || gender == 'm') {
			ticket = 10.00;
		}

		return ticket;
	}

	public static double Total() {
		double bill = 0;

		if (bill < 30.00) {
			bill = Feeding() + Ticket() + Cover();
		} else {
			bill = Feeding() + Ticket();
		}

		return bill;
	}

}
