package org.DSA.TwoPointers;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            HashMap<Integer,Integer> hash=new HashMap<>();
            for(int j=i+1;j<nums.length;j++){
                int sum=-(nums[i]+nums[j]);
                if(hash.containsKey(sum)){
                    List<Integer> temp= Arrays.asList(nums[i],sum,nums[j]);
                    Collections.sort(temp);
                    set.add(temp);
                }
                hash.put(nums[j],j);
            }
        }
        return new ArrayList<>(set);
    }
}
