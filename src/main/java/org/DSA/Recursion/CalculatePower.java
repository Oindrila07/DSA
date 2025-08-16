package org.DSA.Recursion;

public class CalculatePower {
    public static double myPow(double x, int n) {
        if(n==0)return 1;

        if(n<0){
            if(n==Integer.MIN_VALUE)return (1/myPow(x,Integer.MAX_VALUE))*(1/myPow(x,1));
            return 1/myPow(x,-n);
        }

        if(n%2==0)return myPow(x*x,n/2);
        return x*myPow(x*x,(n-1)/2);
    }

    public static void main(String[] args) {
        double x=0.00001;
        int n=Integer.MAX_VALUE;
        System.out.println(myPow(2.10000
                ,-3));
    }
}

/*
The naive way to compute is multiplying x by itself n times
n times → O(n) operations.

But notice:
If n is even: x^n = (x^2)^(n/2)
If n is odd: x^n = (x^2)^((n-1)/2)
 */
