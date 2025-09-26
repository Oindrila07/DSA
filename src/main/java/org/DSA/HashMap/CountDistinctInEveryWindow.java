package org.DSA.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctInEveryWindow {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> hash=new HashMap<>();

        for(int i=0;i<k;i++){
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }
        list.add(hash.size());
        for(int i=k;i<arr.length;i++){
            hash.put(arr[i-k],hash.get(arr[i-k])-1);
            if(hash.get(arr[i-k])==0)hash.remove(arr[i-k]);
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
            list.add(hash.size());
        }

        return list;
    }
}
