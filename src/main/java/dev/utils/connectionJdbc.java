package dev.utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface connectionJdbc {

	public Connection connecterJDBC () throws ClassNotFoundException, SQLException;
		
}
