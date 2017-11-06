

public class Raflebæger {

	
	private int sum;
	private int antalsider = 6; //6, repræsentere antal sider, kan skiftes eks antal 10 sider 
	private Terning terning1;
	private Terning terning2;
	private int terning1værdi; 
	//variable der indholder værdien for terning1, skal bruges til GUI
	private int terning2værdi; 
	//variable der indholder værdien for terning2, skal bruges til GUI
	
	
	public Raflebæger() {
		terning1 = new Terning(antalsider);
		terning2 = new Terning(antalsider);
	
	}
	public void ryst() { // ryst skal ikke returnere noget
		this.sum = 0; //nulstil kast, så når man ryster igen får ny værdi 
		
		terning1.kast();
		terning2.kast();
		
		//
		this.terning1værdi = terning1.hentØjne();
		/*Denne terning1, hentes de øjne der lige er blevet kastet for terning1
		og gemmer i variablen : terning1værdi*/
		
		this.terning2værdi = terning2.hentØjne();
		/*Denne terning2, hentes de øjne der lige er blevet kastet for terning2
		og gemmer i variablen : terning2værdi*/
		
	}
	//en metode der henter værdien fra 
	public int hentTerning1værdi () {
		return this.terning1værdi;
	}
	
	public int hentTerning2værdi () {
		return this.terning2værdi;
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
