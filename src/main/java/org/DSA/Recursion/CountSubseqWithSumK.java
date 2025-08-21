package org.DSA.Recursion;

public class CountSubseqWithSumK {
    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        //your code goes here
        return countSub(nums,k,0,0);
    }

    private int countSub(int[] nums, int k, int sum, int index){
        if(sum>k)return 0;
        if(sum==k)return 1;

        int count=0;

        for(int i=index;i<nums.length;i++){
            count+=countSub(nums,k,sum+nums[i],i+1);
        }

        return count;
    }
}

class CountSubseqWithSumKMain{
    public static void main(String[] args) {
        System.out.println(new CountSubseqWithSumK().countSubsequenceWithTargetSum(new int[]{4,9,2,5,1},10));
    }
}
