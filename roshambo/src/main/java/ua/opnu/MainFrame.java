package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JTextArea resultArea;

    public MainFrame() {
        super("Гра RoShamBo (Камінь-Ножиці-Папір)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 16));
        resultArea.setMargin(new Insets(10, 10, 10, 10));

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    // Метод генерує випадкову фігуру комп’ютера
    public GameShape generateShape() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            default:
                return new Scissors();
        }
    }

    // Обробка натискання кнопок
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        GameShape playerShape = null;

        if (command.equals("Rock")) {
            playerShape = new Rock();
        } else if (command.equals("Paper")) {
            playerShape = new Paper();
        } else if (command.equals("Scissors")) {
            playerShape = new Scissors();
        }

        GameShape computerShape = generateShape();
        int result = checkWinner(playerShape, computerShape);

        String message = "Гравець обрав: " + playerShape.getName() +
                "\nКомп'ютер обрав: " + computerShape.getName() + "\n";

        if (result == 1) {
            message += "Ви виграли!";
        } else if (result == -1) {
            message += "Комп’ютер виграв!";
        } else {
            message += "Нічия!";
        }

        resultArea.append(message + "\n\n");
    }

    // Метод визначає переможця
    public int checkWinner(GameShape player, GameShape computer) {
        if (player.getClass() == computer.getClass()) {
            return 0; // нічия
        }

        if (player instanceof Rock && computer instanceof Scissors
                || player instanceof Scissors && computer instanceof Paper
                || player instanceof Paper && computer instanceof Rock) {
            return 1; // виграв гравець
        }

        return -1; // виграв комп'ютер
    }
}
