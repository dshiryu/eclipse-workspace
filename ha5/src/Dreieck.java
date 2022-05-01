public class Dreieck {
	private float a; //kathete1
	private float b; //kathete2
	private float c; //hypotenuse
	
	public void Dreieck (float a, float b, float c) { 
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
	//isosceles
	//here considering the case that only 2 sides equal consists of isosceles, in some cases it needs "at least" two sides equal, i.e. equilateral is isosceles
	public boolean gleichschenklig() {
		if((c > 0 && a > 0 && b > 0) && ((c == a && c != b && a != b) || (c != a && c == b && a != b) || (c != a && c != b && a == b)) ) return true;
					
			return false;
	}
	
	//equilateral
	// all sides are more than zero, two sides are equal and the third not
	public boolean gleichseitig() {
		if ((c > 0 && a > 0 && b > 0) && (c == a && c == b && a == b) ) return true;
		
		return false;
	}
	
	// right triangle
	//the sum of the square of the cathetus is equals to the square of the hypotenuse
	//a^2 + b^2 = c^2 (or variations of which side is really the hypotenuse, in this case)
	public boolean rechtwinklig() {
		float aa = a * a; // a^2
		float bb = b * b; // b^2
		float cc = c * c; // c^2
		float ab = aa + bb; // a^2 + b^2
		float ac = aa + cc; // a^2 + c^2
		float bc = bb + cc; // b^2 + c^2
		
		if((c > 0 && a > 0 && b > 0) && (ab == cc || ac == bb || bc == aa) ) return true;
				
		return false;
	}

	public float getSideA() {
		return a;
	}
	
	public float getSideB() {
		return b;
	}
	
	public float getSideC() {
		return c;
	}
	
	public boolean negativ() {
		if ((a < 1 || b < 1 || c < 1)) return true;
		return false;
	}
	
	public void checkTriangle() {
		if (gleichschenklig() == true) {
			System.out.println("The triangle of sides A = " + getSideA() + ", B = " + getSideB() + " and C = " + getSideC() + " is Isosceles.");
		} else if (gleichseitig() == true) {
			System.out.println("The triangle of sides A = " + getSideA() + ", B = " + getSideB() + " and C = " + getSideC() + " is Equilateral.");
		} else if (rechtwinklig() == true) {
			System.out.println("The triangle of sides A = " + getSideA() + ", B = " + getSideB() + " and C = " + getSideC() + " is Retangle.");
		} else if(negativ() == true){
			System.out.println("This is not a triangle, it has one or more sides equal to zero or negative.");
		} else {
			System.out.println("The triangle of sides A = " + getSideA() + ", B = " + getSideB() + " and C = " + getSideC() + " is Scalene.");
		}
	}
}