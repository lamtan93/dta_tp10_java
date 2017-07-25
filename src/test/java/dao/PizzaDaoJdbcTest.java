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

import dev.dao.PizzaDAOImpl;
import dev.dao.PizzaDaoJdbc;
import dev.entity.CategoriePizza;
import dev.utils.connectionJdbc_Impl;
import service.PizzaManage;
import test.Test_H2Database;

public class PizzaDaoJdbcTest {

	public static final Logger LOG = LoggerFactory.getLogger(PizzaDaoJdbcTest.class);

	private connectionJdbc_Impl connectionJdbc_Impl = null;
	PreparedStatement preparedStatement = null;
	Statement statement = null;

	private PizzaDaoJdbc pizzaDaoJdbc;
	private PizzaManage managePizza;
	private PizzaDAOImpl daoPizza;

	private Test_H2Database h2_Database;

	Connection con;

	@Before
	public void setupConnectionJdbc() throws ClassNotFoundException, SQLException {
		connectionJdbc_Impl = new connectionJdbc_Impl();
		con = connectionJdbc_Impl.connecterJDBC();

		statement = con.createStatement();

		daoPizza = new PizzaDAOImpl();
		managePizza = new PizzaManage(daoPizza);
		

		h2_Database = new Test_H2Database();
		h2_Database.setupConnectionJdbc();
		h2_Database.createTables();
	}

	@Test
	public void testAddPizzaPizza() throws SQLException, ClassNotFoundException {
		pizzaDaoJdbc = new PizzaDaoJdbc();
		pizzaDaoJdbc.addPizza("FR", "Fr_Pizza", 19, CategoriePizza.FROMAGE);

		String codePizza = "";

		ResultSet rs = statement.executeQuery("select * from Pizza");

		while (rs.next()) {
			codePizza = rs.getString(2);
		}

		assertThat(codePizza).isEqualToIgnoringCase("FR");
	}
	
//	@Test
//	public void testUpdatePizza() throws ClassNotFoundException, SQLException{
//		pizzaDaoJdbc = new PizzaDaoJdbc();
//
//		String sql = "SELECT * from Pizza";
//		ResultSet res = statement.executeQuery(sql);
//		String nomPizza = "";
//		while(res.next()){
//			if(res.getInt("index")== 1){
//				pizzaDaoJdbc.updatePizza(1, "ITL", "Italie_Pizza", 19, CategoriePizza.FROMAGE);
//				nomPizza = res.getString(3);
//			}
//		}
//		assertThat(nomPizza).isEqualToIgnoringCase("Italie_Pizza");
//		
//		
//	}
	
}
