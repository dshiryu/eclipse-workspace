import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class CodeRunner6 {

	static double reduceOp(ArrayList<Double> x){
	    double result = 1.0;
		
		if(x.isEmpty()) return 0.0;
		else if(x.size() == 1) return x.get(0);
	    else {
	    	for(int i = 0; i < x.size(); i++) {
	    		if(i == 0) {
	    			result = x.get(0);
	    		} else {
	    			result += x.get(i) * x.get(i - 1);
	    		}
	    	}
	    }
		return result;
	    
	    
	}
	
	static double reduceOp2(LinkedList<Double> x){
	    if(x.isEmpty()) return 0.0;
	    Collections.sort(x);
	    if(Math.abs(x.getFirst()) > Math.abs(x.getLast() )) return Math.abs(x.getFirst());
	    else return x.getLast();
	}
	
	static double calcSumOfSquares(ArrayList<Double> x){
	    if(x.isEmpty()) return 0.0;
	    double result = 0.0;
	    
	    for(int i = 0; i < x.size(); i++) {
	    	result += x.get(i) * x.get(i);
	    }
	    return result;
	}
	
	static void printSumOfSquares(ArrayList<Double> x){
	    
	    double result = 0.0;
	    
	    for(int i = 0; i < x.size(); i++) {
	    	result += x.get(i) * x.get(i);
	    }
	    System.out.println(result);
	}

	static LinkedList<Integer> replaceInLinkedList(LinkedList<Integer> arr, Integer toFind, Integer replacement){
		if(arr.isEmpty()) return arr;
		else if(arr.size() == 1) arr.set(0, replacement);
		else if(toFind > arr.size()) return arr;
		else arr.set(arr.indexOf(toFind), replacement);
		
		return arr;
		
	}
	
	static ArrayList<Integer> replaceInArrayList(ArrayList<Integer> arr, Integer toFind, Integer replacement){
	    if(arr.isEmpty()) return arr;
		else if(arr.size() == 1) arr.set(0, replacement);
		else if(toFind > arr.size()) return arr;
		else {
			for(int i = 0; i < arr.size(); i++) {
				if(arr.indexOf(toFind) == - 1) break;
				arr.set(arr.indexOf(toFind), replacement);
			}
		}
		
		return arr;
	}
	
	static void printArrayList(ArrayList<Integer> arr){
		if(arr.isEmpty()) System.out.println("") ;
		else {
			for(int i = 0; i < arr.size(); i++) {
				System.out.print(arr.get(i)) ;
			}
		}
	}
	
	static ArrayList<Integer> insertElementsAt0(ArrayList<Integer> l, Integer el, int n){
	    if(n == 0) return l;
	    else {
	    	for(int i = 0; i < n; i++) {
	    		l.add(0, el);
	    	}
	    	return l;
		}
	}

	
	public static void main(String[] args) {
		
	}

}
