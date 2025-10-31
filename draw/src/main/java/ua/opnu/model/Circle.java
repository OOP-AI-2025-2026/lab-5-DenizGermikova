package ua.opnu.model;

import java.awt.*;

public class Circle extends Shape {

    public Circle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int size = Math.min(width, height);
        g.drawOval(x, y, size, size);
    }
}
