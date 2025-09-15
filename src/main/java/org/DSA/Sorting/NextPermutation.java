package org.DSA.Sorting;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int breakPoint=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                breakPoint=i-1;
                break;
            }
        }

        if(breakPoint==-1){
            reverse(nums,0,nums.length-1);
            return;
        }

        for(int i=nums.length-1;i>breakPoint;i--){
            if(nums[i]>nums[breakPoint]){
                int temp=nums[i];
                nums[i]=nums[breakPoint];
                nums[breakPoint]=temp;
                break;
            }
        }

        reverse(nums,breakPoint+1,nums.length-1);
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
