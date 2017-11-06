package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Regler;

public class ReglerTest {
	Regler regler = new Regler();
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		regler.sætpoint(1000);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegler() {
		Regler regler = new Regler();
		regler.hentEkstraTur();
		boolean expected = false;
		boolean actual = regler.hentEkstraTur();
		assertEquals("dette passer ikke", expected, actual);
		
	}

	@Test
	public void testHentPoint() {
		int expected = 1000;
		int actual = regler.hentPoint();
		assertEquals(expected, actual);
		
	}

	@Test
	public void testSætpoint() {
		regler.sætpoint(100);
		int expected = 100;
		int actual = regler.hentPoint();
		assertEquals(expected, actual);
	}

	@Test
	public void testHentEkstraTur() {
		boolean ekstra = regler.hentEkstraTur();
		boolean expected = false ;
		boolean actual = ekstra;
		assertEquals("dette passer ikke", expected, actual);
				
	}

	@Test
	public void testSætEkstraTur() {
		regler.sætEkstraTur(true);
		boolean expected = true;
		boolean actual = regler.hentEkstraTur();
		assertEquals("det passer ikke", expected, actual);
				
	}

	@Test
	public void testReglesæt() {
		regler.felt(2);
		int expected = 250;
		int actual = regler.hentPoint();
		assertEquals(expected, actual);
			
		boolean expected2 = false;
		boolean actual2 = regler.hentEkstraTur();
		assertEquals("dette passer ikke", expected2, actual2);
		
		regler.felt(3);
		int expected3 = -100;
		int actual3 = regler.hentPoint();
		assertEquals(expected3, actual3);
		
		boolean expected4 = false;
		boolean actual4 = regler.hentEkstraTur();
		assertEquals(expected4, actual4);
		
		regler.felt(4);
		int expected5 = 100;
		int actual5 = regler.hentPoint();
		assertEquals(expected5, actual5);
		
		boolean expected6 = false;
		boolean actual6 = regler.hentEkstraTur();
		assertEquals(expected6, actual6);
		
		regler.felt(5);
		int expected7 = -20;
		int actual7 = regler.hentPoint();
		assertEquals(expected7, actual7);
		
		regler.felt(6);
		int expected8 = 180;
		int actual8 = regler.hentPoint();
		assertEquals(expected8, actual8);
		
		boolean expected9 = false;
		boolean actual9 = regler.hentEkstraTur();
		assertEquals(expected9, actual9);
		
		regler.felt(7);
		int expected10 = 0;
		int actual10 = regler.hentPoint();
		assertEquals(expected10, actual10);
		
		boolean expected11 = false;
		boolean actual11 = regler.hentEkstraTur();
		assertEquals(expected11, actual11);
		
		regler.felt(8);
		int expected12 = -70;
		int actual12 = regler.hentPoint();
		assertEquals(expected12, actual12);
		
		boolean expected13 = false;
		boolean actual13 = regler.hentEkstraTur();
		assertEquals(expected13, actual13);
		
		regler.felt(9);
		int expected14 = 60;
		int actual14 = regler.hentPoint();
		assertEquals(expected14, actual14);
		
		boolean expected15 = false;
		boolean actual15 = regler.hentEkstraTur();
		assertEquals(expected15, actual15);
		
		regler.felt(10);
		int expected16 = -80;
		int actual16 = regler.hentPoint();
		assertEquals(expected16, actual16);
		
		boolean expected17 = true;
		boolean actual17 = regler.hentEkstraTur();
		assertEquals(expected17, actual17);
		
		regler.felt(11);
		int expected18 = -50;
		int actual18 = regler.hentPoint();
		assertEquals(expected18, actual18);
		
		boolean expected19 = false;
		boolean actual19 = regler.hentEkstraTur();
		assertEquals(expected19, actual19);
		
		regler.felt(12);
		int expected20 = 650;
		int actual20 = regler.hentPoint();
		assertEquals(expected20, actual20);
		
		boolean expected21 = false;
		boolean actual21 = regler.hentEkstraTur();
		assertEquals(expected21, actual21);
		
		
	
	}

}
