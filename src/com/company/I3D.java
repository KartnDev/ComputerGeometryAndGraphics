package com.company;

import java.awt.*;

public interface I3D {
    double[][] getMatrix();
    void drawSolid(Graphics g, double coef, double alpha);
    void rotateByX(double angle);
    void rotateByY(double angle);
    void rotateByZ(double angle);
    void scew(double scale);
    void scale(double scaleX, double scaleY, double scaleZ);
    void shift(double dx, double dy, double dz);
    Polygon toPolygon(double coef, double angel);

}
