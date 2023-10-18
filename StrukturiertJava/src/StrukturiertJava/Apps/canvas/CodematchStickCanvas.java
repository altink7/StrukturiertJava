package StrukturiertJava.Apps.canvas;

import javax.swing.*;
import java.awt.*;

public class CodematchStickCanvas extends JPanel {
    private int sticks = 30;
    private int input;
    private int sticks2 = 30;
    private int input2;

    public CodematchStickCanvas() {
        Timer timer = new Timer(1000, e -> {
            if (sticks > 0) {
                input = (int) (Math.random() * 3) + 1;
                sticks -= input;
            }
            if (sticks2 > 0) {
                input2 = (int) (Math.random() * 3) + 1;
                sticks2 -= input2;
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int startX = 20;
        int startY = 20;
        int stickWidth = 20;

        for (int i = 0; i < sticks; i++) {
            g.fillRect(startX + i * stickWidth, startY, 10, 80);
        }

        for (int i = 0; i < sticks2; i++) {
            g.fillRect(startX + i * stickWidth, startY + 100, 10, 80);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CodematchStickCanvas");
        CodematchStickCanvas canvas = new CodematchStickCanvas();
        frame.add(canvas);
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
