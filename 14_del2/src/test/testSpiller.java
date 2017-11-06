package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Spiller;

public class testSpiller {
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
		
		Spiller spiller = new Spiller("Rasmus");
		String expected = "Rasmus";
		String actual = spiller.hentNavn();
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

}
