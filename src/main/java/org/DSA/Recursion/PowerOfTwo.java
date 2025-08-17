package org.DSA.Recursion;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==1)return true;
        if(n%2!=0 || n<0)return false;

        return checkIfPowerOfTwo(n,2,0);
    }

    private boolean checkIfPowerOfTwo(int num, int x, int index){
        if(x==num)return true;
        if(x>num || index>31)return false;

        return checkIfPowerOfTwo(num, x*2, index+1);
    }
}


class PowerOfTwoMain{
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(2147483646));
    }
}

/*
Intuition:
----------
=> we keep on increasing x, until it reaches/crosses n.
=> if number is too large for ex: 2147483646, it will only consider 31 iterations, cz by default, the integers can't exceed 2^31
 */