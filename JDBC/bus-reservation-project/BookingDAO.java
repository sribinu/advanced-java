package bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {

	public int getBookedCount(int busNo, Date date) throws SQLException {
		String query = "SELECT COUNT(passenger_name) FROM booking WHERE bus_no = ? AND travel_date = ?";
		Connection con = DbConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, busNo);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); // util.Date to sql.Date
		ps.setDate(2, sqlDate);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public static void addBooking(Booking booking) throws SQLException {
		String query = "INSERT INTO booking VALUES(?,?,?)";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime()); 
		pst.setDate(3, sqlDate);
		
		pst.executeUpdate();
	}
	
}
