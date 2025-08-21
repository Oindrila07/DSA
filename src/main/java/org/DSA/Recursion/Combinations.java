package org.DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list=new ArrayList<>();

        generate(list, new ArrayList<Integer>(), 1, k, n);

        return list;
    }

    private void generate(List<List<Integer>> list, List<Integer> res, int start, int k, int n){
        if(res.size()==k){
            list.add(new ArrayList<>(res));
            return;
        }

        for(int i=start;i<=n;i++){
            res.add(i);
            generate(list,res,i+1,k,n);
            res.remove(res.size()-1);
        }
    }
}

class CombinationsMain{
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4,2));
    }
}
