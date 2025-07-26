package org.DSA.Math;

public class arraySignProblem {
    public int arraySign(int[] nums) {
        // write your code here
        long count=0;

        for(int num: nums){
            if(num<0)count++;
            if(num==0)return 0;
        }

        if(count==0 || count%2==1)return -1;
        return 1;
    }

    public static void main(String[] args) {

    }
}
