package test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PizzaDAOImpl;
import entity.CategoriePizza;
import entity.Pizza;
import exception.DeletePizzaException;
import service.PizzaManage;

public class TestApp {

	private static final Logger LOG = LoggerFactory.getLogger(TestApp.class);

	private PizzaManage managePizza;
	private PizzaDAOImpl daoPizza;
	private List<Pizza> listPizza;

	@Before
	public void setup() {
		managePizza = new PizzaManage();
		daoPizza = new PizzaDAOImpl();
		listPizza = daoPizza.getListPizza();

	}

	@Test
	public void test_displayPizza() {
		List<Pizza> listPizza = daoPizza.getListPizza();
		assertThat(listPizza.size()).isEqualTo(8);
	}

	@Test
	public void test_addPizza() {

		Pizza newPizza = new Pizza(daoPizza.getListPizza().size(), "FR", "FR", 15, CategoriePizza.VIANDE);
		daoPizza.addPizza(newPizza);

		assertThat(listPizza.size()).isEqualTo(9);
		assertThat(listPizza.get(8).getCode()).isEqualToIgnoringCase("FR");
		assertThat(listPizza.get(8).getNom()).isEqualToIgnoringCase("FR");
		assertThat(listPizza.get(8).getPrix()).isEqualTo(15);
		assertThat(listPizza.get(8).getCategoriePizza()).isEqualTo(CategoriePizza.VIANDE);

	}

	@Test
	public void test_updatePizza() {

		// (7, "IND", "L'indienne", 14.00, CategoriePizza.VEGETARIEN);

		// Check before update
		assertThat(listPizza.size()).isEqualTo(8);
		assertThat(listPizza.get(7).getCode()).isEqualToIgnoringCase("IND");
		assertThat(listPizza.get(7).getNom()).isEqualToIgnoringCase("L'indienne");
		assertThat(listPizza.get(7).getPrix()).isEqualTo(14.00);
		assertThat(listPizza.get(7).getCategoriePizza()).isEqualTo(CategoriePizza.VEGETARIEN);

		// Update
		daoPizza.updatePizza(7, "VN", "Vn", 15, CategoriePizza.FROMAGE);

		// Check after update
		assertThat(listPizza.size()).isEqualTo(8);
		assertThat(listPizza.get(7).getCode()).isEqualToIgnoringCase("Vn");
		assertThat(listPizza.get(7).getNom()).isEqualToIgnoringCase("Vn");
		assertThat(listPizza.get(7).getPrix()).isEqualTo(15);
		assertThat(listPizza.get(7).getCategoriePizza()).isEqualTo(CategoriePizza.FROMAGE);


	}

	@Test
	public void test_deletPIzza() {
		// (7, "IND", "L'indienne", 14.00, CategoriePizza.VEGETARIEN);

		// Check before delete - size = 8
		assertThat(listPizza.size()).isEqualTo(8);
		assertThat(listPizza.get(7).getCode()).isEqualToIgnoringCase("IND");
		assertThat(listPizza.get(7).getNom()).isEqualToIgnoringCase("L'indienne");
		assertThat(listPizza.get(7).getPrix()).isEqualTo(14.00);
		assertThat(listPizza.get(7).getCategoriePizza()).isEqualTo(CategoriePizza.VEGETARIEN);

		try {
			daoPizza.deletePizza(6);
		} catch (DeletePizzaException e) {
			LOG.info(e.getMessage());
		}

		// after delete size = 7
		assertThat(listPizza.size()).isEqualTo(7);
	}

}
