package com.company;

import java.awt.*;

public interface I3D {
    double[][] getMatrix();
    void rotateByX(double angle);
    void rotateByY(double angle);
    void rotateByZ(double angle);
    void shift(double dx, double dy, double dz);
    Polygon toPolygon(double coef, double angel);

}
