package ua.opnu.polymorphism;

/**
 * Представляє часовий інтервал у годинах та хвилинах.
 * Підтримує перевантажені конструктори та методи add / subtract.
 */
public class TimeSpan {
    private int hours;
    private int minutes;

    // Конструктор без аргументів -> 00:00
    public TimeSpan() {
        this(0, 0);
    }

    // Конструктор з 1 аргументом (хвилини)
    public TimeSpan(int minutes) {
        this(0, minutes);
    }

    // Конструктор з 2 аргументів (години, хвилини)
    public TimeSpan(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        normalize();
    }

    // Конструктор копіювання
    public TimeSpan(TimeSpan other) {
        this(other.hours, other.minutes);
    }

    // --- Додавання ---
    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void add(int minutes) {
        add(0, minutes);
    }

    public void add(TimeSpan other) {
        add(other.hours, other.minutes);
    }

    // --- Віднімання ---
    public void subtract(int hours, int minutes) {
        this.hours -= hours;
        this.minutes -= minutes;
        normalize();
    }

    public void subtract(int minutes) {
        subtract(0, minutes);
    }

    public void subtract(TimeSpan other) {
        subtract(other.hours, other.minutes);
    }

    // --- Нормалізація (перевід хвилин в години; корекція від'ємних значень) ---
    private void normalize() {
        // привід хвилин у нормальний діапазон
        if (minutes >= 60 || minutes <= -60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }

        // Якщо хвилини від'ємні, "позичаємо" години
        if (minutes < 0) {
            hours -= 1;
            minutes += 60;
        }

        // Години не можуть бути від'ємними у цій реалізації:
        if (hours < 0) {
            hours = 0;
            minutes = 0;
        }
    }

    // --- Гетери / сетери ---
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = Math.max(0, hours);
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        normalize();
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }
}
