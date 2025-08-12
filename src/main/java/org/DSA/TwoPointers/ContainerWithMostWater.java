package org.DSA.TwoPointers;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int area=0;
        int i=0, j=height.length-1;

        while(i<j){
            area=Math.max(area,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j])i++;//If height[i] < height[i], move i++ (shorter wall)
            else j--;//else move j-- (shorter wall)
        }

        return area;
    }

    public static void main(String[] args) {
        int[] heights={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
}

/*
Intuition:
----------
=> You start with the widest container possible (left = 0, right = n-1).
=> The area depends on:
area = width × min(height[left], height[right])

=>If you want a bigger area, you either:
1) Reduce width
OR
2) Increase height

Moving the taller wall never helps, because the limiting height is the shorter one.
Only moving the shorter wall gives a chance to find a taller one that could increase the min-height.
 */
