package org.DSA.BitManipulation;

public class MinBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        int xor=start^goal;
        return countBits(xor);
    }

    private int countBits(int num){
        int count=0;
        while(num>0){
            num=num & (num-1);
            count++;
        }
        return count;
    }
}


/*
Intuition:
----------
The question asks how few bit flips are necessary to change one integer into another.
It follows easily that the bits of the two numbers can be compared.
The amount of flips required will depend on how the bits in the binary representation of start and aim differ from one another.
The result of a bitwise XOR operation between start and goal is a number where each 1 denotes a location where the bits of the two numbers differ.
The necessary number of bit flips can be found by counting the 1s in this XOR result.
 */