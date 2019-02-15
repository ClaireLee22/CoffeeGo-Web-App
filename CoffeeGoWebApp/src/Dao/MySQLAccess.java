package Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**This class is uesd to connect to MySQL database
 */
public abstract class MySQLAccess {
	private Connection connection = null;
	
    public Connection getConnection() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            String url = "jdbc:mysql://localhost:8889/CoffeeGoDB?useSSL=false";
            String username = "CoffeeGo";
            String password = "20181102";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        }
		return connection;
    }
}

