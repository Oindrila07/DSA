package org.DSA.HashMap;

import java.util.HashMap;

public class LargestSubarrayWith0sAnd1s {
    public int maxLen(int[] arr) {
        // Your code here
        HashMap<Integer,Integer> hash=new HashMap<>();
        int sum=0, len=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i]==0?-1:1;
            if(sum==0)len=i+1;
            else if(hash.containsKey(sum)){
                len=Math.max(len,i-hash.get(sum));
            }
            if(!hash.containsKey(sum)){
                hash.put(sum,i);
            }
        }

        return len;
    }
}

/*
Intuition and Approach:
-----------------------
=> If we consider every 0 as -1, then this problem become same as the longest subarray with 0 sum problem.
=> We traverse the array and compute the prefix sum
    - If current prefix sum == 0, it means that subarray from index (0) till present index has equal number of 0's and 1's.
    - If we encounter a prefix sum value which we have already encountered before, which means that subarray from the previous index+1 till the present index has equal number of 0's and 1's as they give a cumulative sum of 0.
 */