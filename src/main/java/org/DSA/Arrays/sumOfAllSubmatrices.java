package org.DSA.Arrays;

public class sumOfAllSubmatrices {
    public static void main(String[] args) {
        int[][] matrix={{1,1},{1,1}};
        System.out.println(sumAllSubmatrices(matrix));
    }

    private static int sumAllSubmatrices(int[][] matrix){
        int n=matrix.length, m=matrix[0].length;
        int sum=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=(i+1)*(j+1)*(n-i)*(m-j)*matrix[i][j];
            }
        }

        return sum;
    }
}
