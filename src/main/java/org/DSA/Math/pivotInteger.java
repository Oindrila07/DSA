package org.DSA.Math;

public class pivotInteger {
    public static void main(String[] args) {
        System.out.println(new Solution().pivotInteger(19));
    }
}
class Solution {
    public int pivotInteger(int n) {
        int sum=(n*(n+1))/2;

        double possiblePivot=Math.sqrt(sum);

        if(possiblePivot==(int)possiblePivot)return (int)possiblePivot;
        return -1;
    }
}