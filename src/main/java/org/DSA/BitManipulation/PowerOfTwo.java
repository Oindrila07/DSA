package org.DSA.BitManipulation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        return (n & (n-1))==0;
    }

    public static void main(String[] args) {
        System.out.println(12&11);
    }
}
