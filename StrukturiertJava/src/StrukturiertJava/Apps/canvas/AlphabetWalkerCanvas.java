package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlphabetWalkerCanvas extends JPanel {
    private int horizontal = 0;
    private int vertical = 0;
    private final char[] alphabet = new char[26];
    private int currentLetter = 0; // Aktueller Buchstabe als numerischer Wert
    private final boolean[][] visited; // Ein Feld, um zu verfolgen, welche Felder besucht wurden

    public AlphabetWalkerCanvas() {
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        visited = new boolean[10][10]; // Initialisiere das Feld für die Besuche

        Timer timer = new Timer(500, e -> {
            // Repaint
            repaint();
        });
        timer.start();

        setFocusable(true); // Aktiviere die Tastaturfokussierung
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Behandle die Benutzereingabe, um den Walker zu bewegen
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

                if (!visited[vertical][horizontal]) {
                    visited[vertical][horizontal] = true;
                    if (currentLetter < 25) {
                        currentLetter++;
                    }
                }

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = 30;
        int startX = 20;
        int startY = 20;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (visited[i][j]) {
                    g.setColor(Color.YELLOW); // Hintergrund in Gelb für besuchte Felder
                } else {
                    g.setColor(Color.WHITE); // Hintergrund in Weiß für nicht besuchte Felder
                }
                g.fillRect(startX + j * cellSize, startY + i * cellSize, cellSize, cellSize);

                if (i == vertical && j == horizontal) {
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(alphabet[currentLetter]), startX + j * cellSize + 10, startY + i * cellSize + 20);
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
