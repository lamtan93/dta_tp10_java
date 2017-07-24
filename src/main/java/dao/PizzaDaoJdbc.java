package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.utils.connectionJdbc_Impl;
import entity.CategoriePizza;
import entity.Pizza;
import exception.DeletePizzaException;
import exception.SavePizzaException;
import exception.UpdatePizzaException;
import test.Test_H2Database;

public class PizzaDaoJdbc implements PizzaDAO {
	
	
public static final Logger LOG = LoggerFactory.getLogger(Test_H2Database.class);
	
private connectionJdbc_Impl connectionJdbc_Impl;
Connection con;
PreparedStatement psttm;

 public PizzaDaoJdbc() throws ClassNotFoundException, SQLException {
	connectionJdbc_Impl = new connectionJdbc_Impl();
	con = connectionJdbc_Impl.connecterJDBC();
	
}

	@Override
	public void displayAllPizza() {}

	@Override
	public void addPizza(Pizza pizza) {}

	@Override
	public void addPizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		String sql = "INSERT INTO Pizza (index, code, nom, prix, categorie) VALUES (?,?,?,?,?)";
		
		
		try {
			psttm = con.prepareStatement(sql);
			
			
			psttm.setInt(1, 1);
			psttm.setString(2, code);
			psttm.setString(3, nom);
			psttm.setDouble(4, prix);
			psttm.setObject(5, categoriePizza.getLibelle());

			int nbr = psttm.executeUpdate();
			LOG.info(""+nbr);
		} catch (SQLException e) {
			throw new SavePizzaException(e);

		}

	}

	@Override
	public void updatePizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza)  {
		String sql = "UPDATE Pizza SET index = ?, code = ?, nom = ?, prix = ?, categorie = ?";
		try {
			psttm = con.prepareStatement(sql);
			
			psttm.setInt(1, 1);
			psttm.setString(2, code);
			psttm.setString(3, nom);
			psttm.setDouble(4, prix);
			psttm.setObject(5, categoriePizza.getLibelle());
			
			
			psttm.executeUpdate();
		} catch (SQLException e) {
			throw new UpdatePizzaException(e);
			
		}

	}

	@Override
	public void deletePizza(int indexPizza) throws DeletePizzaException {
		

	}

}
