package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Raflebæger;

public class RaflebægerTest {
	
	Raflebæger raflebæger = new Raflebæger(6);
	
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
		raflebæger.sætSum(5);
		int expected = 5;
		int actual = raflebæger.hentSum();
		assertEquals("objektet raflebæger blev ikke oprettet rigtigt", expected, actual);
	}

	@Test
	public void testRyst() {
		int[] statistik = new int[7];
		for(int n=1; n<600000; n=n+1) {
			raflebæger.ryst();
			int sum = raflebæger.hentTerning1værdi();
			statistik[sum] = statistik[sum]+1;
		}
		for(int x=1; x<=6; x=x+1) {
			System.out.println("terning1 " + x+"ere = " + statistik[x]);
		}
		
		
		int[] statistik1 = new int[7];
		for(int n=1; n<600000; n=n+1) {
			raflebæger.ryst();
			int sum1 = raflebæger.hentTerning2værdi();
			statistik1[sum1] = statistik1[sum1]+1;
		}
		for(int x=1; x<=6; x=x+1) {
			System.out.println("terning2 " + x+"ere = " + statistik1[x]); //
		}
		
		int[] statistik2 = new int[13]; //
		for(int n=1; n<600000; n=n+1) {
			raflebæger.ryst();
			int sum2 = raflebæger.hentSum();
			statistik2[sum2] = statistik2[sum2]+1;
		}
		for(int x=2; x<=13; x=x+1) {
			System.out.println("Sum af terning1 og terning2 " + x+"ere = " + statistik2[x]);
		}
	}
	
	@Test
	public void testHentTerning1værdi() {
		raflebæger.sætTerning1værdi(8);;
		int expected = 8;
		int actual = raflebæger.hentTerning1værdi();
		assertEquals("metoden hentTerning virker ikke", expected, actual);
	}

	@Test
	public void testHentTerning2værdi() {
		raflebæger.sætTerning2værdi(3);
		int expected = 3;
		int actual = raflebæger.hentTerning2værdi();
		assertEquals("metoden hentTerning2værdi virker ikke", expected, actual);
	}

	@Test
	public void testHentSum() {
		raflebæger.sætSum(8);
		int expected = 8;
		int actual = raflebæger.hentSum();
		assertEquals("metoden hentTerning virker ikke", expected, actual);
	}

	@Test
	public void testSætSum() {
		raflebæger.ryst();
		System.out.println("raflebægeret er rystet har fået sum: " + raflebæger.hentSum());
		raflebæger.sætSum(10);
		int expected = 10;
		int actual = raflebæger.hentSum();
		assertEquals("sætSum virker ikke efter hensigten", expected, actual);
	}

	@Test
	public void testHentAntalSider() {
		raflebæger.sætAntalsider(12);
		int expected = 12;
		int actual = raflebæger.hentAntalSider();
		assertEquals("HentAntalSider-metoden virker ikke", expected, actual);
	}

	@Test
	public void testSætAntalsider() {
		//System.out.println("Antal sider på terningerne er: " + raflebæger.hentAntalSider());
		raflebæger.sætAntalsider(20);
		int expected = 20;
		int actual = raflebæger.hentAntalSider();
		assertEquals("sætAntalsider virker ikke", expected, actual);
	}

}
