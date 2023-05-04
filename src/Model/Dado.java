package Model;
import java.util.Random;

public class Dado {
	
	Random random = new Random();
	
	public int rolaDado() {
		return random.nextInt(6) + 1;
	}
}
