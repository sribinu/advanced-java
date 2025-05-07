package bus;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter passenger name : ");
		passengerName = scanner.next();
		System.out.println("Enter bus no : ");
		busNo = scanner.nextInt();
		System.out.println("Enter date (dd-mm-yyyy) : ");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isAvailable() throws SQLException{
		
		BusDAO busDao = new BusDAO();
		BookingDAO bookingDAO = new BookingDAO();
		int capacity = busDao.getCapacity(busNo);
		
		int booked = bookingDAO.getBookedCount(busNo, date);
		
		return booked < capacity;
	}
	
}
