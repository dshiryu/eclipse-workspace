import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		spannbreite("spannbreite.txt");
			
	}

	public static void spannbreite (String datei) {
		int arrayMaker = 0;
		int difference = 0;
		int checkDif = 0;
		int[] number = new int [10000];
		// String[] numbers = new String[10000]; // String array
		Scanner sc = null;
		File f = new File(datei);
		try {
			sc = new Scanner(f);
			// create an array of ints or Strings
			while (sc.hasNextLine()) {
				number[arrayMaker] = Integer.parseInt(sc.nextLine()); // save to int array
				// numbers[arrayMaker] = sc.nextLine(); // save to String array
				arrayMaker++;
			}	
		} catch (FileNotFoundException e) {
			System.out.println(datei + " nicht vorhanden");
		}
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = number.length - 1; j > 0; j--) {
				if(number[i] == number[j]) {
					checkDif = j - i + 1;
					break;
				} 
			}
			if (checkDif > difference) {
				difference = checkDif;
			}
		}
		System.out.println(difference);
	}
}
