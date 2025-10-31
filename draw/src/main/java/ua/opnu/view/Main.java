package ua.opnu.view;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawFrame frame = new DrawFrame();
            frame.setVisible(true);
        });
    }
}
