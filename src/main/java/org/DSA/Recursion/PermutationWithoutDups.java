package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithoutDups {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();

        generatePermutation(list, new ArrayList<>(), nums, new boolean[nums.length]);

        return list;
    }

    private void generatePermutation(List<List<Integer>> list, List<Integer> res, int[] nums, boolean[] visited){
        if(res.size()==nums.length){
            list.add(new ArrayList<>(res));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                res.add(nums[i]);
                visited[i]=true;
                generatePermutation(list,res,nums,visited);
                res.remove(res.size()-1);
                visited[i]=false;
            }
        }
    }
}

class permutationWithoutDupsMain{
    public static void main(String[] args) {
        System.out.println(new PermutationWithoutDups().permute(new int[]{1,2,3}));
    }
}
