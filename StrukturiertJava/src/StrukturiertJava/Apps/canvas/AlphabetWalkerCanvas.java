package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlphabetWalkerCanvas extends JPanel {
    private int horizontal = 0;
    private int vertical = 0;
    private final char[] alphabet = new char[26];
    private final char[][] visitedLetters; // An array to store the letter for each cell

    public AlphabetWalkerCanvas() {
        char currentLetter = 'A';
        for (int i = 0; i < alphabet.length; i++, currentLetter++) {
            alphabet[i] = currentLetter;
        }

        visitedLetters = new char[10][10]; // Initialize the array to store visited letters

        Timer timer = new Timer(500, e -> repaint());
        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP && vertical > 0) {
                    vertical--;
                } else if (key == KeyEvent.VK_DOWN && vertical < 9) {
                    vertical++;
                } else if (key == KeyEvent.VK_LEFT && horizontal > 0) {
                    horizontal--;
                } else if (key == KeyEvent.VK_RIGHT && horizontal < 9) {
                    horizontal++;
                }

                if (visitedLetters[vertical][horizontal] == 0) {
                    visitedLetters[vertical][horizontal] = alphabet[visitedCount()];
                }

                repaint();
            }
        });
    }

    private int visitedCount() {
        int count = 0;
        for (char[] row : visitedLetters) {
            for (char letter : row) {
                if (letter != 0) {
                    count++;
                }
            }
        }
        return count%26;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 30;
        int startX = 20;
        int startY = 20;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (visitedLetters[i][j] != 0) {
                    g.setColor(Color.YELLOW); // Background in Yellow for visited cells
                } else {
                    g.setColor(Color.WHITE); // Background in White for unvisited cells
                }
                g.fillRect(startX + j * cellSize, startY + i * cellSize, cellSize, cellSize);

                if (visitedLetters[i][j] != 0) {
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(visitedLetters[i][j]), startX + j * cellSize + 10, startY + i * cellSize + 20);
                }
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
