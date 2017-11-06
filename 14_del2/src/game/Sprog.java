package game;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class Sprog{

	private Field[] fieldsoversat = new Field[12];
	private	String valgtsprog = "";
	private String filstinavn = "";
	private String[] spiltekst = new String[10];
	private String[] spillerbesked = new String[12];

	public Sprog (String valgtsprog) {
		this.valgtsprog = valgtsprog;
	}

	public void skiftfelter() throws IOException{
		
		//Indl�s tekst fra valgt sprogfil i felter i GUI.
		String linje1 = "";
		String linje2 = "";
		String linje3 = "";
		try {
			this.filstinavn = "resourcer/"+ this.valgtsprog + ".txt";
			System.out.println(this.filstinavn);
		} catch (Exception e) {
			System.out.println(e + "  Der er problemer med at l�se filen");
		}
		InputStream resourceAsStream = Sprog.class.getResourceAsStream(this.filstinavn);
		BufferedReader ind = new BufferedReader(new InputStreamReader(resourceAsStream));
		for (int x=0;x<=11;x=x+1) { // der er 12 felter startende fra 0 i objektet fields[]

			linje1 = læsLinje(ind);//L�s linje 1
			if (linje1 != null) { // Hvis det ikke er en tom linje	
				linje2 = læsLinje(ind); //L�s linje2 
				linje3 = læsLinje(ind); //L�s linje3

				//Indsæt de 3 indl�ste linjer i objektet.
				this.fieldsoversat[x] = new Street.Builder()
						.setTitle(linje1)
						.setBgColor(Color.green)
						.setDescription(linje2)
						.setSubText(linje3)
						.build();
				System.out.println(linje2);
				spillerbesked[x] = spillerbesked[x] + linje2;
				spillerbesked[x] = spillerbesked[x] + '\n';
				spillerbesked[x] = spillerbesked[x] + linje3;
				
			}	
		}
		
		//Indløs spiltekst
		for (int x=0;x<=9;x=x+1) {//Indløs spiltekst
			linje1 = læsLinje(ind);//Læs linje 1
			if (linje1 != null) { // Hvis det ikke er en tom linje	
				this.spiltekst[x] = linje1;
			}else {
				break;
			}
		}
	}

	private static String læsLinje(BufferedReader ind) throws IOException {//Hjælpe methode der løser en linje og springer over ved //
		String linje = "";
		{
			try {
				do {
					linje = ind.readLine(); //L�s linje2 
					if (linje == null) {
						return linje;
					}
				}
				while (linje.charAt(0) == '/' && linje.charAt(1) == '/'); // hvis der står // i starten af linjen så hent næste linje			
			} catch (Exception e) {
				System.out.println("Der er problemer med at indl�se en linje fra Sprogfilen " + e);
			}
		}

		return linje;
	}

	public String[] hentSpiltekst() {
		return this.spiltekst;
	}

	public Field[] hentFieldsOversat() {
		return fieldsoversat;
	}


	public void sætFieldsOversat(Field[] fieldsoversat) {
		this.fieldsoversat = fieldsoversat;
	}
	
	public String[] hentSpillerBesked() {
		return this.spillerbesked;
	}
}
