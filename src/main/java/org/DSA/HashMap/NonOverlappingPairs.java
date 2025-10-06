package org.DSA.HashMap;

import java.util.HashMap;

class NonOverlappingPairs {
    public void findNonOverlappingPairs(int[] nums) {
        HashMap<Integer,Pair> hash=new HashMap<>();
        boolean found=false;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j)continue;
                int sum=nums[i]+nums[j];
                if(hash.containsKey(sum)){
                    Pair pair=hash.get(sum);
                    if(i!=pair.i && i!=pair.j && j!=pair.i && j!=pair.j){
                        System.out.println("Pair First: ("+pair.i+", "+pair.j+")");
                        System.out.println("Pair Second: ("+i+", "+j+")");
                        found=true;
                        break;
                    }
                }
                if(!hash.containsKey(sum))hash.put(sum,new Pair(i,j));
            }
            if(found)break;
        }
        if(!found){
            System.out.println("No non-overlapping pairs exist in the array");
        }
    }
}
class Pair {
    int i;
    int j;
    Pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}

class NonOverlappingPairsMain {
    public static void main(String[] args) {
        int[] nums={8, 4, 7, 8, 4};
        new NonOverlappingPairs().findNonOverlappingPairs(nums);
    }
}