package game;
public class Regler {


	private int værdi; 
	private boolean ekstratur;

	
	public Regler() {
		this.ekstratur = false;

	}

	public int hentVærdi() {
		return this.værdi;

	}


	public void sætVærdi(int point){
		this.værdi = point;

	}

	public boolean hentEkstraTur() {
		return this.ekstratur;
		


	}

	public void sætEkstraTur(boolean ekstratur) {
		this.ekstratur = ekstratur;
		

	}

	public void felt (int terningslag) {  	//Her er reglerne for felterne som er givet i 
											// kravspecifikationen.
		switch (terningslag) {

		case 2:
			this.værdi = 250;
			this.ekstratur = false;
			break;

		case 3:
			this.værdi = -100;
			this.ekstratur = false;
			break;

		case 4:
			this.værdi = 100;
			this.ekstratur = false;
			break;

		case 5:
			this.værdi = -20;
			this.ekstratur = false;
			break;

		case 6: 
			this.værdi = 180;
			this.ekstratur = false;
			break;

		case 7:
			this.værdi = 0;
			this.ekstratur = false;
			break;

		case 8: 
			this.værdi = -70;
			this.ekstratur = false;
			break;

		case 9:
			this.værdi = 60;
			this.ekstratur = false;
			break;

		case 10: 
			this.værdi = -80;
			this.ekstratur = true;
			break;

		case 11:
			this.værdi = -50;
			this.ekstratur = false;
			break;

		case 12:
			this.værdi = 650;
			this.ekstratur = false;
			break;
		}
	}
}
