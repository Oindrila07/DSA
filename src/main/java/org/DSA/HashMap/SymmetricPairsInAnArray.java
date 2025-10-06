package org.DSA.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SymmetricPairsInAnArray {
    public static void main(String[] args) {
        int[][] nums={{5, 8}, {7, 9}, {8, 5}, {9, 7}, {6, 10}};
        System.out.println(findSymmetricPairs(nums));
    }

    private static List<List<Integer>> findSymmetricPairs(int[][] nums){
        List<List<Integer>> list=new ArrayList<>();
        HashMap<List<Integer>,Integer> hash=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> swapped= Arrays.asList(nums[i][0],nums[i][1]);
            swap(swapped);
            hash.put(swapped,i);
        }
        for(int i=0;i<nums.length;i++){
            List<Integer> tempList=Arrays.asList(nums[i][0],nums[i][1]);
            if(hash.containsKey(tempList)){
                Integer idx=hash.get(tempList);
                if(idx!=i){
                    list.add(new ArrayList<>(tempList));
                    swap(tempList);
                    hash.remove(tempList);
                }
            }
        }
        return list;
    }

    private static void swap(List<Integer> nums){
        int temp=nums.get(0);
        nums.set(0,nums.get(1));
        nums.set(1,temp);
    }
}


/*
TC: O(n)
SC: O(n)
 */