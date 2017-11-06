package game;


public class Raflebæger {

	
	private int sum;
	private int antalsider = 6; //6, repræsentere antal sider, kan skiftes eks antal 10 sider 
	private Terning terning1;
	private Terning terning2;

	
	public Raflebæger(int antalsider) {
		this.antalsider = antalsider;
		terning1 = new Terning(this.antalsider);
		terning2 = new Terning(this.antalsider);
		//den kan modtage integer parameter og oprette to terninger med det antal sider
	
	}
	public void ryst() { // ryst skal ikke returnere noget
		this.sum = 0; //nulstil kast, så når man ryster igen får ny værdi 
		
		terning1.kast();
		terning2.kast();
		
		
	}
	//en metode der henter værdien fra terning1 
	public int hentTerning1værdi () {
		return terning1.hentØjne();
		}
	
	//en metode der henter værdien fra terning1 
	public int hentTerning2værdi () {
		return terning2.hentØjne();
	}
	
	public int hentSum() { //parentes angiver parameter
		//beregn summen af de to terning.
		sum = terning1.hentØjne() + terning2.hentØjne(); //varbibale antal æjne ligger i objetet terning1 og terning2
		return sum; //returner sum
	}

	public void sætSum(int sum) { //parameter man sender til metoden
		this.sum = sum;
	}
	
	public int hentAntalSider() { //parentes angiver parameter
		//beregn summen af de to terning.
		return antalsider; //returner sum
	}
	public void sætAntalsider(int antalsider) {
		this.antalsider = antalsider;
		
	}
}
