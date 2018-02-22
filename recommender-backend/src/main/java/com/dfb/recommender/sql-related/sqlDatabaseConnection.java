import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlDatabaseConnection() 
{
	public Connection OpenConnectionToMySQL() {
		
		public String driver = "com.mysql.jdbc.Driver";
		public String database = "recommendersystemdb";
		public String hostname = "localhost";
		public String port = "3306";
		public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
		public String username = "hduser";
		public String password = "123";
		
		Connection c = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "SQLException" + e, "Couldn't connect to database", JOptionPane.ERROR_MESSAGE);
		}
		
		return c;
	}
}