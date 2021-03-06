package game;

import java.io.*;
import java.util.Scanner;
 
public class Menu {
	private final String SPROGMENU_TXT = "/resourcer/sprogmenu.txt";
	private InputStream is = getClass().getResourceAsStream(SPROGMENU_TXT);
	private InputStreamReader isr = new InputStreamReader(is);
	private BufferedReader sprog = new BufferedReader(isr);
	private Scanner sc = new Scanner (System.in);
	private int menuvalg = 0;

	public Menu () { //Constructor.
	}

	public String lavMenu()throws IOException{//Throws IOException er krævet for at man kan håndtere fejl ved løsning af fil.

		String linje = "";

		try {
			int antal = Integer.parseInt(sprog.readLine());//Den første linje er antal sprog i menuen
			String[] menu = new String[antal];//Array der bliver dimensioneret med antal

			//Skriv menuen til konsollen
			for (int x=0;x<=antal-1;x=x+1) { //loop fra 0 til antal sprog i menu
				linje = sprog.readLine(); //L�s linje i menuen til variablen linje.
				if (linje == null){//Efter sidste sprog i menuen
					break; //break ud af loop
				}
				System.out.println((x+1) + ". "  + linje); //skriv eks. 1. English i console
				menu[x]=linje; //lig sproglinjen over i array
			}// loop

			System.out.print("Vælg: "); 
			while (menuvalg < 1 || menuvalg > antal) { //bliv ved med at vælge menu valg indtil der er indtastet et nummer på menuen
				menuvalg = sc.nextInt(); //modtag menuvalg
			}
			lukobjekter();
			return menu[menuvalg-1]; //returner det valgte sprog.

		}catch(IOException ex) {

			lukobjekter();
			System.out.println(ex);
			ex.printStackTrace();
			return "nothing";	
		}
	}
	
	private void lukobjekter() throws IOException{
		sc.close();
		is.close();
		isr.close();
		sprog.close();
	}
	
}
