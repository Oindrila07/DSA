package org.DSA.Arrays;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        Integer[] res=Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(res,(a,b)->{
            int count1=hash.get(a);
            int count2=hash.get(b);
            if(count1==count2)return b-a;
            return count1-count2;
        });
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }
        return nums;
    }
}
