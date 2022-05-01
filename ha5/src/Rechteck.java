public class Rechteck {
	private int laenge; // side
	private int breite; // height
	private int hypotenuse;
	private int perimeter;
	
	public void Rechteck (int x, int y) {
		this.laenge = x;
		this.breite = y;
	} 
	
	// Perimeter
	public int umfang () {
		
		int sideSquared = laenge * laenge; 
		int heightSquared = breite * breite;
		double sumSquaredSides = sideSquared + heightSquared;
		double dHypotenuse = Math.sqrt(sumSquaredSides);
		hypotenuse = (int) dHypotenuse;
		
		
		if (laenge > 0 && breite > 0 && hypotenuse > 0) {
			 perimeter = laenge + breite + hypotenuse;
		} else {
			 perimeter = 0;
		}
		
			return perimeter;
		
	}
	
	// area = (side * height) / 2
	public int flaeche () {
		int area = (laenge * breite) / 2;
		return area;
	}
	
	public boolean istQuadrat () {
		umfang();
		if ((laenge * laenge) + (breite * breite) == (hypotenuse * hypotenuse)) return true;
		return false;
	} 
	
	public int getLaenge() {
		return laenge;
	}
	
	public int getBreite() {
		return breite;
	}
	
	public int getHypotenuse() {
		umfang();
		return hypotenuse;
	}
	
	public void printPerimeter() {
		umfang();
		if((perimeter > 0) && (istQuadrat() == true)) {
			System.out.println("The triangle of sides " + getLaenge() + ", " + getBreite() + " and " + getHypotenuse() + " is Rectangle and has a Perimeter of " + umfang() + ".");
		} else {
			System.out.println("This is not a (right) triangle! It's not possible to calculate the Perimeter.");
		}
			
		
	}
	
	public void printArea() {
		umfang();
		if((perimeter > 0) && (istQuadrat() == true)) {
			System.out.println("The triangle of sides " + getLaenge() + ", " + getBreite() + " and " + getHypotenuse() + " is Rectangle and has an Area of " + flaeche() + ".");
		} else {
			System.out.println("This is not a (right) triangle! It's not possible to calculate the Area.");
		}
	}

}
