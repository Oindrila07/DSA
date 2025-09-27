package org.DSA.HashMap;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash=new HashSet<>();
        int res=0;
        for(int num:nums){
            hash.add(num);
        }
        for(int num:hash){
            if(hash.contains(num-1))continue;
            int x=num, count=1;
            while(hash.contains(x+1)){
                count++;
                x++;
            }
            res=Math.max(res,count);
        }
        return res;
    }
}

/*
Note: Looping through the hashset, makes the code much faster! Looping through array is also possible.
 */