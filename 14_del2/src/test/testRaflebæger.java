package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Raflebæger;

public class testRaflebæger {
	
	Raflebæger raflebæger = new Raflebæger();
	
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
	public void testRaflebæger() {
		fail("Not yet implemented");
	}

	@Test
	public void testRyst() {
		int[] statistik = new int[7];
		for(int n=1; n<600000; n=n+1) {
			raflebæger.ryst();
			int sum = raflebæger.hentTerning1værdi();
//			int sum1 = raflebæger.hentTerning2værdi();
			statistik[sum] = statistik[sum]+1;
		}
		for(int x=1; x<=6; x=x+1) {
			System.out.println(x+"ere = " + statistik[x]);
		}
	}

	@Test
	public void testHentTerning1værdi() {
		fail("Not yet implemented");
	}

	@Test
	public void testHentTerning2værdi() {
		fail("Not yet implemented");
	}

	@Test
	public void testHentSum() {
		fail("Not yet implemented");
	}

	@Test
	public void testSætSum() {
		fail("Not yet implemented");
	}

	@Test
	public void testHentAntalSider() {
		fail("Not yet implemented");
	}

	@Test
	public void testSætAntalsider() {
		fail("Not yet implemented");
	}

}
