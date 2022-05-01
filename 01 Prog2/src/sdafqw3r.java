
public class sdafqw3r {

	public static void main(String[] args) {
		System.out.println(linkeQuersummeN(4333, 1));//4
		System.out.println(linkeQuersummeN(4333, 2));//7
		System.out.println(linkeQuersummeN(331, 5));//7
		System.out.println(linkeQuersummeN(12345, 3));//6
		System.out.println(linkeQuersummeN(100000, 2));//1
		System.out.println(linkeQuersummeN(155555, 3));//11

	}
	
	public static int linkeQuersummeN(int x, int N){
		int result = 0;
        int rest = 0;
        int sum = 0 ;
        
        while (x > 0) {
            rest = x % 10;
            x = x / 10;
            result = result * 10 + rest;
        }
        
        for (int i = 0; i < N; i++) {
        	rest = result %10;  
        	sum += rest;
        	result /= 10;
        }
        
        return sum;
		
	}
			
		
	
	
	//somar a array e o resultado eh dividido pelo modulo
	public static int pruefsumme(int[] x, int mod){
	    int result = 0;
		
		for (int i = 0; i < x.length; i++) {
	    	result += x[i];
	    }
		
		return result%mod;
	}
	
	public static boolean hatHoechstens(int x, int n){
		int rest = 0;
	    int counter = 0;
	    
	    while (x > 0) {
	        rest = x % 10;
	        if (rest == 2) {
	            counter++;
	        } 
	        x = x/10;
	        if (counter > n) return false;
	    }
		
		return true;
	}
	
	public static boolean hat222(int x){
	    int rest = 0;
	    int counter = 0;
	    
	    while (x > 0) {
	        rest = x % 10;
	        if (rest == 2) {
	            counter++;
	        } else {
	            counter = 0;
	        }
	        x = x/10;
	        if (counter == 3) return true;
	    }
	    return false;
	}

}
