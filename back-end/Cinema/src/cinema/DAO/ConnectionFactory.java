package cinema.DAO;

import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost")
		}
		catch{
			
		}
	}
}
