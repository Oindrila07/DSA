package org.DSA.BitManipulation;

public class SingleNumber2Optimal {
    public int singleNumber(int[] nums) {
        int ones=0, twos=0;
        for(int num:nums){
            ones=(ones^num) & (~twos);
            twos=(twos^num) & (~ones);
        }
        return ones;
    }
}


/*
Intuition:
----------
The optimal solution uses a bucket method combined with bitwise manipulation. Here's how:

Numbers appear three times except one. Track counts using two variables (ones and twos).
Use bitwise operations (&, ^, ~) to manage counts for every bit position.
After traversing, the unique number remains in ones.

nums[i] will appear in ones, if its not in twos
nums[i] will appear in twos if its already in ones

will appear = add (use xor)
its not in OR it already is = delete (& and ~) => how? because ~ flips all the set bits to 0

Example Input: [2,2,3,2]
Steps:

Initialize: ones = 0, twos = 0.
Traverse each number:
For num=2:
ones=(ones⊕num)&∼twos
twos=(twos⊕num)&∼ones
Result: ones = 2, twos = 0.
For num=2:
ones=(ones⊕num)&∼twos
twos=(twos⊕num)&∼ones
Result: ones = 0, twos = 2.
For num=3:
ones=(ones⊕num)&∼twos
twos=(twos⊕num)&∼ones
Result: ones=3, twos=2
For num=2:
ones=(ones⊕num)&∼twos
twos=(twos⊕num)&∼ones
Result: ones=3, twos=0
 */