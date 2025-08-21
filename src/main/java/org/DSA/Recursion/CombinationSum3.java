package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();

        if(n<k)return list;

        generate(list, new ArrayList<Integer>(), k, n, 1, 0);

        return list;
    }

    private void generate(List<List<Integer>> list, List<Integer> res, int k, int n, int start, int sum){
        if(res.size()==k){
            if(sum==n){
                list.add(new ArrayList<>(res));
            }
            return;
        }

        for(int i=start;i<=9;i++){
            res.add(i);
            generate(list,res,k,n,i+1,sum+i);
            res.remove(res.size()-1);
        }
    }
}

class CombinationSumMain3{
    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3,9));
    }
}
