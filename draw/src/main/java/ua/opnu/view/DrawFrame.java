package ua.opnu.view;

import ua.opnu.model.Circle;
import ua.opnu.model.Ellipse;
import ua.opnu.model.Rectangle;
import ua.opnu.model.Shape;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawFrame extends JFrame {

    private enum ShapeType { CIRCLE, RECTANGLE, ELLIPSE }

    private ShapeType currentShape = ShapeType.CIRCLE;
    private final List<Shape> shapes = new ArrayList<>();
    private int startX, startY, endX, endY;

    public DrawFrame() {
        setTitle("Draw App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Верхня панель з кнопками
        JPanel topPanel = new JPanel();
        BigTextButton circleBtn = new BigTextButton("Circle");
        BigTextButton rectBtn = new BigTextButton("Rectangle");
        BigTextButton ellipseBtn = new BigTextButton("Ellipse");
        BigTextButton clearBtn = new BigTextButton("Clear");

        topPanel.add(circleBtn);
        topPanel.add(rectBtn);
        topPanel.add(ellipseBtn);
        topPanel.add(clearBtn);

        add(topPanel, BorderLayout.NORTH);

        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        // Обробники подій кнопок
        circleBtn.addActionListener(e -> currentShape = ShapeType.CIRCLE);
        rectBtn.addActionListener(e -> currentShape = ShapeType.RECTANGLE);
        ellipseBtn.addActionListener(e -> currentShape = ShapeType.ELLIPSE);
        clearBtn.addActionListener(e -> {
            shapes.clear();
            drawingPanel.repaint();
        });
    }

    // Внутрішній клас для панелі малювання
    private class DrawingPanel extends JPanel {

        public DrawingPanel() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startX = e.getX();
                    startY = e.getY();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    endX = e.getX();
                    endY = e.getY();

                    int width = Math.abs(endX - startX);
                    int height = Math.abs(endY - startY);
                    int x = Math.min(startX, endX);
                    int y = Math.min(startY, endY);

                    Shape shape;

                    switch (currentShape) {
                        case RECTANGLE -> shape = new Rectangle(x, y, width, height, Color.BLUE);
                        case ELLIPSE -> shape = new Ellipse(x, y, width, height, Color.MAGENTA);
                        default -> shape = new Circle(x, y, width, height, Color.RED);
                    }

                    shapes.add(shape);
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape s : shapes) {
                s.draw(g);
            }
        }
    }
}
