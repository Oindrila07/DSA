package org.DSA.Arrays;

import java.util.HashSet;

public class swapElementsPair {
    boolean findSwapValues(int[] a, int[] b) {
        // Your code goes here
        HashSet<Integer> hash=new HashSet<>();
        int sum1=0, sum2=0;

        for(int i:a){
            sum1+=i;
        }

        for(int i:b){
            sum2+=i;
        }

        int diff=sum1-sum2;
        if(diff%2!=0)return false;
        int target=diff/2;

        for(int i:a){
            hash.add(i);
        }

        for(int y:b){
            int x=target+y;
            if(hash.contains(x))return true;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}

/*Intuition:
------------
Understand the Goal:
   - We want the sums of the two arrays to become equal after swapping one element from each array.
   - Let’s call the sums of the arrays `sum_a` and `sum_b`.


Determine the Difference:
   - Calculate the difference between the sums of the two arrays: `diff = sum_a - sum_b`.
   - For the sums to become equal after swapping, this difference (`diff`) must be adjusted by the swap.


Why Even Difference?:
   - To make the sums equal by swapping, the difference must be evenly split. This is because the swap should equally adjust both sums.
   - Therefore, if `diff` is not even, it’s impossible to split it into two equal parts, and we return `-1`.


Adjusting by Swap:
   - If `diff` is even, we can proceed. Let’s call the value we need to adjust by swapping `target = diff / 2`.
   - This means we need to find two values, `x` from array `a` and `y` from array `b`, such that the difference between them is `target`.


Finding the Pair:
   - Specifically, we need to find `x` in `a` and `y` in `b` such that `x - y = target`.
   - Rearranging this, we get `x = y + target`.
   - This means for each element `y` in array `b`, we need to check if `y + target` exists in array `a`.
 */
