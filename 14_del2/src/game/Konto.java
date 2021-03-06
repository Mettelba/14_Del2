package game;

public class Konto {

	private int værdi;
	private String[] spiltekst = new String[11];

	public Konto (int værdi) {
		this.værdi = værdi; //Kravspecifikation

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
			return (spiltekst[10]);
		}
		this.værdi = this.værdi + værdi;
		return (spiltekst[9]);

	}

	public String hæv(int værdi) {//Man skal ikke kunne hæve et minus beløb modsat indsæt hvor man indsætter et minus beløb.??
		if (værdi < 0) {
			return (spiltekst[10]);
		}
		if (this.værdi - værdi < 0){
			this.værdi = 0;
			return (spiltekst[10]);
		}
		this.værdi = this.værdi - værdi;
		return (spiltekst[9]);
	}



	public boolean checkMinus(int værdi) {
		if (this.værdi + værdi < 0) {//Hvis v�rdien af det der st�r p� kontoen - det der bliver lagt til (-) < 0
			this.værdi = 0;//s�t v�rdi = 0
			return true;//returnerer true hvis condition er opfyldt.
		}
		return false;//returnerer false hvis condition ikke er opfyldt.

	}
	public String toString() {
		String returstreng;
		int værdi;
		String[] spiltekst2 = new String[11];
		
		værdi=this.værdi;
		spiltekst2 = this.spiltekst;
		
		returstreng= "værdi = "+værdi;
		for(int x=0;x<=10;x=x+1) {
			returstreng=returstreng + "\n";
			returstreng = returstreng + "spiltekst["+x+"]= " + spiltekst2[x];
		}
		
		return returstreng;
	}
}
