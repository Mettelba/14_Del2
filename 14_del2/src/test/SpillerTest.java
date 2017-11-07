package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Spiller;

public class SpillerTest {
	Spiller spiller = new Spiller("Rasmus");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSpiller() {
		
		Spiller spiller2 = new Spiller("Rasmus");
		String expected = "Rasmus";
		String actual = spiller2.hentNavn();
		assertEquals("navet macther ikke", expected, actual);
		
		
	}

	@Test
	public void testHentNavn() {
		String expected = "Rasmus";	
		String actual = spiller.hentNavn();
		assertEquals("navnet matcher ikke  ",expected, actual);
	}

	@Test
	public void testSætNavn() {
		spiller.sætNavn("Kurt");
		String expected = "Kurt";
		String actual = spiller.hentNavn();
		assertEquals("navnet matcher ikke  ",expected, actual);
		
		
		
	}
	
	@Test
	public void testPlayerKonto() {//Tester at jeg kan tilgå kontobjektet gennem playerobjektet.
		
		//opsat spiller objekter
		Spiller player1 = new Spiller("Hans");
		Spiller player2 = new Spiller("Petra");
		player1.hentKonto().sætVærdi(1000);
		player2.hentKonto().sætVærdi(1000);
		
		//test starter
		player1.hentKonto().indsæt(-100);
		int expected = 900;
		int actual = player1.hentKonto().hentVærdi();
		assertEquals("Det virkede ikke at indsætte et minus beløb", expected, actual);
		
		player1.hentKonto().sætVærdi(1000);
		player1.hentKonto().indsæt(100);
		expected = 1100;
		actual = player1.hentKonto().hentVærdi();
		assertEquals("Det virkede ikke at indsætte beløb", expected, actual);
		
		player1.hentKonto().sætVærdi(1000);
		player1.hentKonto().hæv(100);
		expected = 900;
		actual = player1.hentKonto().hentVærdi();
		assertEquals("Det virkede ikke at hæve beløb", expected, actual);
		
		player1.hentKonto().sætVærdi(1000);
		player1.hentKonto().hæv(200);
		player2.hentKonto().hæv(300);
		assertNotEquals("Kontoerne for de to spillere virker som om den er det samme objekt", player1.hentKonto().hentVærdi(), player2.hentKonto().hentVærdi());	

	}
}
