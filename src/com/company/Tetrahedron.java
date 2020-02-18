package com.company;

import com.company.utils.math.MatrixUtils;

import java.awt.*;
import java.awt.geom.Point2D;

public class Tetrahedron extends BasePlatonicSolid implements I3D{

    private double matrix[][];

    private int centerPlateX; // central point of base(footage) tetrahedron
    private int centerPlateY;
    private int centerPlateZ;
    private int imaginaryRadius;

    public Tetrahedron(int centerPlateOfX, int centerPlateOfY, int centerPlateOfZ, int imaginaryRadius){
        super(centerPlateOfX, centerPlateOfY, centerPlateOfZ, imaginaryRadius);
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
}
