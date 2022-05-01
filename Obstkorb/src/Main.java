
public class Main {

	public static void main(String[] args) {
		Obstkorb k = new Obstkorb(60);
		k.verkaufe(1, 1);
		k.verkaufe(20, 1);
		k.verkaufe(20, 1);
		k.printUmsatz();
		k.neuerPreis(1, 10);
		k.verkaufe(1, 1);
		k.printUmsatz();

	}

}
