import java.util.ArrayList;

public class Sieb {
  ArrayList<Integer> fullList = new ArrayList<Integer>(0) ; // limit - 1?
	/**
   * Initializes the array with the numbers from 0 to limit-1.
   * 
   * @param limit indicates the upper bound on numbers generated, they go from 0 to limit-1.
   * @return the initialized array.
   */
  public ArrayList<Integer> erzeugeKandidaten(int limit) {
    this.fullList.ensureCapacity(limit);
    
    for(int i = 0; i < limit; i++) {
    	this.fullList.add(i, i);
    }
    
    return this.fullList; 
  }

  /**
   * Eliminates non-primes from array.
   * 
   * @param kandidaten contains the numbers from 0 to kandidaten.length-1.
   * @return nothing.
   */
  public void filtereKandidaten(ArrayList<Integer> kandidaten) {
	  for(int i = 0; i < this.fullList.size(); i++) {
		  int count = 0;
		  for(int j = 1; j <= i; j++) {
			  if(i % j == 0)
				  count++;
		    }
		    
		   if(count > 2) {
			   this.fullList.remove(i);
			   this.fullList.add(i, - 1);
		   }
		    
	  }
	  //this.fullList.add(0);
  }

  /**
   * Prints the values != -1 in an array, starting at position 2.
   * 
   * @param kandidaten: the array.
   * @return nothing.
   */
  void druckeKandidaten(ArrayList<Integer> kandidaten) {
	  
	  for(int i = 0; i < this.fullList.size(); i++) {
		  if (this.fullList.indexOf(i) != - 1 && this.fullList.indexOf(i) > 1) System.out.println(fullList.get(i));
		}
	}
  
  public static void main(String[] args) {
	  Sieb s = new Sieb();
	  ArrayList<Integer> primzahlen = s.erzeugeKandidaten(10); //2, 3, 5, 7
	  s.filtereKandidaten(primzahlen);
	  s.druckeKandidaten(primzahlen);
	  
	  Sieb ss = new Sieb();
	  ArrayList<Integer> primzahlen1 = ss.erzeugeKandidaten(25); //2, 3, 5, 7, 11, 13, 17, 19, 23
	  ss.filtereKandidaten(primzahlen1);
	  ss.druckeKandidaten(primzahlen1);
	  
  }

}