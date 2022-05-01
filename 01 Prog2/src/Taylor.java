
public class Taylor {

  /** Multiply x for n times.
   * @param x base value.
   * @param n exponent.
   * @return result.
   */
  public float potenziere(float x, int n) {
    float acc = 1.0f;
    
    if (n == 0) {
      return 1;
    }
    for (int i = 0; i < n; i++) {
      acc = acc * x;
    }  
    return acc;
  }
  
  /** Calculates factorial.
  * @param x number to be used.
  * @return result.
  */
  public float berechneFak(float x) {
    float total = 1.0f;
    
    if (x == 0) {
      return 1.0f;
    }
    
    for (int i = 1; i <= x; i++) {
      total *= i; 
    }
    return total;
  }
  
  /** Calculates Cosinus.
   * @param x maybe the "a" value? I don't understand.
   * @param ordnung probably the "n" from the formula.
   * @return result.
   */
  public float berechneCosinus(float x, int ordnung) {
    float acc = 0.0f;
    float check = 0.0f;
    
    if (ordnung < 1) {
      return 0.0f;
    } else if (ordnung-1 % 2 != 0) {
      check = 0.0f;
    } else if (ordnung-1 % 4 == 0) {
      check = 1.0f;
    } else if (ordnung-1 % 4 != 0) {
      check = -1.0f;
    } 
    
    acc = (check / berechneFak(ordnung)) * potenziere(x, ordnung);
    
    return acc + berechneCosinus(x, ordnung - 1);
  }
	
	public static void main(String[] args) {
		Taylor t = new Taylor();
		
		float x = 3.14159265f / 2.0f;
		for(int ordnung=0; ordnung <15; ordnung++) {
		  System.out.println(ordnung + ". " + t.berechneCosinus(x, ordnung));
		}
		//System.out.println(t.berechneCosinus(x, 2));
		//System.out.println(t.berechneCosinus(x, 3));
		//System.out.println(t.berechneCosinus(x, 5));
		//System.out.println(t.berechneCosinus(x, 6));
		//System.out.println(t.berechneCosinus(x, 7));
		//System.out.println(t.berechneCosinus(x, 9));
		//System.out.println(t.berechneCosinus(x, 10));
		//System.out.println(t.berechneCosinus(x, 11));
		//System.out.println(t.berechneCosinus(x, 13));
		//System.out.println(t.berechneCosinus(x, 14));
	}

}
