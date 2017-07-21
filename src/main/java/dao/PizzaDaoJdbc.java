package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.CategoriePizza;
import entity.Pizza;
import exception.DeletePizzaException;
import exception.SavePizzaException;
import test.Test_H2Database;

public class PizzaDaoJdbc implements PizzaDAO {
	
	
public static final Logger LOG = LoggerFactory.getLogger(Test_H2Database.class);
	

	@Override
	public void displayAllPizza() {}

	@Override
	public void addPizza(Pizza pizza) {}

	@Override
	public void addPizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		String sql = "INSERT INTO Pizza VALUES (index, code, nom, pix, categorie) VALUES (?,?,?,?,?)";
		
		
		try {
			Connection con = null;
			
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, code);
			preparedStatement.setString(3, nom);
			preparedStatement.setDouble(4, prix);
			preparedStatement.setObject(5, categoriePizza);

			int nbr = preparedStatement.executeUpdate();
			LOG.info(""+nbr);
		} catch (SQLException | ClassNotFoundException e) {
			throw new SavePizzaException(e);

		}

	}

	@Override
	public void updatePizza(int index, String code, String nom, double prix, CategoriePizza categoriePizza) {
	

	}

	@Override
	public void deletePizza(int indexPizza) throws DeletePizzaException {
		

	}

}
