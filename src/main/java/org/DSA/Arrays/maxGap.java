package org.DSA.Arrays;

import java.util.Arrays;

public class maxGap {
    public static void main(String[] args) {
        int[] nums={21,9,25,3,37,43,49,29};
        System.out.println(new Solution().maximumGap(nums));
    }
}
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length==1)return 0;

        int min=Integer.MAX_VALUE, max=-1;

        //finding the min and max of the array:
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }

        if(nums.length==2)return max-min;

        //calculating the bucket size using the formula: (max-min)/(n-1)
        int bucketSize=(int)Math.ceil((double)((max-min)/(nums.length-1)));

        //creating two buckets of length n-1 to store n-2 (except min and max) values
        //these buckets should only store the minimum and maximums of each bucket range
        int[] bucketMin=new int[nums.length-1];
        int[] bucketMax=new int[nums.length-1];

        Arrays.fill(bucketMin,Integer.MAX_VALUE);
        Arrays.fill(bucketMax,-1);

        //populating the buckets to only store min and max of each bucket range
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max || nums[i]==min)continue;
            int bucketInd=Math.min((nums[i]-min)/bucketSize, nums.length-2);// calculating bucket index
            bucketMin[bucketInd]=Math.min(nums[i],bucketMin[bucketInd]);
            bucketMax[bucketInd]=Math.max(nums[i],bucketMax[bucketInd]);
        }

        int maxGap=0;
        int previous=min;//previous holds the previous max value
        //because range starts from min

        for(int i=0;i<nums.length-1;i++){
            if(bucketMax[i]==-1)continue;//empty bucket
            maxGap=Math.max(maxGap, bucketMin[i]-previous);
            previous=bucketMax[i];//keep updating previous with the current max value
        }

        maxGap=Math.max(maxGap, max-previous);//final calculation till max

        return maxGap;
    }
}
/*Intuition:
------------
Let's go step by step to explain the approach, walk through the code, and finally dry-run it with the example:

java
Copy
Edit
int[] nums = {21, 9, 25, 3, 37, 43, 49, 29};
✅ Goal:
Find the maximum gap between any two adjacent elements in the sorted version of the array, but without fully sorting it.

✅ Approach: (Bucket Sort Inspired)
This is a linear time algorithm based on the Pigeonhole Principle.

Idea:
If we divide the range [min, max] into n - 1 buckets, and each bucket only stores the min and max, the maximum adjacent gap must be between buckets (not inside a bucket).

✨ Steps:
Find min and max of the array.

Calculate bucket size using:

arduino
Copy
Edit
bucketSize = ceil((max - min) / (n - 1))
Create n - 1 buckets:

One array for bucketMin (initially Integer.MAX_VALUE)

One array for bucketMax (initially Integer.MIN_VALUE)

Put each number (excluding min & max) in the appropriate bucket.

Traverse buckets to compute max gap between current bucket’s min and previous bucket’s max.


=> What is pigeonhole principle?

The Pigeonhole Principle is a simple but powerful concept in combinatorics. It states:

🐦 Pigeonhole Principle (Basic Form)
If you have more items than containers to put them in, at least one container must hold more than one item.

📌 Example:
If you put 11 socks into 10 drawers, at least one drawer will have more than one sock.


 */
