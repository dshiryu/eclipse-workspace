
public class RPN {

	public static void main(String[] args) {
		System.out.println("Test:");
        test();
        System.out.println();   System.out.println();

	}
	
	public static void test() {
        Stack x = new Stack();
        System.out.println(x.isEmpty());
        x.push(1);
        x.push(2);
        x.push(3);
        x.pop();
        System.out.println(x.pop());
        x.push(4);
        x.push(5);
        while (!x.isEmpty())
            System.out.print(x.pop());
    }

}
