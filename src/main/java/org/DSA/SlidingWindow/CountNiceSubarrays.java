package org.DSA.SlidingWindow;

public class CountNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        return countSubArraysOdd(nums,k)-countSubArraysOdd(nums,k-1);
    }

    private static int countSubArraysOdd(int[] nums, int goal){
        int i=0, j=0, count=0, countOdd=0;

        while(j<nums.length){
            if(nums[j]%2!=0)countOdd++;
            while(i<=j && countOdd>goal){
                if(nums[i]%2!=0)countOdd--;
                i++;
            }
            count+=(j-i+1);
            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums={2,2,2,1,2,2,1,2,2,2};
        int k=2;

        System.out.println(numberOfSubarrays(nums,k));
    }
}

/*
Intuition:
----------
We must count all contiguous segments that have exactly 2 odds.
Brute force would mean checking every subarray, counting odds, and checking if it's equal to k. That’s O(n²), which is too slow for big arrays.


The key idea is to use:
#exactlykodds=#atmostkodds−#atmost(k-1)odds

Why does this work?
If I have the set of subarrays with ≤ k odds, that set contains:
Subarrays with 0 odds
Subarrays with 1 odd
Subarrays with 2 odds
...
Subarrays with exactly k odds

If I have the set of subarrays with ≤ (k-1) odds, that set contains:
Subarrays with 0 odds
Subarrays with 1 odd
...
Subarrays with (k-1) odds
(but none with k odds)

Subtracting them removes everything except the exactly k odds subarrays.

This turns an "exactly k" problem into two easier "at most k" problems.
 */
