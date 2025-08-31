package org.DSA.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumK {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> deque=new ArrayDeque<>();
        long[] prefix=new long[nums.length+1];
        int len=Integer.MAX_VALUE;

        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }

        for(int i=0;i<prefix.length;i++){
            while(!deque.isEmpty() && prefix[deque.peekLast()]>=prefix[i]){
                deque.pollLast();
            }
            while(!deque.isEmpty() && prefix[i]-prefix[deque.peek()]>=k){
                len=Math.min(len, i-deque.pollFirst());
            }
            deque.offerLast(i);
        }

        return len==Integer.MAX_VALUE?-1:len;
    }
}

class ShortestSubarraySumKMain {
    public static void main(String[] args) {
        int[] nums={2,-1,2};
        System.out.println(new ShortestSubarrayWithSumK().shortestSubarray(nums,3));
    }
}

/*
Intuition:
----------
We want the shortest subarray with sum ≥ K.
Brute force = check all subarrays → O(n²). Too slow.

So first thought:
“How can I compute subarray sums fast?” → Prefix sums is the natural first tool.
prefix[j] - prefix[i] >= K

Deque Structure:
----------------
We’re looking for two indices (i, j) with:
i < j

prefix[j] - prefix[i] >= K

If I’m at j, I need the best i.
Best i means:
=> prefix[i] should be as small as possible (so difference is bigger),
=> and i should be as close as possible to j (to minimize length).

This is the key realization:
We don’t need all i’s, just the "useful" ones.

1. Why are the “greater prefix values” worse?
---------------------------------------------
We care about prefix[j] - prefix[i].

For a given j, the smaller prefix[i] is, the bigger the difference becomes.

So, if we have two candidates i1 and i2 such that:

i1 < i2 (so i1 is earlier than i2)

and prefix[i1] >= prefix[i2]

Then, for any future j > i2: prefix[j] - prefix[i2] >= prefix[j] - prefix[i1]
and also, (j - i2) < (j - i1)   (because i2 is later)
So i2 is better in both ways:

It gives a larger or equal sum.
It gives a shorter subarray length.
Therefore, i1 is dominated → useless forever → throw it out.
That’s why “greater prefix values” (with earlier indices) are worse candidates.

2. Why do we need to maintain increasing order in prefix values?
----------------------------------------------------------------
Because when we’re searching for the best i for a given j, we want to be able to find the smallest prefix[i] among earlier indices quickly.

👉 If we maintain the deque so that prefix[indices] is strictly increasing from front to back:
The front of the deque always has the best possible candidate (i with the smallest prefix so far).
The rest are ordered, so when we add a new one, we can efficiently “kick out” the dominated ones at the back.

If we didn’t maintain order, we’d have to scan all candidates to figure out which one has the smallest prefix. That would destroy the O(n) efficiency.

3. Why increasing order (not decreasing)?
-----------------------------------------
Because:
We check subarray sums with prefix[j] - prefix[i] >= K starting from the front.
Since the deque is in increasing order:
The front has the smallest prefix (most likely to satisfy the condition).
Once it works, we pop it (since it won’t be useful for any later j).
We move forward.

So, increasing order ensures:
Front = best candidate (smallest prefix).
Back = newest candidates, after cleaning.
 */