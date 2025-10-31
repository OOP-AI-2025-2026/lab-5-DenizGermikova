package ua.opnu.polymorphism;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Person / Student / Lecturer demo ===");

        Person[] arr = new Person[4];
        arr[0] = new Person("Коваль", "Ірина", 35);
        arr[1] = new Student("Сидоренко", "Олег", 20, "КН-321", "ST12345");
        arr[2] = new Lecturer("Петренко", "Марія", 45, "Інформатики", 25000.0);
        arr[3] = new Student("Бондар", "Аня", 19, "КН-322", "ST54321");

        for (Person p : arr) {
            System.out.println(p.toString());
        }
    }
}
