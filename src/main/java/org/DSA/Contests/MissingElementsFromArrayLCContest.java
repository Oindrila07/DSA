package org.DSA.Contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingElementsFromArrayLCContest {
    class Solution {
        public List<Integer> findMissingElements(int[] nums) {
            List<Integer> list=new ArrayList<>();
            Set<Integer> set=new HashSet<>();
            int min=100, max=0;
            for(int num:nums){
                min=Math.min(num,min);
                max=Math.max(max,num);
                set.add(num);
            }
            for(int i=min;i<=max;i++){
                if(!set.contains(i)){
                    list.add(i);
                }
            }
            return list;
        }
    }
}
