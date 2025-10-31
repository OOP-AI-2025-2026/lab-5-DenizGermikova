package ua.opnu.polymorphism;

public class MainTimeSpan {
    public static void main(String[] args) {
        System.out.println("=== TimeSpan tests ===");
        TimeSpan a = new TimeSpan();            // 00:00
        TimeSpan b = new TimeSpan(75);          // 01:15
        TimeSpan c = new TimeSpan(2, 50);       // 02:50
        TimeSpan d = new TimeSpan(c);           // копія 02:50

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        a.add(1, 20);   // 01:20
        System.out.println("a + 1:20 = " + a);

        b.add(50);      // 01:15 + 50 хв = 02:05
        System.out.println("b + 50 мин = " + b);

        c.add(b);       // 02:50 + 02:05 = 04:55
        System.out.println("c + b = " + c);

        c.subtract(0, 60); // 03:55
        System.out.println("c - 0:60 = " + c);

        d.subtract(180); // віднімання хвилин: 02:50 - 3год = 0 (не від'ємне) => 00:00
        System.out.println("d - 180 мин = " + d);
    }
}
