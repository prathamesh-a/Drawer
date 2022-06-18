package me.prathamesh.components;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ground {

    private Graphics2D g;
    private int y;

    public Ground(Graphics2D g, int y){
        this.g = g;
        this.y = y;
        draw();
    }

    private void draw(){
        g.setColor(new Color(22, 47, 21));
//        Shape bg = new Ellipse2D.Double(440, 500, 1000, 200);
//        g.fill(bg);
//        Shape bg2 = new Ellipse2D.Double(-250, 490, 1000, 200);
//        g.fill(bg2);
        g.fillRect(0, y, 800, 150);
    }
}
