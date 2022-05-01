import java.util.Arrays;

public class CodeRunner5 {

	public static boolean compareIntArrays(int[] a1, int[] a2){
		/*int count = 0;
		
		// starts comparing if both are the same size, otherwise it would be false anyway
		if (a1.length == a2.length) {
			for (int i = 0; i < a1.length; i++) {// one loop for each array
				for (int j = 0; j < a2.length; j++) {
					if (a1[i] == a2[j]) {//compares the values at the same position, increases count if equal
						count++;
						i++;
					} else return false; // return false if values are different
				}
			}
		} else return false; // false if the sizes are different
		
		if (count == a1.length) return true; // count and length are only equal if the loop finishes
		else return false;*/
		
		if (Arrays.equals(a1, a2)) return true;
		else return false;
	}
	
	public static boolean deepCompareIntArrays(int[][] a1, int[][] a2){
	    if (Arrays.deepEquals(a1, a2) == true) return true;
	    
	    return false;
	}
	
	public static String array2String(int[] a1){
	    return Arrays.toString(a1);
	}
	
	public static int[] sortIntArray(int[] a1){
		Arrays.sort(a1);
		return a1;
	}
	
	public static int[] bubbleSort(int[] a1){
	    //Arrays.sort(a1);
	    int temp = 0;
		
	    if (a1.length > 0) {
			for (int i = 0; i < a1.length - 1; i++) {
				for (int j = 1; j < a1.length; j++) {
					int aI = a1[i];
					int aJ = a1[j];
					if (a1[j] < a1[j-1]) {
					
						temp = a1[j];
						a1[j] = a1[j-1];
						a1[j-1] = temp;
					} 
				}
			}
		}
		
		
		return a1;
	}
	
	public static void main(String[] args) {
		System.out.println(java.util.Arrays.toString(bubbleSort(new int[] { 3, -1, 2, 4 })));
		System.out.println(java.util.Arrays.toString(bubbleSort(new int[] {})));
		System.out.println(java.util.Arrays.toString(bubbleSort(new int[] { 0, 0, 1, 0, 2 })));
		System.out.println(java.util.Arrays.toString(bubbleSort(new int[] { -2, -3, -4, -5 })));
		System.out.println(java.util.Arrays.toString(bubbleSort(new int[] { 2, 3, -4, -5 })));

	}

}
