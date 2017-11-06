
public class Konto {

	private int værdi;
	private String[] spiltekst = new Spiltekst[10]
	
	public Konto () {
		this.værdi=1000; //Kravspecifikation
		
	}

	public int hentVærdi() {
		return værdi;
	}

	public void sætVærdi(int værdi) {
		this.værdi = værdi;
	}

	public String indsæt(int værdi) {	//NU! ligger ansvaret for om konto kan gå i 0 i Kontoklassen. Dette kode vil aldrig blive udført da vi 
									//koder spilsekvensen således at vi checker checkMinus inden vi indsætter og derfor laver en konsekvens 
									//hvis kontoen < 0 inden spilsekvensen kan indsætte guld på kontoen. Men uden dette kode ligger ansvaret
									//ikke hos Konto som vi har bestemt, men hos spilsekvensen.
		
		if (this.værdi + værdi < 0) {//Hvis værdien af det der står på kontoen - det der bliver lagt til (-) < 0
			this.værdi = 0;
			return (spiltekst[9]);
		}else {
			this.værdi = this.værdi + værdi;
			return (spiltekst[10]);
		}
	}
	
	public String hæv(int værdi) {
		if (this.værdi + værdi < 0){
			this.værdi = 0;
			return (spiltekst[9]);
		}else {
			this.værdi = this.værdi + værdi;
			return (spiltekst[10]);
		}
	}
	
	
	public boolean checkMinus(int værdi) {
		if (this.værdi + værdi < 0) {//Hvis værdien af det der står på kontoen - det der bliver lagt til (-) < 0
			this.værdi = 0;//sæt værdi = 0
			return true;//returnerer true hvis condition er opfyldt.
		}
		return false;//returnerer false hvis condition ikke er opfyldt.

	}
}
