package org.DSA.Math;

public class CountOddsInRange {
    public int countOdds(int low, int high) {
        int count1=low/2;//count from 1 to low-1 (low-1 because exclude low in the count)
        int count2=(high+1)/2;//count from 1 to high
        return count2-count1;
    }
}


/*
Intuition:
----------
we will calculate all odd number from 1 to low-1 and 1 to high;
why low-1??
because we want include our low value in the final answer.

Approach:
---------
=> Total odd number between 1 and low - 1 is low/2.
=> Total odd number between 1 and high is (high + 1 ) / 2.
=> For getting answer we will do
    (Total odd number between 1 and high) - (Total odd number between 1 and low - 1)


Complexities:
-------------
TC: O(1)
SC: O(1)
 */