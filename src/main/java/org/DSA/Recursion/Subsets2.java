package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list=new ArrayList<>();

        generateSubsets(list, new ArrayList<>(), nums, 0);

        return list;
    }

    private void generateSubsets(List<List<Integer>> list, List<Integer> res, int[] nums, int index){
        if(index==nums.length){
            list.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        generateSubsets(list,res,nums,index+1);

        while((index+1)<nums.length && nums[index]==nums[index+1]){
            index++;
        }

        res.remove(res.size()-1);
        generateSubsets(list,res,nums,index+1);
    }
}
class Subsets2Main{
    public static void main(String[] args) {
        List<List<Integer>> list=new Subsets2().subsetsWithDup(new int[]{1,2,2});
        System.out.println(list.toString());
    }
}

/*
Intuition:

 */