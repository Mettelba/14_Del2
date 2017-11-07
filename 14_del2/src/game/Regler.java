package game;
public class Regler {


	private int point; 
	private boolean ekstratur;

	
	public Regler() {
		this.ekstratur = false;

	}

	public int hentPoint() {
		return this.point;

	}


	public void sætpoint(int point){
		this.point = point;

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
			this.point = 250;
			this.ekstratur = false;
			break;

		case 3:
			this.point = -100;
			this.ekstratur = false;
			break;

		case 4:
			this.point = 100;
			this.ekstratur = false;
			break;

		case 5:
			this.point = -20;
			this.ekstratur = false;
			break;

		case 6: 
			this.point = 180;
			this.ekstratur = false;
			break;

		case 7:
			this.point = 0;
			this.ekstratur = false;
			break;

		case 8: 
			this.point = -70;
			this.ekstratur = false;
			break;

		case 9:
			this.point = 60;
			this.ekstratur = false;
			break;

		case 10: 
			this.point = -80;
			this.ekstratur = true;
			break;

		case 11:
			this.point = -50;
			this.ekstratur = false;
			break;

		case 12:
			this.point = 650;
			this.ekstratur = false;
			break;
		}
	}
}
