package org.DSA.HashMap;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> hash=new HashMap<>();
        int sum=0, len=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k)len=i+1;
            else if(hash.containsKey(sum-k)){
                len=Math.max(len,i-hash.get(sum-k));
            }
            if(!hash.containsKey(sum))
                hash.put(sum,i);
        }

        return len;
    }
}
