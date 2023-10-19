package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlphabetWalkerCanvas extends JPanel {
    public static final int SIZE = 800;
    public static final int BLOCK = 20;
    private int horizontal = 0;
    private int vertical = 0;
    private final char[] alphabet = new char[26];
    private final char[][] visitedLetters; // An array to store the letter for each cell

    public AlphabetWalkerCanvas() {
        char currentLetter = 'A';
        for (int i = 0; i < alphabet.length; i++, currentLetter++) {
            alphabet[i] = currentLetter;
        }

        visitedLetters = new char[BLOCK][BLOCK]; // Initialize the array to store visited letters

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

        int cellSize = 60;
        int startX = 40;
        int startY = 40;

        for (int i = 0; i < BLOCK; i++) {
            for (int j = 0; j < BLOCK; j++) {
                if (visitedLetters[i][j] != 0) {
                    g.setColor(Color.YELLOW); // Background in Yellow for visited cells
                } else {
                    g.setColor(Color.WHITE); // Background in White for unvisited cells
                }
                g.fillRect(startX + j * cellSize, startY + i * cellSize, cellSize, cellSize);

                if (visitedLetters[i][j] != 0) {
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(visitedLetters[i][j]), startX + j * cellSize + BLOCK, startY + i * cellSize + 20);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Alphabet Walker");
        AlphabetWalkerCanvas canvas = new AlphabetWalkerCanvas();
        frame.add(canvas);
        frame.setSize(SIZE, SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
