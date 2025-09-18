package org.DSA.Arrays;

public class MaxProductOfTwoElements {
    public int maxProduct(int[] nums) {
        int largest=0,secondLargest=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                secondLargest=largest;
                largest=nums[i];
            }
            else if(nums[i]>secondLargest){
                secondLargest=nums[i];
            }
        }

        return (largest-1)*(secondLargest-1);
    }
}
