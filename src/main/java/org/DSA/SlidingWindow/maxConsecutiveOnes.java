package org.DSA.SlidingWindow;

public class maxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int i=0, j=0, len=0, count=0, countZeroes=0, n=nums.length;

        while(j<nums.length){
            if(nums[j]==0)countZeroes++;

            if(countZeroes>k){
                while(i<=j && countZeroes>k){
                    if(nums[i]==0)countZeroes--;
                    i++;
                }
            }

            count=j-i+1;
            len=Math.max(len,count);
            j++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums,3));
    }
}

/*
Intuition:
----------
This is a sliding window problem:
We want the longest contiguous sequence where we can flip at most k zeros to ones.
Instead of literally flipping values, we count how many zeros are inside our current window.
If the count of zeros exceeds k, the window becomes invalid, so we shrink from the left until it becomes valid again.
While moving the window, we keep track of the maximum valid length.
 */
