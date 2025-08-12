package org.DSA.TwoPointers;

import java.util.Arrays;

public class CountDistinctPairsGivenDiff {
    public static int TotalPairs(int[] nums, int k) {
        // Code here
        Arrays.sort(nums);//Sort so differences are monotonic.

        int i=0,j=1, count=0;//i is left pointer, j is right pointer (start at 1)

        while(i<nums.length && j<nums.length){//loop until either pointer runs out
            if(i==j){//we must compare different indices
                j++;
                continue;
            }

            int diff=nums[j]-nums[i];

            if(diff>k)i++;//difference too large → make it smaller by moving left pointer right
            else if(diff<k)j++;//difference too small → make it larger by moving right pointer right
            else{//diff == k: found a distinct pair (nums[i], nums[j])
                count++;//count this pair once

                int el1=nums[i];
                //Skip all duplicates of the left value so we don't count (el1, el2) again
                while(i<nums.length && nums[i]==el1)i++;

                int el2=nums[j];
                //Skip all duplicates of the right value as well
                while(j<nums.length && nums[j]==el2)j++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums={1, 1, 1, 2, 2, 3};
        int k=0;
        System.out.println(TotalPairs(nums,k));
    }
}

/*
Intuition:
----------
Same logic as "count pairs with given sum in sorted array".

1️⃣ Core Idea
We want to find distinct unordered pairs (a, b) where:
∣a−b∣=k
This means either a−b=k or b-a=k

If we sort the array, the difference nums[j] - nums[i] will:
Increase when we move j forward.
Decrease when we move i forward.

This monotonic property lets us use two pointers to “tune” the difference toward k without checking all possible pairs.

2️⃣ Why two pointers work:
--------------------------
Start with i and j in the first two positions (i = 0, j = 1).
If difference is too small (diff < k), move j forward to increase it.
If difference is too large (diff > k), move i forward to decrease it.
If difference equals k, we found a pair:
Count it once.
Skip all duplicates of both numbers to avoid counting the same pair again.
This ensures:
Each distinct value pair is found once.

Time complexity is = O(nlogn)

3️⃣ Why it handles k == 0 naturally
When k=0
k=0, a valid pair means both numbers are equal.

In sorted order:
Equal numbers are next to each other.
The first time diff == 0 happens for a number, your logic counts it once and skips all duplicates of that number on both sides.
This means any number that appears at least twice is counted exactly once.

So without special cases in the code, the same skipping-duplicates logic covers the k = 0 scenario.
 */



/*
Example Walkthrough:
--------------------
Step 1:
i = 0 (nums[i] = 1), j = 1 (nums[j] = 1)

diff = 1 - 1 = 0 → match found → count++

Skip all duplicates of nums[i] (value = 1) → i moves to first 2

Skip all duplicates of nums[j] (value = 1) → j also moves to first 2

Result so far: count = 1

Step 2:
i = 3 (nums[i] = 2), j = 4 (nums[j] = 2)

diff = 0 → match found → count++

Skip all 2’s on both i and j → move past 2’s

Result so far: count = 2

Step 3:
i and j now point to 3’s, but only one 3 exists → no match

Final: count = 2

 */