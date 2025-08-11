package org.DSA.SlidingWindow;

public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarrays(nums,goal)-countSubarrays(nums,goal-1);
    }

    private static int countSubarrays(int[] nums, int goal){
        int i=0, j=0, sum=0, count=0;

        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>goal){
                sum-=nums[i];
                i++;
            }
            count+=(j-i+1); // all subarrays ending at j with sum ≤ goal
            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums={1,0,1,0,1};
        int goal=2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
}

/*
Intuition:
----------
Counting ≤ goal includes everything that sums to exactly goal and everything smaller.
Counting ≤ goal - 1 includes everything smaller but not exactly goal.
Subtracting removes the smaller sums, leaving only exactly goal.
 */
