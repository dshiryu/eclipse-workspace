
public class Blatt2 {

	public static void main(String[] args) {
		
		double n1 = 1000000.0d; //Aufgabe 1
		double myPI = 1.0d;
		double myPI2 = 0.0d;
		int n2 = 4444; //Aufgabe 2
		int n3 = 125630703; //Aufgabe 3
		//double n4 = 0.0d; //Aufgabe 4.a - used while trying to control the output
		double n5 = 0; //Aufgabe 4.b
		//int repeats = 7; // used in Aufgabe 2 with a "i++" on the loop. The lowest number varies according to n2, if it n2 = 1000, then repeats = 112 to reach 1
		int zQuer = 0; // Aufgabe 3
		double j = -1.0d; // Aufgabe 1 und 4.a
		double nlog = 0.0d; // Aufgabe 4.a
		
		/*********************************************************************************************************************/
		
		// Aufgabe 1 - Wallissches Produkt
		System.out.println("Aufgabe 1: \n");
		for (double i = 1.0d; i <= n1; i++) {
			myPI = myPI * ((2 * i) / ((2 * i) - 1)) * ((2 * i) / ((2 * i) + 1));
			if (i == n1) {
				System.out.println("Walliss: " + 2 * myPI); 
			}
		}
		/*********************************************************************************************************************/
		/* Considering the results for both until the 5th digit, it doesn't seem to make much of a difference which method is used.
		 * However, Leipniz Reihe tends to go way over the value on the 6th digit and way below, going up and down while arriving at the number.
		 * Wallis, on the other hand, keeps increasing steadly its value, so it shouldn't really go over what PI is.
		 */
		/*********************************************************************************************************************/
		// Leipniz Reihe
		for (double i = 0.0d; i <= n1; i++) {
			myPI2 = myPI2 + (-j / ((2.0d * i) + 1.0d));
			j = -j;
			
			if (i == n1) {
				System.out.println("Leipniz: " + 4 * myPI2); 
				
			}
			
		}
		
		/*********************************************************************************************************************/
		
		// Aufgabe 2 - Yet another Collatz
		System.out.println("\nAufgabe 2: ");
		for (int i = n2; i > 3; i--) {
			System.out.print(n2 + " ");
			
			if (n2 % 2 == 0) {
				n2 = n2 / 2;
			} else {
				n2 = (3 * n2) + 1;
			}
			if (n2 == 1) {
				System.out.print(n2 + "\n");
				System.out.println("Laenge: " + i);
				break;
			}
		}
		// Aufgabe 3 - Zweier-Quersumme
		
		/* Using a double instead of int to be able to try 5125637792 (example 2) 
		 * made the decimal numbers change the final result to 311 instead of 308
		 */
		
		/*********************************************************************************************************************/
		
		System.out.println("\n\nAufgabe 3: ");
		while (n3 > 0){
			//System.out.println(zQuer);
			zQuer = zQuer + (n3 % 100);
			n3 = n3 / 100;
		}
		System.out.println("Zweier-Quersumme von 125630703: " + zQuer); //if I use the n3 here it'll take the number after the loop, zero
		
		/*********************************************************************************************************************/
		
		// Aufgabe 4 -  Naturlicher Logarithmus
		System.out.println("\nAufgabe 4: ");
		double log2 = Math.log(2);	
		// x < 0.0023
		for (double i = 1.0d; i <= 217; i++) { //151 
			
			//System.out.println(nlog);
			nlog = nlog + ((1.0d / i)*j);
			//n4 = i - (1 / i)*j;
			j = -j;
		}
		System.out.println("a:\n" + (nlog - log2));
		
		/*********************************************************/
		
		for (double i = 1; i <=101; i = i + 4) {
			n5 = n5 + (1 / (i * (i + 1) * (i + 2)));
		}
		System.out.println("b:\n" + (4 * n5) + "\n" + log2); // with the given formula, only after the 101 the four first numbers are the same...
	}
	
}
		
			
	


