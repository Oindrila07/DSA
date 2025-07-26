package org.DSA.Sorting;

public class sortedSquares {
    public int[] sortedSquares(int[] nums) {
        // write your code here
        int[] squares=new int[nums.length];

        int left=0, right=nums.length-1, i=nums.length-1;

        while(left<=right){
            int num1=nums[left]*nums[left];
            int num2=nums[right]*nums[right];

            if(num1<num2){
                squares[i--]=num2;
                right--;
            }
            else{
                squares[i--]=num1;
                left++;
            }
        }

        return squares;
    }

    public static void main(String[] args) {

    }
}

/*Intuition:
-----------
The two-pointer approach here is very similar to the merge step in merge sort, in that:

You're comparing elements from both ends (or two sorted subarrays in merge).

You're building a new array based on the comparison.

The difference is:

In merge sort, you merge two sorted arrays in increasing order.

In this problem, you're merging from both ends of a single sorted array — and placing the larger squares at the end, because squaring can mess with the original order.

If you square both ends of the array:

The largest square will always be at either the leftmost or rightmost side.

The largest square should be placed at the end of the result array.

So, we can:

Use two pointers (left and right).

Move inward, comparing the absolute values:

Put the larger square at the end of a result array (filling it backward).

This gives a linear-time solution: O(n).
 */

