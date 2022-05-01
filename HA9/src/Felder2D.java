public class Felder2D {

    public static int[][] primzahlen = {{2, 3, 5, 7}, {11, 13, 17, 19}, {23, 29}, {31, 37}, {41, 43, 47}}; 
    
    public static int[][] potenzen() {
        int [][] p2d = {
    			{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0},
    			{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0},
    			{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0},
    			{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}, {0,0,0},
    	};
    	for (int i = 0; i < 20; i++) {
    		p2d[i][0] = (i+1);
    		p2d[i][1] = (i+1)*(i+1);
    		p2d[i][2] = (i+1)*(i+1)*(i+1);
    	}
    	return p2d;
    }
    
    public static void prettyPrint(int[][] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr[i].length; j++) {    			
    			System.out.print(arr[i][j] + "\t");
    		}
    		System.out.println();
    	}
    }

    public static int[][] transpose(int[][] arr) {
        int [][] temp = new int [arr.length][arr.length];
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr[i].length; j++) {    			
    			temp [i][j] =arr[j][i];
    		}
    	}
    	return temp;
    }
    
    public static int[] maxe(int[][] arr) {
        int [] big = new int [arr.length]; 
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 1; j < arr[i].length; j++) {    			
    			if (arr[i][j-1] > arr[i][j]) {
    				big[i] = arr[i][j-1]; 
    			} else {
    				big[i] = arr[i][j];
    			}
    		}
    	}
    	return big;
    }
}
