
public class Konto {
	private int kontoStand = 0;
	
	public void initialStand (int x) {
		this.kontoStand = x;
	}
	
	public int einzahlen (int x) {
		kontoStand = kontoStand + x;
		return x;
	}
	
	public int auszahlen (int x) {
		kontoStand = kontoStand - x;
		return x;
	}
	
	public int printKontostand () {
		return kontoStand;
	}

}
