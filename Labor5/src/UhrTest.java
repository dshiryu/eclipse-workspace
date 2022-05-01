public class UhrTest {

    public static void main(String[] args) {
        Uhr u = new Uhr();
        u.status();       // Die Uhr zeigt 0
        u.tick();
        u.status();       // Die Uhr zeigt 1
        for (int i = 1; i <= 12; i++) {
            u.tick();
        }
        u.status();       // Die Uhr zeigt 13
        u.switchMode();
        u.status();       // Die Uhr zeigt 1
        for (int i=1; i <= 10; i++) { u.tick(); } 
        u.status();       // Die Uhr zeigt 11
        u.switchMode();
        u.status();       // Die Uhr zeigt 23
        u.sommerzeit();
        u.status();       // Die Uhr zeigt 0
        u.tick();
        u.status();       // Die Uhr zeigt 1
        u.winterzeit();
        u.status();       // Die Uhr zeigt 0
        u.switchMode();
        u.status();       // Die Uhr zeigt 12
    }


}