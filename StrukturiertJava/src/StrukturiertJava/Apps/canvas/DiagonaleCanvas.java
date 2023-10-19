package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class DiagonaleCanvas extends JPanel {
    private final int x;
    private final char symbol;
    private final char space;

    public DiagonaleCanvas(int x, char symbol, char space) {
        this.x = x;
        this.symbol = symbol;
        this.space = space;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int fix = x; // Sterne from Left
        int startY = 20;

        for (int n = x; n > 0; n--) {
            for (int i = x; i > 0; i--) {
                int startX = 20 + (x - i) * 20;
                g.drawString((fix - i == 0) || (x - fix == i - 1) ? String.valueOf(symbol) : String.valueOf(space), startX, startY);
            }
            startY += 20;
            fix--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an odd number: ");
        int x = sc.nextInt();
        while (x % 2 == 0 || x < 1) {
            System.out.println("Please enter an odd number: ");
            x = sc.nextInt();
        }
        System.out.println("Enter a symbol: ");
        char symbol = sc.next().charAt(0);

        System.out.println("Enter a space: ");
        char space = sc.next().charAt(0);

        JFrame frame = new JFrame("DiagonaleCanvas");
        DiagonaleCanvas canvas = new DiagonaleCanvas(x, symbol, space);
        frame.add(canvas);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
