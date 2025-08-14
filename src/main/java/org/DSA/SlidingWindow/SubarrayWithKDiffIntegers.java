package org.DSA.SlidingWindow;

public class SubarrayWithKDiffIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return countSubArrays(nums,k)-countSubArrays(nums,k-1);
    }

    private static int countSubArrays(int[] nums, int goal){
        if(goal==0) return 0;

        int[] freq=new int[nums.length+1];
        int i=0, j=0, count=0, countDist=0;

        while(j<nums.length){
            if(freq[nums[j]]==0)countDist++;

            while(i<=j && countDist>goal){
                if(freq[nums[i]]>0){
                    freq[nums[i]]--;
                }

                if(freq[nums[i]]==0)countDist--;

                i++;
            }

            count+=(j-i+1);
            freq[nums[j]]++;
            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums={2,1,1,1,2};
        int k=1;
        System.out.println(subarraysWithKDistinct(nums,k));
    }
}
