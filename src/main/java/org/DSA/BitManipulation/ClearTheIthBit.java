package org.DSA.BitManipulation;

public class ClearTheIthBit {
    static int clearBit(int num, int i) {
        int x=(1<<i);
        x=~x;
        return (num & x);
    }

    public static void main(String[] args) {
        System.out.println(clearBit(15, 0));
    }
}
