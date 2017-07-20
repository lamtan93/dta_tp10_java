package test;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Menu;

public class Test_Ihm {

	private final static Logger LOG = LoggerFactory.getLogger(Test_Ihm.class);

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	private Menu menu;

	@Before
	public void setup() {
		menu = new Menu();

	}

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

//	@Test
//	public void test_Menu_affichage() {
//		systemInMock.provideLines("1");
//
//		menu.afficher();
//
//		String logConsole = systemOutRule.getLog();
//
//		assertThat(logConsole).contains(" code   nom       prix   categ  0 PEP Peperoni 12.5 VIANDE"
//				+ "1 MAR Margherita 14.0 VEGETARIEN"
//				+ " 2 REI La Reine 11.5 VIANDE"
//				+ "3 FRO Les 4 fromages 12.0 FROMAGE"
//				+ "4 CAN La Cannibale 12.5 VIAND"
//				+ " 5 SAV Savoyarde 13.0 FROMAGE"
//				+ "6 ORI L'orientale 13.5 VIANDE"
//				+ "7 IND L'indienne 14.0 VEGETARIEN");
//
//	}

}
