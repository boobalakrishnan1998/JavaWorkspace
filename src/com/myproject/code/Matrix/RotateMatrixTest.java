package com.myproject.code.Matrix;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateMatrixTest {

    @Test
    public void testRotateMatrix(){
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] ExMatrix = {{7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};
        matrix= RotateMatrix.rotateMatrix(matrix);
        Assertions.assertArrayEquals(ExMatrix,matrix);
    }



}
