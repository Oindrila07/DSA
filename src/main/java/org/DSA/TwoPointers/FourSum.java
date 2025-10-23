package org.DSA.TwoPointers;

import java.util.*;

public class FourSum {

    //FourSum solution: Brute Force
    public List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length<4)return list;
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                HashMap<Integer,Integer> hash=new HashMap<>();
                for(int k=j+1;k<nums.length;k++){
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[k];
                    if(sum>Integer.MAX_VALUE || sum<Integer.MIN_VALUE)break;
                    if(hash.containsKey(target-(int)sum)){
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k],target-(int)sum);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    hash.put(nums[k],k);
                }
            }
        }
        return new ArrayList<>(set);
    }


    //FourSum Optimal:
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<4)return list;
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>(i+1) && nums[j]==nums[j-1])continue;
                int left=j+1, right=nums.length-1;
                while(left<right){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target)right--;
                    else if(sum<target)left++;
                    else{
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1])left++;
                        while(right>left && nums[right]==nums[right+1])right--;
                    }
                }
            }
        }
        return list;
    }
}


/*
Approach (Optimal):
------------------
=> Check Array Length:
First, check if the length of the input array is less than 4. If yes, return an empty array or list because we can't form a valid group of 4 elements.

=> Sort the Array:
Sort the array in ascending order. Sorting helps us manage duplicates and makes it easier to work with combinations.

=> Find Unique Combinations:
Use a loop to go through the array and look for groups of 4 numbers. While looping, skip any duplicates by using an if condition to check if the current number is the same as the previous one.

=> Store Results:
For each valid group of 4 numbers without duplicates, add it to the result list.

=> Return the Result:
After completing the loops, return the list of unique combinations.
 */
