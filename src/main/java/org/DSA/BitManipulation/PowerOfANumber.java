package org.DSA.BitManipulation;

public class PowerOfANumber {
    public double myPow(double x, int n) {
        if(n==Integer.MIN_VALUE){
            return ((int)x==1 || (int)x==-1)?1:0;
        }
        if(n<0){
            return 1/myPow(x,-n);
        }
        return calculatePow(x,n);
    }

    private double calculatePow(double x, int n){
        if(n==0)return 1;
        if((n & 1)==0)return calculatePow(x*x, n>>1);
        return x*calculatePow(x*x, n>>1);
    }
}
