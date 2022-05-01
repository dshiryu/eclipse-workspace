public class Node {
    private int element;
    private Node next;

    public Node (int x) {
        element = x;
        next = null;
    }

    public Node (int x, Node n) {
        element = x;
        next = n;
    }

    public int getElement() {
        return element;
    }
    
    public Node getNext() {
        return next;
    }
}
