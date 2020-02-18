package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private static int HEIGHT, WIDTH;
    private double alpha = 0;


    public Window(int width, int height){
        HEIGHT = height;
        WIDTH = width;

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 200, WIDTH, HEIGHT);
    }

    public void paint(Graphics g){
        while (true) {
            Draw(g, alpha);
            alpha += Math.PI / 60;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Draw(Graphics g, double alpha){
        BasePlatonicSolid solid = new Gexahedron(0, 0, 0,100);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        solid.rotateByZ(alpha);
        solid.shift(100, 100, 100);
        var points = solid.toPointsArray(0.6, Math.PI/4);

        for (int i = 0; i < 4; i++) {
            g.drawLine(points[i].x, points[i].y, points[i+1].x, points[i+1].y);
            g.drawLine(points[i].x, points[i].y, points[i+4].x, points[i+4].y);
            g.drawLine(points[i+4].x, points[i+4].y, points[i+5].x, points[i+5].y);
        }


    }


}



