package org.DSA.Math;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new Solution2().isHappy(16));
    }
}
class Solution2 {
    public boolean isHappy(int n) {
        if(n==1) return true;

        int temp=n;

        while(temp!=1){
            temp=findSum(temp);
            if(temp==n || temp==4)return false;//4 appears in case the numbers are not going to result as 1.
        }

        return true;
    }

    private int findSum(int n){
        int sum=0;

        while(n>0){
            int digit=n%10;
            sum+=(digit*digit);
            n/=10;
        }

        return sum;
    }
}
/*
Intuition:
----------
Intuition is, if the number is not happy, then after all the processing, it will result upto itself or 4.
For example,
1) If n=5, then
25
29
85
89
145
42
20
4 -- this is where we break off
 */
