package com.myproject.code.arrayConcept;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertArrayEquals(ExMatrix,matrix);

    }



}
