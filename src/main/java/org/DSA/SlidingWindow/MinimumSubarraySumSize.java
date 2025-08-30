package org.DSA.SlidingWindow;

public class MinimumSubarraySumSize {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,sum=0,len=Integer.MAX_VALUE;

        while(j<nums.length){
            sum+=nums[j];

            while(i<nums.length && sum>=target){
                len=Math.min(len,j-i+1);
                sum-=nums[i];
                i++;
            }

            j++;
        }

        return len==Integer.MAX_VALUE?0:len;
    }
}

class MinSubarraySumSize {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(new MinimumSubarraySumSize().minSubArrayLen(target, nums));
    }
}
