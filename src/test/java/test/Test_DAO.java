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

public class Test_DAO {

	private static final Logger LOG = LoggerFactory.getLogger(Test_DAO.class);

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

		assertThat(listPizza.get(listPizza.size() - 1).getCode()).isEqualToIgnoringCase("FR");
		assertThat(listPizza.get(listPizza.size() - 1).getNom()).isEqualToIgnoringCase("FR");
		assertThat(listPizza.get(listPizza.size() - 1).getPrix()).isEqualTo(15);
		assertThat(listPizza.get(listPizza.size() - 1).getCategoriePizza()).isEqualTo(CategoriePizza.VIANDE);

	}

	@Test
	public void test_updatePizza() {

		int indexPizzaCourant;
		String codePizzaCourant;
		String nomPizzaPizzaCourant;
		double prixPizzaCourant;
		CategoriePizza categPizzaCourant;

		int sizePizza = listPizza.size();

		// Check the list not null
		assertThat(sizePizza).isNotEqualTo(0);

		codePizzaCourant = listPizza.get(1).getCode();
		nomPizzaPizzaCourant = listPizza.get(1).getNom();
		prixPizzaCourant = listPizza.get(1).getPrix();
		categPizzaCourant = listPizza.get(1).getCategoriePizza();

		// Update
		daoPizza.updatePizza(1, "VN", "Vn", 15, CategoriePizza.FROMAGE);

		// Check after update if data is changed
		assertThat(listPizza.size()).isEqualTo(sizePizza);
		assertThat(listPizza.get(1).getCode()).isNotEqualToIgnoringCase(codePizzaCourant);
		assertThat(listPizza.get(1).getNom()).isNotEqualToIgnoringCase(nomPizzaPizzaCourant);
		assertThat(listPizza.get(1).getPrix()).isNotEqualTo(prixPizzaCourant);
		assertThat(listPizza.get(1).getCategoriePizza()).isNotEqualTo(categPizzaCourant);

		// Check if it's updated with correct infos
		assertThat(listPizza.size()).isEqualTo(sizePizza);
		assertThat(listPizza.get(1).getCode()).isEqualToIgnoringCase("Vn");
		assertThat(listPizza.get(1).getNom()).isEqualToIgnoringCase("Vn");
		assertThat(listPizza.get(1).getPrix()).isEqualTo(15);
		assertThat(listPizza.get(1).getCategoriePizza()).isEqualTo(CategoriePizza.FROMAGE);

	}

	@Test
	public void test_deletePizza() {

		int sizePizza = listPizza.size();

		// Check the list not null
		assertThat(sizePizza).isNotEqualTo(0);

		try {
			daoPizza.deletePizza(6);
		} catch (DeletePizzaException e) {
			LOG.info(e.getMessage());
		}

		// after delete size = size - 1;
		assertThat(listPizza.size()).isNotEqualTo(sizePizza);
	}

}
