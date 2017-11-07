package game;

public class Spiller {

	private String navn = " ";
	private Konto konto;
	private boolean bankerot = false;

	public Spiller(String navn) {

		this.sætNavn(navn);
		this.konto = new Konto(1000);// En ny spiller må sætte 1000 guld ind på kontoen.
	}

	public String hentNavn() {
		return navn;
	}

	public void sætNavn(String navn) {
		this.navn = navn;
	}

	//	public Konto hentKonto() {
	//		return konto;
	//	}

	public void modtagGevinst(int værdi) {
		if (konto.checkMinus(værdi)==true) {
			bankerot = true;
		} else {
			String spiltekst = konto.indsæt(værdi);
		}
	}

	public boolean erDuBankerot() {
		return this.bankerot;
	}

	public int indeståendeSpillerKonto() {
		return konto.hentVærdi();
	}

	public void sætKontoVærdi(int værdi) {
		konto.sætVærdi(værdi);
	}

	public void hævKontoVærdi(int værdi) {
		konto.hæv(værdi);
	}
	public String toString() {
		String returstreng;
		String navn = " ";
		Konto konto;
		boolean bankerot = false;
		
		navn = this.navn;
		konto = this.konto;
		bankerot = this.bankerot;
		
		returstreng = "navn = " + navn + "\n   konto = " + konto + "\n   bankerot = "+ bankerot;
		
		return returstreng;
	}
}
