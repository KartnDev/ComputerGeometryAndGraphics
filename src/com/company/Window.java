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
        Draw(g, alpha);
        var timer = new Timer(500, new ActionListener(){      // Timer 4 seconds
            public void actionPerformed(ActionEvent e) {
                alpha += Math.PI/60;
                if(alpha > 2*Math.PI){
                    alpha = 0;

                }
                repaint();
            }
        });
        timer.start();

    }

    public void Draw(Graphics g, double alpha){
        Tetrahedron tetrahedron = new Tetrahedron(0, 0, 0,100);
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        tetrahedron.getMatrix();
        tetrahedron.rotateByZ(alpha);
        tetrahedron.shift(100, 100, 100);
        var points = tetrahedron.toPointsArray(0.6, Math.PI/4);

        for (int i = 0; i < points.length -2; i++) {
            g.drawLine(points[i].x, points[i].y, points[i+1].x, points[i+1].y);
            g.drawLine(points[i].x, points[i].y, points[3].x, points[3].y);
        }
        g.drawLine(points[0].x, points[0].y, points[2].x, points[2].y);
        g.drawLine(points[2].x, points[2].y, points[3].x, points[3].y);

    }


}



