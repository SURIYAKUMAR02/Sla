package dbblood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbblood {
	public static Connection initializeDatabase() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbblood","root","6121997");
		return con;
	}
}
