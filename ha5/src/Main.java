
public class Main {

	public static void main(String[] args) {
		
		Dreieck abc = new Dreieck();
		
		abc.Dreieck(7.0f, 100.0f, 7.0f);
		abc.checkTriangle();
		
		abc.Dreieck(10.0f, 10.0f, 10.0f);
		abc.checkTriangle();
		
		abc.Dreieck(9000000f, 50000.0f, 3000.0f);
		abc.checkTriangle();
		
		abc.Dreieck(3.0f, 4.0f, 5.0f);
		abc.checkTriangle();
		
		abc.Dreieck(-1.0f, 5.0f, 10.0f);
		abc.checkTriangle();
		
		
		
		Rechteck bla = new Rechteck();
		bla.Rechteck(3, 4);
		bla.printPerimeter();
		bla.printArea();
		
		bla.Rechteck(3, 0);
		bla.printPerimeter();
		bla.printArea();
		
		bla.Rechteck(3, 3);
		bla.printPerimeter();
		bla.printArea();
		
		
	}

}
