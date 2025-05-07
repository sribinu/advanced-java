package bus;

import java.sql.*;
import java.sql.SQLException;

// Data Access Object
public class BusDAO {

	public void displayBusInfo() throws SQLException {
		String query = "SELECT * FROM bus";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus No : " + rs.getInt(1));
			if(rs.getBoolean(2))
				System.out.println("AC : YES");
			else
				System.out.println("AC : NO");
			System.out.println("Capacity : " + rs.getInt(3));
			System.out.println("--------------------------");
		}
	}

	public int getCapacity(int busNo) throws SQLException {
		String query = "SELECT capacity FROM bus WHERE id ="+busNo;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next(); // first cursor points the top most header, so give next() to move the cursor to the value
		return rs.getInt(1);
	}
	
}
