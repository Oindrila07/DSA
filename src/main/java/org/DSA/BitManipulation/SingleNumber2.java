package org.DSA.BitManipulation;

import java.util.Arrays;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int res=0, bitIndex=0;
        while(bitIndex<=31){
            int countIthBit=0;
            for(int i=0;i<nums.length;i++){
                if((nums[i] & (1<<bitIndex))!=0)//we know how to check if the set bit at ith position
                    countIthBit++;
            }
            if(countIthBit%3==1){
                res=res | (1<<bitIndex);//this sets the bit at the correct bitIndex location
            }
            bitIndex++;
        }
        return res;
    }
}

/*
Intuition:
----------
=> This is based on this idea:
1) Count the number of set bits at every bit position for all the numbers(0 to 31)
2) if the count%3 == 1, that means, my answer variable also has a set bit at the given bitIndex position

TC: O(n*32)
SC: O(1)
 */


class SingleNumber2BetterPartTwo {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res=-1;
        for(int i=1;i<nums.length;i+=3){
            if(nums[i]!=nums[i-1]){
                res=nums[i-1];
                break;
            }
        }
        return res==-1?nums[nums.length-1]:res;
    }
}

/*
TC: O(nlogn)

Intuition:
----------
1) After soring all the numbers will appear in cluster
2) So, if a number is same as its previous, then it can't be the single number
3) if at some point, the ith number doesn't match the [i-1]th number, then [i-1]th number is the single number
4) edge case: if this condition is not met throughout all the elements of the array, then the last number is def the answer
 */