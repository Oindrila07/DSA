package org.DSA.Arrays;

public class FindDuplicatesInArray {
    //One way to solve this problem is: Using Cycle Sort algorithm when modifying the array is allowed
    public int findDuplicate1(int[] nums) {
        int i=0;

        while(i<nums.length){
            while(i<nums.length && nums[i]!=nums[nums[i]-1]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
            i++;
        }

        return nums[nums.length-1];
    }

    //Efficient method is to use: Floyd's Cycle Detection Algorithm:
    public int findDuplicate(int[] nums) {
        int slow=nums[0], fast=nums[0];

        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast)break;
        }

        fast=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;
    }
}

/*
Approach for Floyd's:
---------------------
=> Visualize array as a linked list
=> Start from index 0.
=> Next index = nums[current].
=> This builds a “linked list with a cycle.”

Phase 1 (finding intersection):
-------------------------------
=> Use two pointers:
=> slow moves one step: slow = nums[slow].
=> fast moves two steps: fast = nums[nums[fast]].
Eventually they meet inside the cycle.

Phase 2 (finding cycle entrance):
---------------------------------
=> Reset one pointer to the start (index 0).
=> Move both pointers one step at a time (= nums[pointer]).
=> The point where they meet is the duplicate number.
 */
