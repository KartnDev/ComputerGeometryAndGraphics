package com.company;

import java.awt.*;

public interface I3D {
    double[][] getMatrix();
    void drawMatrix();
    void rotateByX();
    void rotateByY();
    void rotateByZ();
    Polygon toPolygon(double coef);
}
