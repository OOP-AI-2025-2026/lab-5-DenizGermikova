package ua.opnu.view;

import javax.swing.*;
import java.awt.*;

public class BigTextButton extends JButton {
    public BigTextButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 16));
    }
}
