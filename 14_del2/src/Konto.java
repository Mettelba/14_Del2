
public class Konto {

	private int værdi;
	private String[] spiltekst = new String[10];
	
	public Konto () {
		this.værdi=1000; //Kravspecifikation
		
	}

	public int hentVærdi() {
		return værdi;
	}

	public void sætVærdi(int værdi) {
		this.værdi = værdi;
	}

	public String indsæt(int værdi) {	//NU! ligger ansvaret for om konto kan g� i 0 i Kontoklassen. Dette kode vil aldrig blive udf�rt da vi 
									//koder spilsekvensen s�ledes at vi checker checkMinus inden vi inds�tter og derfor laver en konsekvens 
									//hvis kontoen < 0 inden spilsekvensen kan inds�tte guld p� kontoen. Men uden dette kode ligger ansvaret
									//ikke hos Konto som vi har bestemt, men hos spilsekvensen.
		
		if (this.værdi + værdi < 0) {//Hvis v�rdien af det der st�r p� kontoen - det der bliver lagt til (-) < 0
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
		if (this.værdi + værdi < 0) {//Hvis v�rdien af det der st�r p� kontoen - det der bliver lagt til (-) < 0
			this.værdi = 0;//s�t v�rdi = 0
			return true;//returnerer true hvis condition er opfyldt.
		}
		return false;//returnerer false hvis condition ikke er opfyldt.

	}
}
