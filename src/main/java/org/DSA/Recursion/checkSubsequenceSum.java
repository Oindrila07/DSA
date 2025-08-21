package org.DSA.Recursion;

public class checkSubsequenceSum {
    public boolean checkSubsequenceSum(int[] nums, int k) {
        //your code goes here
        if(check(nums,k,0,0)==-1)return false;
        return true;
    }

    private int check(int[] nums, int k, int sum, int index){
        if(sum==k)return 1;
        if(sum>k)return -1;

        for(int i=index;i<nums.length;i++){
            int val=check(nums,k,sum+nums[i],i+1);
            if(val==-1)continue;
            else return val;
        }

        return -1;
    }
}

class checkSubsequenceSumMain{
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int target=92;
        System.out.println(new checkSubsequenceSum().checkSubsequenceSum(nums,target));
    }
}
