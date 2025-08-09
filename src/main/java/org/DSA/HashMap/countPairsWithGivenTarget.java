package org.DSA.HashMap;

import java.util.HashMap;

public class countPairsWithGivenTarget {
    public static void main(String[] args) {
        int[] arr={-1, 1, 5, 5, 7};
        System.out.println(countPairs(arr,6));
    }
    static int countPairs(int arr[], int target) {
        // Complete the function
        int count=0;

        HashMap<Integer,Integer> hash=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hash.containsKey(target-arr[i])){
                count+=hash.get(target-arr[i]);
            }
            hash.put(arr[i],hash.getOrDefault(arr[i],0)+1);
        }

        return count;
    }
}
