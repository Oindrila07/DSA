package org.DSA.BitManipulation;

public class CheckIfOddOrEven {
    public static void main(String[] args) {
        int num=-10;
        System.out.println((num & 1) == 0);//even
        System.out.println((num & 1)!=0);//odd
    }
}
