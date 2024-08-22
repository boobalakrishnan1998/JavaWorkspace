package com.myproject.code.Matrix;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        //rotateMatrix(matrix);
        rotateMatrixBySpaceComplexity(matrix);
        reverseTheMatrix(matrix);
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix.length;j++){
                matrix[j][matrix.length-1-i]=matrix[i][j];
            }
        }
    }

     public static int[][] rotateMatrix(int[][] matrix) {
        int[][] newMatrix=new int[matrix.length][matrix.length];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix.length;j++){
                newMatrix[j][matrix.length-1-i]=matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int[][] rotateMatrixBySpaceComplexity(int[][] matrix) {
        for(int i=0;i< matrix.length;i++){
            for(int j=i+1;j< matrix.length;j++){
             int temp=matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        return matrix;
    }
   public static int[][] reverseTheMatrix(int[][] matrix){
       for(int i=0;i< matrix.length;i++){
          int a=0;
          int b= matrix.length-1;
          while(a<b){
              int tem=matrix[i][a];
              matrix[i][a]=matrix[i][b];
              matrix[i][b]=tem;
              a++;
              b--;
          }
       }
        return matrix;
   }




}
