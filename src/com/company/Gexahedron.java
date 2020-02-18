package com.company;

import java.awt.*;

public class Gexahedron extends BasePlatonicSolid implements I3D{


    public Gexahedron(int centerPlateOfX, int centerPlateOfY, int centerPlateOfZ, int imaginaryRadius){
        super(centerPlateOfX, centerPlateOfY, centerPlateOfZ, imaginaryRadius);
        matrix = new double[8][3];


        for(double teta = 0, i = 0; teta < Math.PI*2; teta+= Math.PI/2, i++){
            matrix[(int)i][0] = centerPlateOfX + imaginaryRadius * Math.cos(teta);
            matrix[(int)i][1] = centerPlateOfY + imaginaryRadius * Math.sin(teta);
            matrix[(int)i][2] = centerPlateOfZ;
            matrix[(int)i + 4][0] = centerPlateOfX + imaginaryRadius * Math.cos(teta);
            matrix[(int)i + 4][1] = centerPlateOfY + imaginaryRadius * Math.sin(teta);
            matrix[(int)i + 4][2] = centerPlateOfX + Math.sqrt(2) * imaginaryRadius;
        }
    }

}
