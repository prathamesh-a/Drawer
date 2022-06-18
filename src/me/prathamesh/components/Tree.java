package me.prathamesh.components;

import me.prathamesh.util.utils;

import java.awt.*;

public class Tree {

    private final Graphics2D g;

    public Tree(Graphics2D g) {
        this.g = g;
    }

    private void drawTree(int x, int y, double angle, int depth, int stroke, int red) throws InterruptedException {

        if (depth <= 0) return;
        if(stroke < 2) stroke = 2;

        int x2 = x + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);

        g.setStroke(new BasicStroke(stroke));
        g.setColor(new Color(red, 7, 7));
        g.drawLine(x, y, x2, y2);
        Thread.sleep(30);

        drawTree(x2, y2, angle - utils.getRandom(10, 40), utils.getRandom(depth-2,depth), utils.getRandom(stroke-3, stroke-1), red+10);
        drawTree(x2, y2, angle + utils.getRandom(10,40), utils.getRandom(depth-2,depth), utils.getRandom(stroke-3, stroke-1), red+10);
    }

    public void draw(int x, int y, int depth, int stroke) throws InterruptedException {
        drawTree(x, y, -90, depth, stroke, 25);
    }

    private void drawLeaf(int x1, int y1){
        if (y1 < 400){
            g.setColor(new Color(147, 243, 91));
            g.fillRoundRect(x1, y1, 7, 7, 25, 25);
        }
    }

}
