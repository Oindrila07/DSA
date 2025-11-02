package org.DSA.BinaryTrees;

public class MinimumNumberOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1, high=0, res=1;
        for(int num:nums){
            high=Math.max(high,num);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(mid,nums,maxOperations)){
                res=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return res;
    }

    private boolean isValid(int threshold, int[] nums, int maxOperations){
        int totalOperations=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=threshold){
                totalOperations+=(int)(Math.ceil((double)nums[i]/threshold))-1;
            }
            if(totalOperations>maxOperations)return false;
        }
        return true;
    }
}

/*
Intuition:
----------
🎯 What are we really deciding?
We are trying to find the minimum possible maximum bag size (threshold) we can achieve using at most maxOperations splits.
“If I fix a target threshold, can I make all bags ≤ threshold using ≤ maxOperations splits?”

💡 Core Intuition:
-------------------
Let’s pick a number and test feasibility.
Example: nums = [9, 7, 5]
maxOperations = 3

Say we want to make sure that no bag has more than threshold = 3 balls.

Now, how many operations (splits) do we need?

Bag with 9 → needs to be split into 3-sized groups:

ceil(9 / 3) = 3 bags → needs 2 operations

Bag with 7 → ceil(7 / 3) = 3 bags → needs 2 operations

Bag with 5 → ceil(5 / 3) = 2 bags → needs 1 operation

Total = 2 + 2 + 1 = 5 operations.
But we only have maxOperations = 3. ❌ Not possible.

If we relax the constraint and allow threshold = 5:

9 → ceil(9 / 5) = 2 bags → 1 operation

7 → ceil(7 / 5) = 2 bags → 1 operation

5 → ceil(5 / 5) = 1 bag → 0 operations
Total = 2 operations ✅ Possible.

As the threshold increases, the number of required operations monotonically decreases.
This monotonic property (non-increasing function) allows us to use binary search.

🧠 Why Binary Search Works Here:
--------------------------------
We are searching for the smallest threshold such that
required_operations(threshold) <= maxOperations.

So we binary search over threshold in the range [1, max(nums)]:

If we can make all bags ≤ mid, then maybe we can do better → search left (smaller values).

Otherwise, it’s too small → search right (larger values).

⚙️ The Helper Function (isValid):
---------------------------------
For a given threshold, we check: totalOperations = Σ (ceil(nums[i] / threshold) - 1)
Each term means:
=> To split a bag of size nums[i] into groups ≤ threshold,
=> you need (number of resulting bags - 1) operations.
=> The ceil() gives the number of resulting bags.
=> The -1 converts that into the number of splits needed.
If the total is ≤ maxOperations, it’s feasible.


⏱️ Time Complexity:
-------------------
isValid() runs in O(n)
Binary search runs in O(log(max(nums)))
Total: O(n log(max(nums))), which is very efficient even for large inputs.
 */