
public class Main {
    public static void main(String[] args) {

        Flug f1 = new Flug("LAX111", 150);
        Flug f2 = new Flug("JFK222", 550);
        Flug f3 = new Flug("SYD222", 330);
        
        for (int i=1; i<=200; i++) {
            f1.einsteigen();
            f2.einsteigen();
            f3.einsteigen();
        }

        Flug.statistik();







        
        /*
        Rechteck r = new Rechteck(0.1,0.2,0.8,0.8);
        r.zeichne();

        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2); 
        */
            
    // Zentrum (x,y), Laenge der Strahlen l

        
        double x = 0.5;
        double y = 0.5;
        double l = 0.2;
        double a = 0.5 * l;
        double b = 0.5 * Math.sqrt(3) * l;                          
        stern(x,y,l);
        stern(x,y+l,l/3);
        stern(x,y-l,l/3);
        stern(x+b,y+a,l/3);
        stern(x-b,y+a,l/3);
        stern(x+b,y-a,l/3);
        stern(x-b,y-a,l/3);
    }

    public static void stern(double x, double y, double l) {
        // a und b sind die Koordinaten der vier "krummen Ecken"
        double a = 0.5 * l;
        double b = 0.5 * Math.sqrt(3) * l;               
        StdDraw.line(x,y+l,x,y-l);
        StdDraw.line(x+b,y+a,x-b,y-a);
        StdDraw.line(x-b,y+a,x+b,y-a);
        
    }
}
