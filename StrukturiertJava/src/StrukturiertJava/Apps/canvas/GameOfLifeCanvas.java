package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;

public class GameOfLifeCanvas extends JPanel {
    private final int gridSize = 10; // Size of each cell in pixels
    private final int numRows;
    private final int numCols;
    private boolean[][] cells;

    public GameOfLifeCanvas(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.cells = new boolean[numRows][numCols];

        // Initialize the grid with random initial state (you can change this)
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                cells[row][col] = Math.random() < 0.5; // Randomly set cells to be alive or dead
            }
        }

        // Create a timer to update the simulation
        Timer timer = new Timer(500, e -> {
            updateGame();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (cells[row][col]) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(col * gridSize, row * gridSize, gridSize, gridSize);
            }
        }
    }

    public void updateGame() {
        boolean[][] newCells = new boolean[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int neighbors = countLivingNeighbors(row, col);

                if (cells[row][col]) {
                    // Cell is alive
                    newCells[row][col] = (neighbors == 2 || neighbors == 3);
                } else {
                    // Cell is dead
                    newCells[row][col] = (neighbors == 3);
                }
            }
        }

        cells = newCells;
    }

    public int countLivingNeighbors(int row, int col) {
        int count = 0;
        int[][] neighbors = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},           {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] neighbor : neighbors) {
            int r = row + neighbor[0];
            int c = col + neighbor[1];

            if (r >= 0 && r < numRows && c >= 0 && c < numCols) {
                if (cells[r][c]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int numRows = 30; // Default number of rows
        String input = JOptionPane.showInputDialog("Enter the number of rows:");
        if (input != null && !input.isEmpty()) {
            try {
                numRows = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Using default value.");
            }
        }

        int numCols = 30; // Number of columns in the grid

        JFrame frame = new JFrame("Game of Life Canvas");
        GameOfLifeCanvas canvas = new GameOfLifeCanvas(numRows, numCols);
        frame.add(canvas);
        frame.setSize(numCols * canvas.gridSize, numRows * canvas.gridSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
