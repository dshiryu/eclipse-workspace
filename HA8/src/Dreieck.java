public class Dreieck {
    private int seiteA, seiteB, seiteC;

    Dreieck (int a, int b, int c) {  
    	this.seiteA = a;
    	this.seiteB = b;
    	this.seiteC = c;
    }
    
    public String toString() {
        return "Dreieck("+ this.seiteA + "," + this.seiteB + "," + this.seiteC + "):";
    }
  
    public boolean istDreieck () {
        int max = Math.max(Math.max(seiteA, seiteB), seiteC); 
        return seiteA > 0 && seiteB > 0 && seiteC > 0 &&
            (max < seiteA + seiteB + seiteC - max); 
    }
    
    public boolean rechtwinklig() {
    	int a2 = this.seiteA * this.seiteA;
    	int b2 = this.seiteB * this.seiteB;
    	int c2 = this.seiteC * this.seiteC;
    	if (a2 + b2 == c2 || a2 + c2 == b2 || b2 + c2 == a2) return true;
        return false;
    } 

    public boolean gleichseitig() {
    	if (this.seiteA == this.seiteB && this.seiteA == this.seiteC) return true;
        return false;
    }
    
    public boolean gleichschenklig() {
    	if (this.seiteA == this.seiteB && this.seiteA != this.seiteC) return true;
    	if (this.seiteA == this.seiteC && this.seiteA != this.seiteB) return true;
    	if (this.seiteC == this.seiteB && this.seiteA != this.seiteC) return true;
        return false;
    }

    public void zeichne () { 
    	double a = this.seiteA;
    	double b = this.seiteB;
    	double c = this.seiteC;
    	a /= 10;
    	b /= 10;
    	c /= 10;
    	StdDraw.line(0.4,0.1,0.4,a);
    	StdDraw.line(0.4,0.1,c,0.1);
    	StdDraw.line(0.4,a,c,0.1);
    }
}
