package org.DSA.BitManipulation;

public class ToggleIthBit {
    public static int toggleBit(int num, int i){
        int x=(1 << i);
        return num ^ x;
    }

    public static void main(String[] args) {
        System.out.println(toggleBit(9,2));
        System.out.println(toggleBit(13,2));
        System.out.println(toggleBit(13,1));
    }
}
