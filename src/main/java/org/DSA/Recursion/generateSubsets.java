package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class generateSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();

        generateSubsets(list,new ArrayList<>(), 0, nums);

        return list;
    }

    private void generateSubsets(List<List<Integer>> list, List<Integer> res, int index, int[] nums){
        if(index==nums.length){
            list.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[index]);
        generateSubsets(list,res,index+1,nums);

        res.remove(res.size()-1);
        generateSubsets(list,res,index+1,nums);
    }
}

class generateSubsetsMain{
    public static void main(String[] args) {
        List<List<Integer>> list=new ArrayList<>();

        int[] nums={1,2,3};

        list=new generateSubsets().subsets(nums);
        System.out.println(list.toString());
    }
}
