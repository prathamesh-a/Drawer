package me.prathamesh.components;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Sky {

    private Graphics2D g;

    public Sky(Graphics2D g){
        this.g = g;
        draw();
    }

    private void draw(){
        g.setColor(new Color(129, 166, 245));
        Shape c1 = new Ellipse2D.Double(400-500, 600-300, 2*500, 2*300);
        g.fill(c1);
    }
}
