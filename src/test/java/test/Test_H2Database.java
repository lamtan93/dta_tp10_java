package test;

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

import dao.PizzaDAOImpl;
import dev.utils.connectionJdbc_Impl;
import service.PizzaManage;

public class Test_H2Database {

	public static final Logger LOG = LoggerFactory.getLogger(Test_H2Database.class);
	
	private connectionJdbc_Impl connectionJdbc_Impl =null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;
	private PizzaManage managePizza;
	private PizzaDAOImpl daoPizza;
	
	
	Connection con;
	
	@Before
	public void setupConnectionJdbc() throws ClassNotFoundException, SQLException{
		connectionJdbc_Impl = new connectionJdbc_Impl();
		con = connectionJdbc_Impl.connecterJDBC();
		
		statement = con.createStatement();
		
		managePizza = new PizzaManage();
		daoPizza = new PizzaDAOImpl();
		
		
		createTables();
		insertDataForTablePizza();
		
		
	}
	
	public void createTables() throws ClassNotFoundException{
		
		
		String sql = "CREATE TABLE Pizza ("
				+"index INT, "
				+"code VARCHAR (3) NULL, "
				+"nom VARCHAR (100) NULL, "
				+"prix DOUBLE NULL, "
				+"categorie VARCHAR (10) NULL )";
			
		
		try {
		
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOG.info(e.getSQLState());
			
		}
  
	}
	
	public void insertDataForTablePizza(){
		
		//String sql = "INSERT INTO Pizza (index, code, nom, prix, categorie ) VALUES (?, ?, ?, ?, ?)";
		String sql = "INSERT INTO Pizza VALUES "
				+ "(1,'PEP','Peperoni', '12.50', 'Viande'),"
				+ "(2,'MAR','Margherita', '14.00', 'Viande'),"
				+ "(3,'REI','La Reine', '11.50', 'Viande'),"
				+ "(4,'PEP','La Cannibale', '12.50', 'Viande'),"
				+ "(5,'CAN','La Cannibale', '12.50', 'Viande'),"
				+ "(6,'SAV','Savoyarde', '13.00', 'Viande'),";
				
		try {
			
			int nbr = statement.executeUpdate(sql);
			LOG.info("nbr: ", + nbr);
		} catch (SQLException e) {
			LOG.info(e.getMessage());
		}
		
	}
	
	@Test
	public void test_Select_H2() throws SQLException{
		
		String sql = "Select * from Pizza";
		
		ResultSet resultats = statement.executeQuery(sql);
		String codePizza = "";
			
		while(resultats.next()){
			LOG.info(resultats.getString(2));
			codePizza = resultats.getString(2);
		}
		
		
		assertThat(codePizza).isEqualToIgnoringCase("SAV");
		
	}
	
	
}
