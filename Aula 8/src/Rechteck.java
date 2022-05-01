
public class Rechteck {

    // unten links (x1,y1)
    // oben rechts (x2,y2)
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public Rechteck(double a, double b, double c, double d) {

        // Konstruktor
        // Wenn Koordinaten fehlerhaft, nimm Einheitsquadtrat
        if ( ( c > a ) && (d > b) ) {
            x1 = a;
            y1 = b;
            x2 = c;
            y2 = d;
        } else {
            x1 = 0;
            y1 = 0;
            x2 = 1;
            y2 = 1;
        }
    }

    public void zeichne( ) {
        StdDraw.line(x1,y1,x2,y1);
        StdDraw.line(x2,y1,x2,y2);
        StdDraw.line(x2,y2,x1,y2);
        StdDraw.line(x1,y2,x1,y1);
    }
    

}
