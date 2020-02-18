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

    @Override
    public void drawSolid(Graphics g, double coef, double alpha) {
        var polygon = this.toPolygon(coef, alpha);

        var xPoints = polygon.xpoints;
        var yPoints = polygon.ypoints;
        for(int i = 0; i < (int)(polygon.npoints/2 - 1); i++){
            g.drawLine(xPoints[i], yPoints[i],  xPoints[i+1], yPoints[i+1]);
        }
        for(int i = 0; i < (int)(polygon.npoints/2 - 1); i++){
            g.drawLine(xPoints[i], yPoints[i],  xPoints[i+4], yPoints[i+4]);
        }
        for(int i = 4; i < (int)(polygon.npoints/2) + 3; i++){
            g.drawLine(xPoints[i], yPoints[i],  xPoints[i+1], yPoints[i+1]);
        }
        g.drawLine(xPoints[0], yPoints[0],  xPoints[3], yPoints[3]);
        g.drawLine(xPoints[3], yPoints[3],  xPoints[7], yPoints[7]);
        g.drawLine(xPoints[4], yPoints[4],  xPoints[7], yPoints[7]);
    }

    @Override
    public void scew(double scale) {

    }

    @Override
    public void scale(double scaleX, double scaleY, double scaleZ) {

    }
}
