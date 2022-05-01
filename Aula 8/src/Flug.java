public class Flug {
    // Klassen-Attribut (fuer ALLE Objekte gleich)
    private static int allePax;
    private static  int alleFluege;
    
    // Objekt-Attribut
    private String name;
    private int pax;
    private int capacity;

    // Konstruktor
    public Flug (String flugname, int capa) {
        name = flugname;
        pax = 0;
        capacity = capa;
        alleFluege++; 
    }

    // Objekt-Methode
    public void einsteigen() {
        if (pax < capacity) {
            pax++;
            allePax++;
        }
    }

    // Klassen-Methode
    public static void statistik() {
        System.out.println("Gesamtzahl Paxe: "    + allePax);
        System.out.println("Anzahl Fluege: " + alleFluege);       
    }


}
