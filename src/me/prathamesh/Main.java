package me.prathamesh;

import me.prathamesh.components.Ground;
import me.prathamesh.components.Sky;
import me.prathamesh.components.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main extends JFrame {

    public Main() {
        super("Drawer");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        g.setColor(new Color(129, 180, 245));
        g.fillRect(0, 0, 800, 600);

        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Sky(g);

        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Ground(g, 508);

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Tree tree = new Tree(g);
        try {
            tree.draw(400, 500, 10, 15);
            tree.draw(150, 500, 9, 11);
            tree.draw(615, 500, 7, 9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Ground(g,500);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
