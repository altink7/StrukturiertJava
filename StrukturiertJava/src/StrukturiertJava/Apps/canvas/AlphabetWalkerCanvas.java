package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;

public class AlphabetWalkerCanvas extends JPanel {
    private int horizontal = 0;
    private int vertical = 0;
    private int alphabetCounter = 1;
    private final char[] alphabet = new char[26];

    public AlphabetWalkerCanvas() {
        char currentLetter = 'A';
        for (int i = 0; i < alphabet.length; i++, currentLetter++) {
            alphabet[i] = currentLetter;
        }

        Timer timer = new Timer(500, e -> {
            if (horizontal > 9 || horizontal < 0 || vertical < 0 || vertical > 9) {
                horizontal = 0;
                vertical = 0;
            } else {
                alphabetCounter++;
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 30;
        int startX = 20;
        int startY = 20;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                char cellLetter = alphabet[alphabetCounter % 26];
                if (i == vertical && j == horizontal) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.drawRect(startX + j * cellSize, startY + i * cellSize, cellSize, cellSize);
                g.drawString(String.valueOf(cellLetter), startX + j * cellSize + 10, startY + i * cellSize + 20);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Alphabet Walker");
        AlphabetWalkerCanvas canvas = new AlphabetWalkerCanvas();
        frame.add(canvas);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
