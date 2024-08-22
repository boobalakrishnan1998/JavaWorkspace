package com.myproject.code.Matrix;

public class RotateMatrixbyK {
        int[][] rotateMatrix(int N, int M, int K, int Mat[][]) {
            // code here
            K = K%M;
            for(int i=0;i<N;i++) {
                reverse(Mat,0,K-1,i);
                reverse(Mat,K,M-1,i);
                reverse(Mat,0,M-1,i);
            }
            return Mat;
        }

        public static void reverse(int[][]  Mat, int left, int right, int i) {
            while(left<=right) {
                int temp= Mat[i][left];
                Mat[i][left] = Mat[i][right];
                Mat[i][right] = temp;
                left++;
                right--;
            }
        }
}
