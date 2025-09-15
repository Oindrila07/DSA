package org.DSA.Sorting;

public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[index]){
                    index=j;
                }
            }
            swap(nums,index,i);
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

/*
Approach:
---------
=> Select the starting index of the unsorted part using a loop with i from 0 to n-1.
=> Find the smallest element in the range from i to n-1 using an inner loop.
=> Swap this smallest element with the element at index i.
=> Repeat the process for the next starting index.
 */