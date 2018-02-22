import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlDatabaseConnection() 
{
	public String driver = "com.mysql.jdbc.Driver";
	public String database = "recommendersystemdb";
	public String hostname = "localhost";
	public String port = "3306";
	public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
	public String username = "hduser";
	public String password = "123";
	
	public Connection conectarMySQL() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "SQLException:\n" + e, "Error: ConexionMySQL()", JOptionPane.ERROR_MESSAGE);
		}
		
		return conn;
	}
}