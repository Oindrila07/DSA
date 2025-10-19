package org.DSA.HashMap;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2BruteForce {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry e:map.entrySet()){
            if((int)e.getValue()==1)return (int)e.getKey();
        }
        return -1;
    }
}

/*
TC: O(n)
SC: O(n/3+1) => every number appears thrice except 1, and we are just going to store only one occurrence of each number. So, n/3+1. (1=> for the 1 extra number)
 */