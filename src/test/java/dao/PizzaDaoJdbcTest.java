package dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.utils.connectionJdbc_Impl;
import entity.CategoriePizza;
import service.PizzaManage;
import test.Test_H2Database;

public class PizzaDaoJdbcTest {
	
	
public static final Logger LOG = LoggerFactory.getLogger(PizzaDaoJdbcTest.class);
	
	private connectionJdbc_Impl connectionJdbc_Impl =null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	
	
	private PizzaDaoJdbc pizzaDaoJdbc;
	private PizzaManage managePizza;
	private PizzaDAOImpl daoPizza;
	
	private Test_H2Database h2_Database;
	
	Connection con;
	
	
	
	@Before
	public void setupConnectionJdbc() throws ClassNotFoundException, SQLException{
		connectionJdbc_Impl = new connectionJdbc_Impl();
		con = connectionJdbc_Impl.connecterJDBC();
		
		statement = con.createStatement();
		
		
		managePizza = new PizzaManage();
		daoPizza = new PizzaDAOImpl();
		
		h2_Database = new Test_H2Database();
		h2_Database.createTables();
	}


	@Test
	public void testAddPizzaPizza() {
		pizzaDaoJdbc = new PizzaDaoJdbc();
		pizzaDaoJdbc.addPizza("FR", "Fr_Pizza", 19, CategoriePizza.FROMAGE);
		
		
		String codePizza = "";
		try {
			ResultSet rs = statement.getResultSet();
			codePizza = rs.getString(2);
			
		} catch (SQLException e) {
			LOG.info(e.getMessage());
			LOG.info(""+e.getStackTrace());
		}
		assertThat(codePizza).isEqualToIgnoringCase("FR");
}
}
