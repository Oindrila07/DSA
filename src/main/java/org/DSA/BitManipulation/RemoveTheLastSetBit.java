package org.DSA.BitManipulation;

public class RemoveTheLastSetBit {
    public static int removeLastSetBit(int num){
        return num & (num-1);
    }

    public static void main(String[] args) {
        System.out.println(removeLastSetBit(32));
    }
}
