public class Land {
    private String name;
    private long inhabitants;
    private int area;
    static long maxInhabitants;

    public Land(String n, long e, int f) {
    	this.name = n;
    	this.inhabitants = e;
    	this.area = f;
    	if (e > maxInhabitants) {
    		maxInhabitants = e;
    	}
    }

    public String toString() { return this.name + "\nEinwohner: " + this.inhabitants + "\nFlaeche: " + this.area + " qkm\n"; }

    public double dichte() { return this.inhabitants/this.area; }

    public static long maxEinwohner() { return maxInhabitants; }
}
