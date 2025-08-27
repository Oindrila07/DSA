package org.DSA.Stack;

import java.util.Stack;

public class LargestHistogramArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[heights.length];
        int[] right=new int[heights.length];
        int maxArea=0;

        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                right[i]=heights.length;
            }
            else right[i]=stack.peek();

            stack.push(i);
        }

        stack.clear();

        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                left[i]=-1;
            }
            else left[i]=stack.peek();

            stack.push(i);
        }

        for(int i=0;i<heights.length;i++){
            int width=right[i]-left[i]-1;
            int area=width*heights[i];
            maxArea=Math.max(maxArea,area);
        }

        return maxArea;
    }
}

class LargestHistogramAreaMain {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new LargestHistogramArea().largestRectangleArea(heights));
    }
}
