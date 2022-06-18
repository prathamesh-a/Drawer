package me.prathamesh.components;

import me.prathamesh.util.utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Tree {

    private final Graphics2D g;
    private final ArrayList<Color> greenShades;

    public Tree(Graphics2D g) {
        this.g = g;
        this.greenShades = new ArrayList<>();
        fillGreenShades();
    }

    private void drawTree(int x, int y, double angle, int depth, int stroke, int red) throws InterruptedException {

        if (depth <= 0) return;
        if(stroke < 2) stroke = 2;

        int x2 = x + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);

        g.setStroke(new BasicStroke(stroke));
        g.setColor(new Color(red, 7, 7));
        g.drawLine(x, y, x2, y2);
        drawLeaf(x, y, depth);
        Thread.sleep(30);

        drawTree(x2, y2, angle - utils.getRandom(10, 40), utils.getRandom(depth-2,depth), utils.getRandom(stroke-3, stroke-1), red+10);
        drawTree(x2, y2, angle + utils.getRandom(10,40), utils.getRandom(depth-2,depth), utils.getRandom(stroke-3, stroke-1), red+10);
    }

    public void draw(int x, int y, int depth, int stroke) throws InterruptedException {
        drawTree(x, y, -90, depth, stroke, 25);
    }

    private void drawLeaf(int x1, int y1, int depth){
        if (depth < 4){
            drawLeaves(x1, y1, utils.getRandom(7, 14));
        }
    }

    private void drawLeaves(int x, int y, int amount){
        if (amount <= 0) return;
        g.setColor(greenShades.get(utils.getRandom(0, greenShades.size())));
        Shape s = new Ellipse2D.Double(x, y, utils.getRandom(10, 20), utils.getRandom(5, 10));
        g.fill(s);
        drawLeaves(x+utils.getRandom(-15, 15), y+utils.getRandom(-7, 7), amount-1);
    }

    private void fillGreenShades(){

        int rand = utils.getRandom(1, 10);

        if (rand < 5){
            greenShades.add(new Color(27, 75, 7));
            greenShades.add(new Color(33, 98, 10));
            greenShades.add(new Color(46, 129, 14));
            greenShades.add(new Color(59, 164, 17));
        }

        else{
            greenShades.add(new Color(208, 47, 184));
            greenShades.add(new Color(225, 75, 203));
            greenShades.add(new Color(136, 27, 125));
            greenShades.add(new Color(241, 117, 221));
        }
    }
}
