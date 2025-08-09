package org.DSA.Math;

public class TrailingZeroesInFact {
    public static int trailingZeroes(int n) {
        int count=0;

        for(int i=5;i<=n;i*=5){
            count+=(n/i);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(26));
    }
}

/*
Intuition:
----------
Counting trailing zeroes in the factorial of a number n! does not require directly computing the factorial
(which is huge even for moderate n). The key insight is that a trailing zero is produced by multiplying 2
and 5 (2 × 5 = 10) and every pair of these factors contributes a zero at the end. However, there are always
more 2s than 5s in factorials, so the number of times 5 appears as a factor in all numbers from 1 to n
determines the number of trailing zeroes.

Complexity
Time complexity:
O(log5n)

Space complexity:
O(1)
 */
