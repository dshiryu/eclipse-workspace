class Blatt1 {
    public static void main(String[] args) {
        int a = 7;
		int b = 1;
		int c = 8;
		int n = 12;
		int erstN = n;
		int product = 1;
		int querSumme = 0;
		
        // twoInLove
        System.out.println("Aufgabe 1:");
		if (a + b == c || a - b == c || a + c == b || a - c == b || b + c == a || b - c == a){
			System.out.println("twoInLove");
		} else {
			System.out.println("noLove");
		}

        // Produkt
        System.out.println("Aufgabe 2:");
		for (int i = 1; i <= n; i++){
			
			if (i % 3 == 0){
				product = product * i;
			}
			if (i == n){
				System.out.println(product); // the highest value of n is 77 without an overflow
			}
		}

        // FizzBuzz
        System.out.println("Aufgabe 3:");
		if (n % 3 == 0){
			System.out.println("Fizz");
		} else if (n % 5 ==0){
			System.out.println("Buzz");
		} else if (n % 3 == 0 && n % 5 ==0){
			System.out.println("FizzBuzz");
		} else {
			System.out.println("n ist nicht durch weder 3, oder 5 teilbar");
		}
				
        // Schokolade
        System.out.println("Aufgabe 4:");
		if (a + (b * 5) == n){
			System.out.println(a);
			} else {
				System.out.println("-1");
			}
		
        // Quersumme
        System.out.println("Aufgabe 5:");
		while (erstN > 0){
			querSumme = querSumme + (erstN % 10);
			erstN = erstN / 10;
		}
		System.out.println(querSumme);

		// Teilbar
        System.out.println("Aufgabe 6:");
        for (int i = n; i >= 0; i = i - 3) {
        	
        	if (i == 0){
				System.out.println("Durch3");
			} else if (i >= -3 && i < 3) {
				System.out.println("no3");
			}
        }
        
		

    }
}
    
