package Model;
import java.util.Random;

public class Dado {
	
	Random random = new Random();
	public int dadoValor = 0;
	
	private static Dado dado = null;
	
	private Dado() {};
	
	public int rolaDado() {
	
		dadoValor =  random.nextInt(6) + 1;
		return dadoValor;

	}
	
	public static Dado getDado() {
		
		if (dado==null) {
			dado = new Dado();
		}
		
		return dado;
	}
}
