public class Stack {
    private Node top;
    
    // Konstruktor erzeugt nur den leeren Stack
    public Stack () {
        top = null;
    }

    // Oberstes Element runternehmen vom Stack
    public int pop() {
        int c = top.getElement();
        top = top.getNext();
        return c;       
    }

    // Neues Element obendrauf legen
    public void push(int c) {
        top = new Node(c,top);
    }

    // Auf Leerheit testen
    public boolean isEmpty() {
        return top == null;
    }

}
