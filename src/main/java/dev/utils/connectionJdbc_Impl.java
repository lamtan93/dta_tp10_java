package dev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionJdbc_Impl implements connectionJdbc{

	@Override
	public Connection connecterJDBC() throws ClassNotFoundException, SQLException {
			Connection con = null;
			Class.forName("org.h2.Driver");	
			con = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1","sa","");	
			return con;
		
	}

}
