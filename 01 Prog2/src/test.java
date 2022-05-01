import java.util.Arrays;

public class test { 

    public static void main(String[] args) { 
        //System.out.println(checkPredecessor(new int[] {1, 2, 1, 2, 3})); 
        //System.out.println(computeNorm(new double[] {1., 2., 3. })); 
        //System.out.println(containsMultipleOf(new int[] { 1, 1, 3 }, 3)); 
        //System.out.println(sumOfRow2(new double[][] { { 1., 2. }, { 1., 2. }, { 1., 2. } })); 
    	//System.out.println(sumOfMatrix(new double[][] { { 1., 1., 1. }, { 2., 2., 2. }, { 3., 3., 3. } })); //18
    	System.out.println(Arrays.deepToString(linearClassifier(new double[][] {}, new double[] { 1.0, 0.0 })));
    	System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 1. }, { 2., 2. }, { 3., 3. } }, new double[] { 1.0, 0.0 })));
    	System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 2. }, { 1., 2. }, { 1., 2. } }, new double[] { 1.0, 0.0 })));
    	System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { -3.0, 1.0 } }, new double[] { 1.0, 0.0 })));
    	System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 2. }, { 1., 0. } }, new double[] { 1.0, 1.0 })));


    } 

    public static boolean checkPredecessor(int[] x){ 
        int count = 0; 
        
        
        for (int i = 0; i < x.length-1; i++) { 
            if (x[i + 1] > x[i]) count++; 
            if (count > 2) return false; 
        } 
        return true; 
    } 
    
    public static double computeNorm(double[] x){ 
        double count = 0; 
        for (int i = 0; i < x.length; i++) { 
            x[i] = x[i]*x[i]; 
            count += x[i]; 
        } 
        return count; 
    } 
    
    public static boolean containsMultipleOf(int[] x, int base){ 
        int count = 0; 
        for (int i = 0; i < x.length; i++) { 
            if (x[i] % base == 0) count++; 
        } 
        if (count > 0) return false; 
        else return true; 
    } 
    
    public static double sumOfRow2(double[][] x){ 
        double count = 0; 
        
        if (x.length == 1) return count;
        for (int i = 0; i < x.length; i++) { 
        	for (int j = 0; j < x[1].length;j++) {
        		if (i == 1)count += x[i][j]; 
        	}
        } 
        return count; 
    } 
    
    public static double sumOfMatrix(double[][] x){
    	double count = 0;
    	
    	for (int i = 0; i < x.length; i++) { 
        	for (int j = 0; j < x[i].length;j++) {
        		count += x[i][j]; 
        	}
        } 
    	return count;
    }

    public static double[][] linearClassifier(double[][] x, double[] w){
		double [][] sum = new double [x.length][1];
		double count = 0; 
		
		if (x.length == 0) return x;
		
    	for (int i = 0; i < x.length; i++) { 
        	for (int j = 0; j < x[i].length;j++) {
        		 x[i][j] = x[i][j]*w[j]; 
        	}
        }
    	
    	for (int i = 0; i < x.length; i++) { 
        	for (int j = 0; j < x[i].length;j++) {
        		count += x[i][j]; 
        	}
        	sum[i][0] = count;
        	count = 0;
        } 
    	
    	return sum;
        
        
    }
    
} 