package org.DSA.Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NeedAllOnes {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=5;
        int m=5;
        int[][] matrix={{1,0,1,0,1},{0,1,0,1,0},{1,1,1,1,0},{1,1,1,1,1},{1,1,1,1,1}};

        System.out.println(findMaxArea(matrix,n,m));
    }

    public static int findMaxArea(int[][] matrix, int n, int m){
        int[] preSum=new int[m];
        int maxArea=0;

        for(int col=0;col<m;col++){
            for(int row=0;row<n;row++){
                if(matrix[row][col]==1){
                    preSum[col]++;
                }
                else preSum[col]=0;
            }
            maxArea = Math.max(maxArea, histogram(preSum));
        }

        return maxArea;
    }

    private static int histogram(int[] arr){
        int maxArea=0;
        int n=arr.length;

        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack=new Stack<>();

        Arrays.fill(left,-1);
        Arrays.fill(right,n);

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty())left[i]=stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty())right[i]=stack.peek();
            stack.push(i);
        }

        for(int i=0;i<n;i++){
            int width=right[i]-left[i]-1;
            int height=arr[i];
            int area=height*width;
            maxArea=Math.max(maxArea,area);
        }

        return maxArea;
    }
}
