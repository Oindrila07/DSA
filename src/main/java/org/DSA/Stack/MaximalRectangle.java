package org.DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] preSum=new int[n][m];
        int maxArea=0;

        for(int col=0;col<m;col++){
            int sum=0;
            for(int row=0;row<n;row++){
                if(matrix[row][col]=='0')sum=0;
                else sum++;
                preSum[row][col]=sum;
            }
        }

        for(int row=0;row<n;row++){
            maxArea=Math.max(maxArea,histogram(preSum[row],m));
        }

        return maxArea;
    }

    private int histogram(int[] nums, int n){
        int[] left=new int[n];
        int[] right=new int[n];
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();

        Arrays.fill(left,-1);
        Arrays.fill(right,n);

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty())left[i]=stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty())right[i]=stack.peek();
            stack.push(i);
        }

        for(int i=0;i<nums.length;i++){
            int width=right[i]-left[i]-1;
            int height=nums[i];

            int area=height*width;
            maxArea=Math.max(maxArea,area);
        }

        return maxArea;
    }
}

class MaximalRectangleMain {
    public static void main(String[] args) {
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }
}