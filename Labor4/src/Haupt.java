
public class Haupt {

	public static void main(String[] args) {
		Konto a = new Konto();
		
		a.initialStand(500);
		System.out.println("The initial balance is " + a.printKontostand());
		System.out.println(a.einzahlen(50) + " was deposited");
		System.out.println(a.auszahlen(10) + " was withdrawn");
		System.out.println("Your balance is " + a.printKontostand());
	}

}
