package org.DSA.TwoPointers;

public class FindDuplicateNumber1ToN {
    public static int findDuplicate(int[] nums) {
        int slow=nums[0], fast=nums[0];

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);

        fast=nums[0];

        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums={2,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
}

/*
Intuition:
----------
We have an array nums of size n+1 where each number is between 1 and n inclusive.
Since there are n+1 numbers but only n possible values, pigeonhole principle guarantees that at least one number is repeated.

We are told:
Do not modify the input array
Use only O(1) extra space
Time complexity must be < O(n²)
This rules out sorting, hash sets, and other extra-space methods.

The key observation:

The array can be seen as a linked list:
Each index is a "node"
nums[i] is the "next pointer"
A duplicate value means two indices point to the same next index, causing a cycle in this linked list.
We can find the start of this cycle using Floyd's Tortoise and Hare algorithm.



Approach:
---------
Phase 1 — Detect intersection inside the cycle

Use two pointers:
slow moves 1 step at a time: slow = nums[slow]
fast moves 2 steps at a time: fast = nums[nums[fast]]
Keep moving until they meet — this confirms a cycle exists.
Phase 2 — Find the entry point of the cycle

Reset fast to the beginning (nums[0]).
Move both slow and fast 1 step at a time.
The point where they meet again is the duplicate number (start of cycle).
 */
