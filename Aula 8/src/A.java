class A {
    public A() { n = 0; } // constructor 
    public A(int a) { n = a; } // constructor  
    public void f() { n++; } // mutates n  
    public void g() { f(); n = 2 * n; f(); } 
    // g mutates n directly and indirectly (f) 
    public int h() { return n; } // accessor of n  
    public void k() { System.out.println(n); } 
    // does not return, only prints, the value of n 
    private int n; // instance variable  

    public static void main(String[] args) {
        A a = new A(); // a.n is 0 
        A b = new A(2); // b.n is 2 
        A c = b; // c points where b points so c.n = b.n = 2 
        A d = new A(3); // d.n is 3  
        a.f(); // a.n is 1  
        b.g(); // b.n becomes 3, 6, then 7 
        c.f(); // c.n is b.n and it becomes 8 
        d.g(); // d.n becomes 4, 8, then 9 
        d.k(); // d.n is printed on a line by itself 
        A e = new A(a.h() // a.n is 1  
                    + b.h() // b.n is 8 and is equal to c.n   
                    + c.h() // which is 8 
                    ); // so e.n is set to 1 + 8 + 8 = 17 
        e.k(); // e.n (17) is printed on a line by itself   
    }
}
