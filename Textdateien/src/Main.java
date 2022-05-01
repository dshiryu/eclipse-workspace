import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(anagramm("Ampel", "Lampe"));
		spannbreite("spannbreite.txt");
		ohne6Bis7("67.txt");
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean anagramm(String s1, String s2) {
		// converts to lower case AND to array
		char s1Array[] = s1.toLowerCase().toCharArray();
		char s2Array[] = s2.toLowerCase().toCharArray();
		// sort letters in alphabetical order
		Arrays.sort(s1Array);
		Arrays.sort(s2Array);
		// rebuilding a new empty string for each array
		// reason: doing s1.equal(s2) on the last step would return false with arrays
		String newS1 = "";
		String newS2 = "";
		// array s1 into string
		for (int i = 0; i < s1Array.length; i++) {
			newS1 += s1Array[i];
		}
		// array s2 into string
		for (int i = 0; i < s2Array.length; i++) {
			newS2 += s2Array[i];
		}
		if (newS1.equals(newS2))
			return true;
		else
			return false;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void spannbreite (String datei) {
		int arrayMaker = 0;
		int difference = 0;
		int checkDif = 0;
		int[] number = new int [10000];
		Scanner sc = null;
		File f = new File(datei);
		try {
			sc = new Scanner(f);
			// create an array of ints or Strings
			while (sc.hasNextLine()) {
				number[arrayMaker] = Integer.parseInt(sc.nextLine()); // save to int array
				arrayMaker++;
			}	
		} catch (FileNotFoundException e) {
			System.out.println(datei + " nicht vorhanden");
		}
		//check first number with all others starting from the last, if find a copy, save result
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = number.length - 1; j > 0; j--) {
				if(number[i] == number[j]) {
					checkDif = j - i + 1;
					break;
				} /*else {
					difference = 1; // for some reason this returns always 1 if active
				}*/
			}
			if (checkDif > difference) {
				difference = checkDif;
			}
		}
		System.out.println(difference);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void ohne6Bis7(String datei) {
		int counter = 0;
		int sum = 0;
		int[] numbers = new int[1000];
		Scanner sc = null;
		File f = new File(datei);
		try {
			sc = new Scanner(f);
			// creates int array from the list
			while (sc.hasNextLine()) {
				numbers[counter] = Integer.parseInt(sc.nextLine());
				counter++;
			}
			// sum all numbers, stop the sum when a 6 is found, resume after a 7 (not
			// included)
			for (int i = 0; i < 1000; i++) {
				if (numbers[i] == 6) {
					for (int j = i; numbers[i] != 7; j++) {
						i++;
					}
				} else {
					sum += numbers[i];
				}
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			System.out.println(datei + " nicht vorhanden");
		}
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/* LEGACY CODE
 * A TESTAMENT OF HOW DUMB I WAS UNTIL I UNDERSTOOD WHAT THE AUFGABE 2 REALLY WANTED 
 * public static void spannbreite(String datei) {
		int counter = 0; // Tries 2, 3, 4
		int arrayMaker = 0;
		// int savedCounter = 0; // Try 3 and 4
		int countOfSequenceOld = 0; // Try 1
		int countOfSequenceNew = 0; // Try 1
		int totalOfCountSequence = 0; // Try 1
		// int sum = 0; // Try 5
		// int digitCount = 0; // Try 5
		// int biggest = 0; // Try 6
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// creates an int or String array depending on which thing I was trying to
		// achieve the result
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////        
		int[] numbers = new int[10000]; // int array
		// String[] numbers = new String[10000]; // String array
		Scanner sc = null;
		File f = new File(datei);
		try {
			sc = new Scanner(f);
			// create an array of ints or Strings
			while (sc.hasNextLine()) {
				numbers[arrayMaker] = Integer.parseInt(sc.nextLine()); // save to int array
				// numbers[arrayMaker] = sc.nextLine(); // save to String array
				arrayMaker++;
			}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			// Try 1

			// on this one I tried getting the distance inside the same number like in the
			// example
			// so if the numbers is 123321 there are the distances two (3), four (2) and six
			// (1)
			// it takes the highest distance and sum to a grand total from the whole String
			// array made out of the txt file
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			/*
			 * for (int i = 0; i < numbers.length -1; i++) { int tamanho =
			 * String.valueOf(numbers[i]).length(); String checkCurrent = numbers[i]; // to
			 * show on Eclipse debugger countOfSequenceOld = 0; for (int j = 0; j <
			 * tamanho-1; j++) { for (int k = tamanho-1; k > 0; k--) { if
			 * (numbers[i].charAt(j) == numbers[i].charAt(k)) { countOfSequenceNew = k-j+1;
			 * break; } else { countOfSequenceNew = 1; } } if (countOfSequenceNew >
			 * countOfSequenceOld) { countOfSequenceOld = countOfSequenceNew; } }
			 * totalOfCountSequence += countOfSequenceOld; }
			 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			// Try 2 *****************************
			// this one gets the closest

			// turns the number of digits in each number into the array value itself
			// e.g. 123456 becomes 5
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			/*
			 * for (int i = 9999; i >= 0; i--) { numbers[i] =
			 * String.valueOf(numbers[i]).length(); }
			 * 
			 * // if the numbers are converted on their own distances, the result gives
			 * 8205, // with them themselves become 9999 (!=) or 0 (==) for (int i = 0; i <
			 * 9999; i++) { if (numbers[i] == numbers[i+1]) { counter++; } }
			 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			// Try 3

			// takes the index number and compare it to the next, if != then counter ++ to
			// show the distance
			// resets counter if the number is equal and store it
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			/*
			 * for (int i = 0; i < 9999; i++) { //for (int i = 9999; i > 0; i--) { //
			 * alternative if (numbers[i] != numbers[i+1]) { for (int j = 1; j < 9999; j++)
			 * { counter++; if(numbers[i] != numbers[j] && counter > savedCounter) {
			 * savedCounter = counter; counter = 0; //} //} } }
			 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			// Try 4

			// trying to match 2 equals numbers and getting its sequence
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * for (int i = 0; i < 9999; i++) { for (int j = 9999; j > 0; j--) { if
			 * (numbers[i].equals(numbers[j]) == true) { counter = j - i + 1; } else {
			 * counter = 1; } } if (counter > savedCounter) { savedCounter = counter; } }
			 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
			// Try 5

			// sum the digits -1 from all entries, it results in over 4 million sum
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			/*
			 * for (int i = 9999; i > 0; i--) { while(numbers[i] > 0) { numbers[i] =
			 * numbers[i]/10; digitCount++; } sum += digitCount - 1; }
			 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			// Try 6

			// finds the biggest number, it works
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
			/*
			 * for (int i = 0; i < 9999; i++) { if(numbers[i] > numbers [i + 1] && i < 9998)
			 * { for (int j = 1; j < 9999; j++) { biggest = numbers[j]; } } }
			 */
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// Try 7

			// adapting Try 1 to instead of getting the counter from the number, just
			// considerer the file itself
			// I feel like I already tried it anyway, but now I'm reusing a code
			// added the digit converter from Try 2 because it appears there are no repeated
			// numbers on the list, result = 1
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
/*
			for (int i = 9999; i >= 0; i--) {
				numbers[i] = String.valueOf(numbers[i]).length();
			}

			for (int j = 0; j < numbers.length - 1; j++) {

				int checkJ = numbers[j];
				for (int k = numbers.length - 1; k > 0; k--) {
					int checkK = numbers[k];
					if (numbers[j] == numbers[k]) {
						countOfSequenceNew = k - j + 1;
						break;
					} else {
						countOfSequenceNew = 1;
					}
				}
				if (countOfSequenceNew > countOfSequenceOld) {
					countOfSequenceOld = countOfSequenceNew;
				}
			}
			totalOfCountSequence += countOfSequenceOld;

			// doesn't work, both first and last numbers are 6 digits, so the distance would
			// be 10000

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// this part print the result or a message saying the file wasn't found
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			System.out.println(totalOfCountSequence); // Try 1 and 7
			// System.out.println(counter); // Tries 2 and 3
			// System.out.println(savedCounter); // Try 4
			// System.out.println(sum); // Try 5
		} catch (FileNotFoundException e) {
			System.out.println(datei + " nicht vorhanden");
		}
	} */
