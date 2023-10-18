package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class DiagonaleCanvas extends JPanel {
    private int x;

    public DiagonaleCanvas(int x) {
        this.x = x;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int fix = x; // Sterne from Left
        int m = x; // Sterne from Right
        int startY = 20;

        for (int n = x; n > 0; n--) {
            for (int i = x; i > 0; i--) {
                int startX = 20 + (x - i) * 20;
                g.drawString((fix - i == 0) || (m - fix == i - 1) ? "*" : "-", startX, startY);
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

        JFrame frame = new JFrame("DiagonaleCanvas");
        DiagonaleCanvas canvas = new DiagonaleCanvas(x);
        frame.add(canvas);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
