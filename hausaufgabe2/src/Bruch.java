public class Bruch {

    public static int ggt(int a, int b) {
    	int result = 0;
    	int mod = 0;
    	for (int i = 2; i >= 1; i++) {
	    	mod = a % b;
	    	a = b;
	    	b = mod;
	    	if (mod == 0) {
	    		return result;
	    	}
	    	result = b;
	    	
	    	
    	}
    	
        return result;
    }

    public static int kgv(int a, int b) {
    	int leastDif = (a * b); ///ggt(a, b)
    	int least = 1;
    	
    	if (a == b || leastDif == 0) {
    		least = a;
    	} else {    	
    		least = leastDif/ggt(a, b);
    	
    	}
    	
    	return least;
    }

    public static void kuerzen(int zaehler, int nenner) {
    	
    	
    	
    	
    	for (int i = 2; i > 0; i++) {
    		if (zaehler % i == 0 && nenner % i == 0) {
    			zaehler /= i;
    			nenner /= i;
    			i--;
    			if (ggt(zaehler,nenner) == 1) {
    				System.out.println(zaehler + "/" + nenner);
    				break;
    			} 
    			
    		} else {
    			if (nenner == 1) {
    				System.out.println(zaehler);
    				break;
    			} else if (zaehler == 1) {
    				System.out.println(zaehler + "/" + nenner);
    				break;
    			} else if (ggt(zaehler,nenner) == 1) {
    				System.out.println(zaehler + "/" + nenner);
    				break;
    			} else  {
    				// not printing anything to avoid repetition	
    			} 
    		}
    		
    		
    	} 

    }

    public static void bruchprodukt(int zaehler1, int nenner1, int zaehler2, int nenner2) {
    	
    	int zaehlerProd = zaehler1*zaehler2;
    	int nennerProd = nenner1*nenner2;
    	
    	
    	if (nenner1 * nenner2 == 0) {
    		System.out.println("Nenner = 0, nicht möglich");
    	} else if(nenner1 * nenner2 == 1){
    		System.out.println(zaehlerProd);
    	} else {
    		
    		kuerzen(zaehlerProd,nennerProd);
    	}
    }

    public static void bruchsumme(int zaehler1, int nenner1, int zaehler2, int nenner2) {
    	int resultZaehler = (zaehler1 * nenner2) + (zaehler2 * nenner1);
    	int resultNenner = nenner1 * nenner2;
    	kuerzen(resultZaehler, resultNenner);
    }

    public static void main(String[] args) {
		System.out.println(kgv(48,30));
		System.out.println(kgv(17,51));
		System.out.println(kgv(11,11));
		System.out.println("\n");
		kuerzen(121,11);
		kuerzen(12,72);
		kuerzen(34,51);
		System.out.println("\n");
		bruchprodukt(1,2,2,5);
		bruchprodukt(2,17,3,15);
		bruchsumme(1,2,1,3);
		bruchsumme(2,17,3,15);
		bruchsumme(12,3,57,19);
		System.out.println("\n");
    }
}
