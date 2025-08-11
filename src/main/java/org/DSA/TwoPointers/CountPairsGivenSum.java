package org.DSA.TwoPointers;

public class CountPairsGivenSum {
    public static void main(String[] args) {
        int[] arr={-1, 1, 5, 5, 7};
        System.out.println(countPairs(arr,6));
    }
    static int countPairs(int arr[], int target) {
        // Complete the function
        int count=0;

        int left=0, right=arr.length-1;

        while(left<right){
            int sum=arr[left] + arr[right];
            if(sum==target){
                if(arr[left]==arr[right]){
                    int n=right-left+1;
                    count+=(n*(n-1))/2;
                    break;
                }

                int count1=1, count2=1;
                while(left<right-1 && arr[left]==arr[left+1]){
                    count1++;
                    left++;
                }

                while(right>left+1 && arr[right]==arr[right-1]){
                    count2++;
                    right--;
                }

                count+=(count1*count2);

                left++;
                right--;
            }
            else if(sum>target)right--;
            else left++;
        }

        return count;
    }
}

/*
Intuition:
----------
The idea
---------
Start with two pointers:
left at the smallest number (start of array)
right at the largest number (end of array)
Check the sum of the elements at these pointers.
If the sum is exactly target → we found a valid pair.
If the sum is less than target → increase the sum by moving left pointer forward.
If the sum is greater than target → decrease the sum by moving right pointer backward.

Handling duplicates
--------------------
If duplicates are possible, and we want all pairs with distinct indices, then:
When you find a match, you might need to count how many duplicates of arr[left] and arr[right] exist
to count all unique index combinations.

This still stays O(n) because each duplicate group is processed in one go.

Why duplicates matter:
----------------------
When the array is sorted, duplicates can cause multiple valid pairs with the same numbers but different indices.
For example:

arr = [1, 1, 1, 2, 2, 3], target = 3
If you just check one pair and move pointers, you might miss counting all index combinations.

Two duplicate cases
Case 1: Left and Right point to different values
Example:

arr[left] = 1, arr[right] = 2, target = 3
If you find arr[left] + arr[right] == target:

Count how many times arr[left] repeats (countLeft)

Count how many times arr[right] repeats (countRight)

The total number of pairs for this combination is:

countLeft × countRight
Then move left forward by countLeft and right backward by countRight.

Example run:
[1, 1, 1, 2, 2, 3], target = 3
left=0 → 3 ones
right=3 → 2 twos
pairs = 3 × 2 = 6


Case 2: Left and Right point to the same value
Example:

arr[left] = arr[right] = 1, target = 2
This means all elements between left and right are the same.

Number of ways to pick 2 distinct indices from these duplicates is:

C(n, 2) = n × (n - 1) / 2
where n = right - left + 1 (count of identical elements).

Then break, because all possible pairs are counted.

Example run:

[1, 1, 1, 1], target = 2
n = 4 → pairs = 4 × 3 / 2 = 6
Why this works
Instead of counting one pair at a time, we’re batch-counting all possible index combinations for duplicates.

Still O(n) time, because each element is processed once in a bulk mov
 */
