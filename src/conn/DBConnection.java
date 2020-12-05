package conn;

import java.sql.*;
public class DBConnection {
	public static Connection getConnection()
			throws SQLException, ClassNotFoundException
	{
		return SQLServerConnection.initializeDatabase();
		
	}
}
