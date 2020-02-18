package com.company;

import com.company.utils.math.MatrixUtils;

import java.awt.*;

public abstract class BasePlatonicSolid implements I3D{
    protected double matrix[][];

    protected int centerPlateX; // central point of base(footage) tetrahedron
    protected int centerPlateY;
    protected int centerPlateZ;

    protected int imaginaryRadius;

    public BasePlatonicSolid(int centerPlateOfX, int centerPlateOfY, int centerPlateOfZ, int imaginaryRadius) {
        this.centerPlateX = centerPlateOfX;
        this.centerPlateY = centerPlateOfY;
        this.centerPlateZ = centerPlateOfZ;
        this.imaginaryRadius = imaginaryRadius;
    }
    @Override
    public double[][] getMatrix() {
        if (matrix != null ) {
            return matrix;
        } else {
            throw new NullPointerException("Does not contain reference to this matrix array! ");
        }
    }


    @Override
    public void rotateByX(double angle) {
        matrix = MatrixUtils.matrixMultiply(matrix,new double[][] {{1,      0              ,    0},
                                                                  {0,       Math.cos(angle),    Math.sin(angle)},
                                                                  {0,       -Math.sin(angle),    Math.cos(angle)}});
    }


    @Override
    public void rotateByY(double angle) {
        matrix = MatrixUtils.matrixMultiply(matrix,new double[][] {{Math.cos(angle),      0              ,    Math.sin(angle)},
                                                                  {0,                     1              ,    0},
                                                                  {-Math.sin(angle),      0              ,    Math.cos(angle)}});
    }

    @Override
    public void rotateByZ(double angle) {
        matrix = MatrixUtils.matrixMultiply(matrix,new double[][] {{Math.cos(angle),    Math.sin(angle) ,    0},
                                                                  {-Math.sin(angle),    Math.cos(angle) ,    0},
                                                                  {0,                   0               ,    1}});

    }


    @Override
    public void shift(double dx, double dy, double dz){
        matrix = MatrixUtils.matrixShift(matrix, new double[]{dx, dy, dz});
    }

    @Override
    public Polygon toPolygon(double coef, double alpha) {
        var xArray = new int[matrix.length];
        var yArray = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            xArray[i] = (int)(matrix[i][0] + coef * Math.cos(alpha) * matrix[i][2]);
            yArray[i] = (int)(matrix[i][1] + coef * Math.cos(alpha) * matrix[i][2]);
        }
        return new Polygon(xArray, yArray, matrix.length);
    }

    public Point[] toPointsArray(double coef, double alpha){
        var poly = this.toPolygon(coef, alpha);
        Point[] points = new Point[poly.npoints];
        for (int i = 0; i < poly.npoints; i++) {
            points[i] = new Point(poly.xpoints[i], poly.ypoints[i]);
        }
        return points;
    }

    @Override
    public String toString(){
        var result = "";
        for(int i = 0; i < matrix.length; i++){
            result += "X" + i + "=" + matrix[i][0] + ", Y" + i + "=" + matrix[i][1] + "Z" + i + "=" + matrix[i][2];
        }
        return result;
    }


}
