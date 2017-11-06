import java.io.IOException;
import java.util.Scanner;
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
	private Spil thegame = new Spil();
	private String[] spillerbesked = new String[12];
	
	public static void main (String[] args) throws IOException{
		new Spil().spil();
		
	}


	private void spil() {
		// Lav et spil objekt at spille med
				initialiserSpil();
				
				//Alternering mellem spillere og konsekvens hvis vundet eller tabt
				while (thegame.spilvundet != true && thegame.spiltabt != true) {
					for (int spillernr = 0 ; spillernr <= 1 ; spillernr=spillernr+1) {
						thegame.sekvens(spillere[spillernr], spiltekst);
						//Check for om spil er vundet eller tabt og generer beskeder til spilleren.
						if (thegame.spilvundet == true) {
							System.out.println(spillere[spillernr].hentNavn() + ". " + spiltekst[3] + " " + spillere[spillernr].hentKonto().hentVærdi() + " " + spiltekst[6] );
							break;
						}
						if (thegame.spiltabt == true) {
							System.out.println(spillere[spillernr].hentNavn() + ". " + spiltekst[2]);
							break;
						}
					}
				}
				GUI.close();
		
	}


	public void sekvens(Spiller spiller, String[] spiltekst) { //spiller objekt og spiltekst array
		for (int x=0;x<=11;x= x + 1) {
			System.out.println(spillerbesked[x]);
		}
		
		do {
			//Spiller interaktion
			GUI.getUserButtonPressed(spiltekst[4] + " " + spiller.hentNavn() + ". "+ spiltekst[5], spiltekst[7]);
			GUI.removeAllCars(spiller.hentNavn());

			//Ryst bøger og sæt terninger og bil i GUI
			raflebæger.ryst();//Ryst bøgeret
			GUI.setDice(raflebæger.hentGemteØjne(0),raflebøger.hentGemteØjne(1));//sæt terninger på spillebræt
			GUI.setCar(raflebæger.hentSum(), spiller.hentNavn());//Sæt bilen på spillerbrættet
			System.out.println(spillerbesked[raflebæger.hentSum()-2]);
			GUI.showMessage(spillerbesked[raflebæger.hentSum()-2]);

			//Find den rigtige regel og konsekvens
			regler.felt(raflebæger.hentSum());//s�t reglen i regler

			//Hvis spiller før under 0 med aktuelt felts point
			if (spiller.hentKonto().checkMinus(regler.hentPoint())){
				this.spiltabt = true;
				GUI.close();
				break;
			}

			//Hvis der ikke er noget problem kan man lige så godt søtte guldet ind på kontoen
			String resultat = spiller.hentKonto().indsæt(regler.hentPoint()); //tilføj point til spiller konto
			GUI.setBalance(spiller.hentNavn(), spiller.hentKonto().hentVærdi()); //set spillebræt balance

			//Hvis spiller har over 3000 guld
			if (spiller.hentKonto().hentVærdi() > 3000) {
				this.spilvundet = true;
				GUI.close();
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
		//det valgte sprog s� vi kan skifte
		//sprog p� felterne
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
		GUI.addPlayer(spillere[0].hentNavn(), spillere[0].hentKonto().hentVærdi());//Opret spillere med navn og guld
		GUI.addPlayer(spillere[1].hentNavn(), spillere[0].hentKonto().hentVærdi());//Opret spillere med navn og guld
	}
}
