import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class woche3 {

	/*public String stringBauen(String x){
	    if (x == "") return "";
	    else if (x.indexOf('a') >= 0) return x.replaceAll("a", "");
	    else return x;
	}*/
	
	public boolean findeStringImString(String x, String suchen){
	    if (x.toLowerCase().indexOf(suchen.toLowerCase()) >= 0) return true;
	    else return false;
	}

	public String stringBauen(String x){
	    if (x == "") return "";
		else if (x.toLowerCase().indexOf('a') >= 0) {
			String copyOfX = x;
			for (int i = 1; i < x.length(); i++) {
				if (x.toLowerCase().charAt(i) == 'a') copyOfX = x.replace("a","");
			}
			
			return copyOfX;
		}
		else return x;
	}
	
	public static boolean stringFinden(String x, String suchen){
	    if (suchen == "") return true;
	    else if (x == "") return false;
	    else if (x.indexOf(suchen.charAt(0)) >= 0) {
	    	String reconstructSuchen = "";
	    	for (int i = 0; i < suchen.length(); i++) {
	    		for (int j = 0; j < x.length(); j++) {
	    			if (x.charAt(j) == suchen.charAt(i)) {
	    				reconstructSuchen += x.charAt(j);
	    				i++;
	    			}
	    		}
	    	}
	    	if (reconstructSuchen.equals(suchen)) return true;
	    	else return false;
	    } else return false;
	}
	
	public String rausschneiden(String x, int m){
	    String recontructed = "";
	    
	    for (int i = 0; i < x.length(); i++) {
	        if (i % m == 0 || i == 0) recontructed += x.charAt(i);
	    }
	    
	    return recontructed;
	}
	
	public static boolean istAnagramm(String x, String y){
	    char [] charX = x.toLowerCase().toCharArray();
	    char [] charY = y.toLowerCase().toCharArray();
		
	    Arrays.sort(charX);
	    Arrays.sort(charY);
	    if (x == "" || y == "") return true;
	    else if (Arrays.equals(charX, charY)) return true;  
	    else return false;
	}

	public static boolean istPalindrom(String x){
	    String comparedX = "";
	    String xWithoutSpace = x.replace(" ","");
	    int count = 0;
	    
	    for (int i = xWithoutSpace.length() - 1; i >= 0; i--){
	    	comparedX += xWithoutSpace.charAt(i);
	    	for (int j = 0; j < xWithoutSpace.length() - 1; j++) {
	    		if (xWithoutSpace.charAt(i) == comparedX.charAt(j)) {
	    			count++;
	    			break;
	    		}
	    	}
	    }
	    
	    if (count == comparedX.length()) return true;
	    else return false;
	}

	public static int woerterZaehlen(String x){
	    int count = 1;
	    
	    for (int i = 0; i < x.length() - 1; i++) {
	        if (x.charAt(i) == ' ' && x.charAt(i + 1) != ' ') count++;
	    }
	    
	    if (x.equals("")) return 0;
	    else return count;
	}
	
	static void druckeStrings2() {
		String einString = "";
		  int scanIndex;
		  Scanner scanner = new Scanner (System.in);    
		  
		  
		  /*scanIndex = einString.indexOf("end");
		  
		  for (int i = 0; i < einString.length(); i++) {
		    if (einString.charAt(i) == 'd' && einString.charAt(i - 1) == 'n' && einString.charAt(i - 2) == 'e') {
		    	System.out.println(einString.substring(0, scanIndex + 3));
		    	break;
		    }
		  }*/
		 while (scanner.hasNext()) {
			 einString = scanner.nextLine();
			 System.out.println(einString);
			 if (einString.contains("end")) break;
		 }
		  
	}
	
	
	
	public static void main(String[] args) {
		

	}
}
