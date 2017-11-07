package game;


public class Raflebæger {

	
	private int sum;
	private int antalsider = 6; //6, repræsentere antal sider, kan skiftes eks antal 10 sider 
	private Terning terning1;
	private Terning terning2;
	private int terning1værdi;
	private int terning2værdi;

	
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
		this.terning1værdi = this.terning1.hentØjne();
		this.terning2værdi = this.terning2.hentØjne();
		this.sum = terning1.hentØjne() + terning2.hentØjne(); //varbibale antal æjne ligger i objetet terning1 og terning2
		
	}
	//en metode der henter værdien fra terning1 
	public int hentTerning1værdi () {
		return this.terning1værdi;
		}
	
	//en metode der henter værdien fra terning1 
	public int hentTerning2værdi () {
		return this.terning2værdi;
	}
	
	public int hentSum() { //parentes angiver parameter
		//beregn summen af de to terning.
		//this.sum = terning1.hentØjne() + terning2.hentØjne(); //varbibale antal æjne ligger i objetet terning1 og terning2
		return this.sum; //returner sum
	}

	public void sætSum(int sum) { // parameter man sender til metoden 
		this.sum = sum;
	}
	
	public void sætTerning1værdi(int terning1værdi) {
		this.terning1værdi = terning1værdi;
	}
	
	public void sætTerning2værdi(int terning2værdi) {
		this.terning2værdi = terning2værdi;
	}
	
	public int hentAntalSider() { //parentes angiver parameter
		//beregn summen af de to terning.
		return antalsider; //returner sum
	}
	public void sætAntalsider(int antalsider) {
		this.antalsider = antalsider;
	}
}
