package org.DSA.BitManipulation;

public class CheckSetBit {
    public static boolean checkIfSetBitBruteForce(int num, int pos){
        String s=new Convert().convertToBinary(num);
        if(pos>=s.length()){
            System.out.println("Not a valid pos");
            return false;
        }
        return s.charAt((s.length()-1)-pos)=='1';
    }

    public static boolean checkIfSetBitOptimizedLeftShift(int num, int pos) {
        int x=(1 << pos);
        return (num & x)!= 0;
    }

    public static boolean checkIfSetBitOptimizedRightShift(int num, int pos){
        int x=num>>pos;
        return (x & 1)!=0;
    }

    public static void main(String[] args) {
        int num=13;
        //TC: O(number of digits)
        System.out.println(checkIfSetBitBruteForce(num,2));

        //TC: For below operations is O(1)
        System.out.println(checkIfSetBitOptimizedLeftShift(num,2));
        System.out.println(checkIfSetBitOptimizedRightShift(num,2));
    }
}
