package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
	public static Connection initializeDatabase()
			throws SQLException, ClassNotFoundException
	{
		// Initialize all the information regarding
		// Database Connection
	
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://localhost:1433";
		// Database name to access
		String dbName = "shop";
		String dbUsername="tv";
		String dbPassword = "1";
		String connectionURL = dbURL + ";databaseName=" + dbName;
		Connection conn = null;
		try {
			Class.forName(dbDriver);
			conn =  DriverManager.getConnection(connectionURL, dbUsername, dbPassword);		
			System.out.println("connect successfully");
		} 
		catch (Exception ex) 
		{
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}
