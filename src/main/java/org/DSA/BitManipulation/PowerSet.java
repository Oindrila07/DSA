package org.DSA.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        int n=nums.length;
        int subsets=(1<<n);//total number of subsets to be generated
        for(int num=0;num<=subsets-1;num++){//traverse all the subsets starting from 0 to subsets-1
            List<Integer> temp=new ArrayList<>();
            for(int bitIndex=0;bitIndex<n;bitIndex++){//traverse all the bitIndexes which is nothing but n
                if((num & (1<<bitIndex))!=0){//check if the ith bit is set or not
                    temp.add(nums[bitIndex]);//if yes, then add the element at the set bit position into the list
                }
            }
            list.add(temp);
        }
        return list;
    }
}
