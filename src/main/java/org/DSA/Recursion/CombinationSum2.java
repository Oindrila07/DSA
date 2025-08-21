package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> list=new ArrayList<>();

        generate(list,new ArrayList<Integer>(),candidates,new boolean[candidates.length],0,target);

        return list;
    }

    private void generate(List<List<Integer>> list, List<Integer> res, int[] candidates, boolean[] visited, int index, int target){
        if(target==0){
            list.add(new ArrayList<>(res));
            return;
        }

        if(target<0)return;

        for(int i=index;i<candidates.length;i++){
            if(i>0 && candidates[i]==candidates[i-1] && !visited[i-1])continue;
            if(!visited[i]){
                res.add(candidates[i]);
                visited[i]=true;
                generate(list,res,candidates,visited,i+1,target-candidates[i]);
                res.remove(res.size()-1);
                visited[i]=false;
            }
        }
    }
}

class CombinationSumMain2{
    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        System.out.println(new CombinationSum2().combinationSum2(candidates,8));
    }
}
