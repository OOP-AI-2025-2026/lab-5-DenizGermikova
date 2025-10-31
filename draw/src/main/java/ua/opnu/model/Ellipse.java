package ua.opnu.model;

import java.awt.*;

public class Ellipse extends Shape {

    public Ellipse(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, width, height);
    }
}
