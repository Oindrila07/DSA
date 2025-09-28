package org.DSA.Arrays;

public class SplitArrayWithMinimumDiff {
    public long splitArray(int[] nums) {
        if(nums.length==2)return Math.abs(nums[0]-nums[1]);
        int count=0, i;
        long sum1=nums[0], sum2;
        for(i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1])break;
            sum1+=nums[i];
            count++;
        }
        if(i==nums.length)sum2=0;
        else {
            sum2=nums[i];
            i++;
        }
        while(i<nums.length){
            if(nums[i]>=nums[i-1])break;
            sum2+=nums[i];
            i++;
        }
        if(i!=nums.length)return -1;
        long diff=Math.abs(sum1-sum2);
        sum1=nums[nums.length-1];
        for(i=nums.length-2;i>=0;i--){
            if(nums[i]<=nums[i+1])break;
            sum1+=nums[i];
        }
        sum2=i==-1?0:nums[i];
        i--;
        while(i>=0){
            if(nums[i]>=nums[i+1])break;
            sum2+=nums[i];
            i--;
        }
        diff=Math.min(diff,Math.abs(sum1-sum2));
        return diff;
    }
}
