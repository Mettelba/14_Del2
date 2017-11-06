import java.util.Random;

public class Terning {

private int �jne; // Opretter variablen �jne af typen int
private int sider; // Opretter variablen sider af typen int

	public Terning(int sider) {
		this.sider = sider; // denne klasses v�rdi = variablen v�rdi
	}
		
	public void kast() {
		Random tal = new Random();
		this.�jne = tal.nextInt(this.sider)+1;
	}

	public int hent�jne() {
		return �jne;
	}
	
	public void s�t�jne (int �jne) {
		this.�jne = �jne;
	}
}
