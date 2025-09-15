package org.DSA.Sorting;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        for(int i=1;i<nums.length;i++){
            int el=nums[i], j=i-1;
            while(j>=0 && nums[j]>el){
                swap(nums,j,j+1);
                j--;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j){
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }
}

/*
Approach:
---------
=> In each iteration, select an element from the unsorted part of the array using an outer loop.
=> Place this element in its correct position within the sorted part of the array.
=> Use an inner loop to shift the remaining elements as necessary to accommodate the selected element. This involves shifting the elements by one place until the selected element can be placed at its correct position.
=> Continue this process until the entire array is sorted.
 */
