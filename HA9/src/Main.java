public class Main {

    public static void print(int[] arr) {
        for (int i=0; i<arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[][] beispiel =
    { {123, 12345, 7},
      {76543,49,99999},
      {1,2,333}  };
    
    public static void main(String[] args) {
        Felder2D.potenzen();
    	Felder2D.prettyPrint(Felder2D.primzahlen);
        System.out.println();
        Felder2D.prettyPrint(Felder2D.potenzen());
        System.out.println();
        Felder2D.prettyPrint(beispiel);
        System.out.println();
        Felder2D.prettyPrint(Felder2D.transpose(beispiel));
        print(Felder2D.maxe(Felder2D.primzahlen));
        System.out.println();
        print(Felder2D.maxe(Felder2D.potenzen()));
        System.out.println();
        print(Felder2D.maxe(beispiel));
    }
}
