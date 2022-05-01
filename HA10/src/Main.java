public class Main {
	
    public static long rentier(int laenge, int x, int y) {
    	int count = 1;
    	if (laenge == 1) return count + 0;
    	if (y >= laenge/2 && y <= x) return rentier (laenge - 1, x + 1, y-1) + count++;
    	if (y == 0) return rentier (laenge - 1, x + 1, y + 1) + count++;
    	return rentier (laenge - 1, x + 1, y - 1) + count++;
    }

    public static String hanoi3(int n, int von, int bis) {      
    	if (n==1) return von + " --> " + bis;
        int dritte = 6-von-bis;
    	hanoi3(n-1, von, dritte); 
    	System.out.println (von + " --> " + bis);
    	hanoi3(n-1, dritte, bis);
    	System.out.println (dritte + " --> " + bis);
    	
        return von + " --> " + bis;
    }
    
    public static void main(String[] args) {
        System.out.println(rentier(22,0,0));
        System.out.println(hanoi3(5,1,3));
    }

}
