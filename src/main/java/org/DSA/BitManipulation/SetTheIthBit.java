package org.DSA.BitManipulation;

public class SetTheIthBit {
    static int setKthBit(int n, int k) {
        // code here
        int x=(1<<k);
        return (x | n);
    }

    public static void main(String[] args) {
        int num=9;
        System.out.println(setKthBit(num, 2));
    }
}
