package game;
import java.awt.Color;
import java.io.*;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_resources.GUI;

public class Spil {

	private Spiller[] spillere = new Spiller[2];
	private boolean spilvundet = false;
	private boolean spiltabt = false;
	private Raflebæger raflebæger = new Raflebæger(6);
	private Regler regler = new Regler();
	private String valgtsprog = "";
	private Field [] felter = new Field[12];
	private String[] spiltekst = new String[10];//Der gøres plads til 10 spilbeskeder.
	private String[] spillerbesked = new String[12];

	public static void main (String[] args) throws IOException{
		Spil game = new Spil();
		game.spil();// spil
	}

	private void spil() throws IOException {

		initialiserSpil();

		//Alternering mellem spillere og konsekvens hvis vundet eller tabt
		while (spilvundet != true && spiltabt != true) {
			for (int spillernr = 0 ; spillernr <= 1 ; spillernr=spillernr+1) {
				sekvens(spillere[spillernr], spiltekst);

				//Check for om spil er vundet eller tabt og generer beskeder til spilleren.
				if (spilvundet == true) {
					GUI.showMessage(spillere[spillernr].hentNavn() + ". " + spiltekst[3] + " " + spillere[spillernr].hentKonto().hentVærdi() + " " + spiltekst[6] );
					break;
				}
				if (spiltabt == true) {
					GUI.showMessage(spillere[spillernr].hentNavn() + ". " + spiltekst[2]);
					break;
				}
			}
		}
		GUI.close();
	}

	public void sekvens(Spiller spiller, String[] spiltekst) { //spiller objekt og spiltekst array
		do {
			//Spiller interaktion
			GUI.getUserButtonPressed(spiltekst[4] + " " + spiller.hentNavn() + ". "+ spiltekst[5], spiltekst[7]);
			GUI.removeAllCars(spiller.hentNavn());

			//Ryst bæger og sæt terninger og bil i GUI
			raflebæger.ryst();//Ryst bægeret

			GUI.setDice(raflebæger.hentTerning1værdi(),3,3,raflebæger.hentTerning2værdi(),4,4);//sæt terninger på spillebræt
			GUI.setCar(raflebæger.hentSum(), spiller.hentNavn());//Sæt bilen på spillerbrættet.
			//			System.out.println(spillerbesked[raflebæger.hentSum()-2]);//DEBUG KODE PROBLEM MED NULL værdi.
			GUI.showMessage(spillerbesked[raflebæger.hentSum()-1]);//skriver beskeder til GUI.

			//Find den rigtige regel og konsekvens
			regler.felt(raflebæger.hentSum());//sæt reglen i regler

			//Hvis spiller får under 0 med aktuelt felts point
			if (spiller.hentKonto().checkMinus(regler.hentVærdi())==true){
				this.spiltabt = true;
				break;
			}

			//Hvis der ikke er noget problem kan man lige så godt søtte guldet ind på kontoen
			String resultat = spiller.hentKonto().indsæt(regler.hentVærdi()); //tilføj point til spiller konto
			GUI.setBalance(spiller.hentNavn(), spiller.hentKonto().hentVærdi()); //set spillebræt balance

			//Hvis spiller har over 3000 guld
			if (spiller.hentKonto().hentVærdi() > 3000) {
				this.spilvundet = true;
				break;
			}	
		}
		while (regler.hentEkstraTur()==true);//Sålænge ekstratur er sat til true
	}

	private void initialiserSpil() throws IOException{
		//Lav menu og hent sprog
		Menu menu = new Menu();// Lav et menuobjekt 
		valgtsprog = menu.lavMenu();//brug menuobjekt til at vælge sprog og returnere en sprogstreng

		//Skift til nyt sprog på baggrund af valgt menupunkt.
		//Lav et skiftsprog objekt med
		//det valgte sprog så vi kan skifte
		//sprog på felterne
		Sprog skiftsprog = new Sprog(valgtsprog);	

		skiftsprog.skiftfelter(); //skift sprog p� felterne
		felter = skiftsprog.hentFieldsOversat();// hent de oversatte felter
		spiltekst = skiftsprog.hentSpiltekst();// hent de oversatte spiltekster
		spillerbesked = skiftsprog.hentSpillerBesked();

		//Opret spillerobjekter med spillernavne fra sprogfilerne.
		spillere[0]= new Spiller(spiltekst[0]);
		spillere[1]= new Spiller(spiltekst[1]);

		//Opret spilleplade med spillere og startbeløb.
		GUI.create(felter); //Lav spillebræt og felter
		Car car = new Car.Builder()
				.primaryColor(Color.MAGENTA)
				.secondaryColor(Color.BLUE)
				.typeTractor()
				.patternDotted()
				.build();

		Car car2 = new Car.Builder()
				.primaryColor(Color.cyan)
				.secondaryColor(Color.green)
				.typeTractor()
				.patternDotted()
				.build();
	
		GUI.addPlayer(spillere[0].hentNavn(), spillere[0].hentKonto().hentVærdi(),car);//Opret spillere med navn og guld
		GUI.addPlayer(spillere[1].hentNavn(), spillere[0].hentKonto().hentVærdi(),car2);//Opret spillere med navn og guld
		

	}
}
