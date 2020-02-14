package com.company;

import com.company.utils.math.MatrixUtils;

import java.awt.*;
import java.awt.geom.Point2D;

public class Tetrahedron implements I3D{

    private double matrix[][];

    private int centerPlateX; // central point of base(footage) tetrahedron
    private int centerPlateY;

    private int imaginaryRadius;

    public Tetrahedron(int centerPlateOfX, int centerPlateOfY, int centerPlateOfZ, int imaginaryRadius){
        this.centerPlateX = centerPlateOfX;
        this.centerPlateY = centerPlateOfY;
        this.imaginaryRadius = imaginaryRadius;
        matrix = new double[4][3];

        //expending plate of tetrahedron with polar system coordinates as 2PI/3 4PI/3 and 6PI/3 ( or 0) ->
        // the equilateral triangle on plate

        for(double tetaAngular = 0, i = 0; tetaAngular < 2 * Math.PI; tetaAngular += 2 * Math.PI / 3, i++){
            matrix[(int)i][0] = centerPlateOfX + imaginaryRadius*Math.cos(tetaAngular);
            matrix[(int)i][1] = centerPlateOfY + imaginaryRadius*Math.sin(tetaAngular);
            matrix[(int)i][2] = centerPlateOfZ;
        }

        // expand last top point with default decart system

        matrix[3][0] = centerPlateX;
        matrix[3][1] = centerPlateY;
        matrix[3][2] = centerPlateOfZ +
                Math.sqrt(12 * imaginaryRadius*imaginaryRadius
                        - centerPlateOfX*centerPlateOfX
                        - centerPlateOfY*centerPlateOfY);
    }
    @Override
    public String toString(){
        var result = "";
        for(int i = 0; i < matrix.length; i++){
            result += "X" + i + "=" + matrix[i][0] + ", Y" + i + "=" + matrix[i][1] + "Z" + i + "=" + matrix[i][2];
        }
        return result;
    }

    @Override
    public double[][] getMatrix() {
        return matrix;
    }

    @Override
    public void drawMatrix() {

    }

    @Override
    public void rotateByX() {

    }

    @Override
    public void rotateByY() {

    }

    @Override
    public void rotateByZ() {

    }


    public void rotateByX(double angle) {
        matrix = MatrixUtils.matrixMultiply(matrix,new double[][] {{1,      0              ,    0},
                                                                  {0,       Math.cos(angle),    Math.sin(angle)},
                                                                  {0,       -Math.sin(angle),    Math.cos(angle)}});
    }



    public void rotateByY(double angle) {
        matrix = MatrixUtils.matrixMultiply(matrix,new double[][] {{Math.cos(angle),      0              ,    Math.sin(angle)},
                                                                  {0,                     1              ,    0},
                                                                  {-Math.sin(angle),      0              ,    Math.cos(angle)}});
    }


    public void rotateByZ(double angle) {
        matrix = MatrixUtils.matrixMultiply(matrix,new double[][] {{Math.cos(angle),    Math.sin(angle) ,    0},
                                                                  {-Math.sin(angle),    Math.cos(angle) ,    0},
                                                                  {0,                   0               ,    1}});

    }

    @Override
    public Polygon toPolygon(double coef) {
        return null;
    }

    public void shift(double dx, double dy, double dz){
        matrix = MatrixUtils.matrixShift(matrix, new double[]{dx, dy, dz});
    }




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



}
