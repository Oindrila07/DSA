package org.DSA.BitManipulation;

public class CountNumberOfSetBits {
    public static int countSetBits(int num){
        int count=0;
        while(num!=0){
            count++;
            num=num & (num-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(Integer.MIN_VALUE));
    }
}
