package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();

        generate(list,new ArrayList<Integer>(), candidates, target, 0);

        return list;
    }

    private void generate(List<List<Integer>> list, List<Integer> res, int[] candidates, int target, int index){
        if(target==0){
            list.add(new ArrayList<>(res));
            return;
        }
        if(target<0)return;

        //i=index ensures that, I do not go back and look for the same combinations that have already been considered
        for(int i=index;i<candidates.length;i++){
            res.add(candidates[i]);
            generate(list,res,candidates,target-candidates[i],i);
            res.remove(res.size()-1);
        }
    }
}

class CombinationSumMain1{
    public static void main(String[] args) {
        System.out.println(new CombinationSum1().combinationSum(new int[]{8,7,4,3},11));
    }
}
