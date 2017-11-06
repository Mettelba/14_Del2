
public class Konto {

	private int v�rdi;
	private String[] spiltekst = new Spiltekst[10]
	
	public Konto () {
		this.v�rdi=1000; //Kravspecifikation
		
	}

	public int hentV�rdi() {
		return v�rdi;
	}

	public void s�tV�rdi(int v�rdi) {
		this.v�rdi = v�rdi;
	}

	public String inds�t(int v�rdi) {	//NU! ligger ansvaret for om konto kan g� i 0 i Kontoklassen. Dette kode vil aldrig blive udf�rt da vi 
									//koder spilsekvensen s�ledes at vi checker checkMinus inden vi inds�tter og derfor laver en konsekvens 
									//hvis kontoen < 0 inden spilsekvensen kan inds�tte guld p� kontoen. Men uden dette kode ligger ansvaret
									//ikke hos Konto som vi har bestemt, men hos spilsekvensen.
		
		if (this.v�rdi + v�rdi < 0) {//Hvis v�rdien af det der st�r p� kontoen - det der bliver lagt til (-) < 0
			this.v�rdi = 0;
			return (spiltekst[9]);
		}else {
			this.v�rdi = this.v�rdi + v�rdi;
			return (spiltekst[10]);
		}
	}
	
	public String h�v(int v�rdi) {
		if (this.v�rdi + v�rdi < 0){
			this.v�rdi = 0;
			return (spiltekst[9]);
		}else {
			this.v�rdi = this.v�rdi + v�rdi;
			return (spiltekst[10]);
		}
	}
	
	
	public boolean checkMinus(int v�rdi) {
		if (this.v�rdi + v�rdi < 0) {//Hvis v�rdien af det der st�r p� kontoen - det der bliver lagt til (-) < 0
			this.v�rdi = 0;//s�t v�rdi = 0
			return true;//returnerer true hvis condition er opfyldt.
		}
		return false;//returnerer false hvis condition ikke er opfyldt.

	}
}
