package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> list=new ArrayList<>();

        generate(nums,list,0,0);

        return list;
    }

    private void generate(int[] nums, List<Integer> list, int sum, int index){
        if(index==nums.length){
            list.add(sum);
            return;
        }

        generate(nums,list,sum+nums[index],index+1);
        generate(nums,list,sum,index+1);
    }
}

class SubsetSumMain{
    public static void main(String[] args) {
        System.out.println(new SubsetSum().subsetSums(new int[]{2,3}));
    }
}
