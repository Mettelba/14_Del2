
public class Spiller {
	
	private String navn = " ";
	public Konto konto;
	
	public Spiller(String navn) {
		
		this.sætNavn(navn);
		this.konto = new Konto();
		
		
	}

	public String hentNavn() {
		return navn;
	}

	public void sætNavn(String navn) {
		this.navn = navn;
	}
	
	
	

}