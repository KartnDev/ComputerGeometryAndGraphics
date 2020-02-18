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
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Draw(Graphics g, double alpha){
        BasePlatonicSolid solid = new Tetrahedron(0, 0, 0,100);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        //solid.rotateByZ(alpha);
        solid.rotateByX(alpha);
        //solid.rotateByY(alpha);
        solid.shift(230, 230, 100);
        solid.drawSolid(g, 0.6, Math.PI/4);
    }


}



