package bus;

import java.sql.SQLException;
import java.util.Scanner;

public class BusApplication {

	public static void main(String[] args) {
		
		try {
			BusDAO busdao = new BusDAO();
			busdao.displayBusInfo();
			
			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);
			while(userOpt == 1) {
				System.out.println("Enter 1 to book \nEnter 2 to exit");
				userOpt = scanner.nextInt();
				if(userOpt==1) {
					Booking booking = new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingDAO = new BookingDAO();
						BookingDAO.addBooking(booking);
						System.out.println("Booking is confirmed");
					}
					else {
						System.out.println("Sorry, bus is full! \n Try another bus or date.");
					}
						
				}
			}
			scanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
