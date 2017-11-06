import java.util.Random;

public class Terning {

private int øjne; // Opretter variablen øjne af typen int
private int sider; // Opretter variablen sider af typen int

	public Terning(int sider) {
		this.sider = sider; // denne klasses værdi = variablen værdi
	}
		
	public void kast() {
		Random tal = new Random();
		this.øjne = tal.nextInt(this.sider)+1;
	}

	public int hentØjne() {
		return øjne;
	}
	
	public void sætØjne (int øjne) {
		this.øjne = øjne;
	}
}
