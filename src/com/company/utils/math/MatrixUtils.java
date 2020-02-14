package com.company.utils.math;

import java.awt.*;

public class MatrixUtils {
    private MatrixUtils(){
    }
    public static double[][] matrixMultiply(double[][] matrix1, double[][] matrix2){
        double[][] result = new double[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
    public static double[][] matrixShift(double[][] matrix1, double[] vector){
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + vector[j];
            }
        }
        return result;
    }
    public static double[][] matrixTranspose(double[][] matrix){
        return null;
    }

    public static String matrixToString(double[][] matrix){
        String result = "";
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                result += matrix[i][j] + "  ";
            }
            result += '\n';
        }
        return result;
    }

    public Polygon toPolygon(double[][] matrix, double coef) {
        var xArray = new int[matrix.length];
        var yArray = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            xArray[i] = (int)(matrix[i][0] * coef / matrix[i][2]);
            yArray[i] = (int)(matrix[i][1] * coef / matrix[i][2]);
        }
        return new Polygon(xArray, yArray, matrix.length);
    }



}
