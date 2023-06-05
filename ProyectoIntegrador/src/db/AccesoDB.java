package db;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class AccesoDB {
	
	private String url;
	private String driver;
	
	public AccesoDB() {
		
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			
			is = new FileInputStream("db/ConfigDB.properties");
			prop.load(is);
			
			url = prop.getProperty("URL");
			driver = prop.getProperty("DRIVER");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(is != null) {
					is.close();
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}
	}
	
	public Connection getConexion() throws ClassNotFoundException, SQLException{
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url);
		
		return con;
		
	}
	
}
