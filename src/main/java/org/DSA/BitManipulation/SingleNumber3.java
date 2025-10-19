package org.DSA.BitManipulation;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int result=0;
        for(int num:nums){
            result^=num;
        }
        int rightMost=(result&(result-1))^result;
        int bucket1=0, bucket2=0;
        for(int num:nums){
            if((num & rightMost)!=0){
                bucket1^=num;
            }
            else bucket2^=num;
        }
        return new int[]{bucket1,bucket2};
    }
}

/*
Intuition:
----------
=> Take xor of all the numbers
=> The result would be the xor between the two unique numbers
=> Next step is to find the rightMost set bit of the result => We know to remove the last set bit we do num&(num-1). Now, after doing that
if we again perform a xor with the original number (result in this case) then we will get the last set bit back.
=> Now based on this last set bit, we will split the nums array elements into two diff buckets:
    -> if (nums[i] & rightMost) !=0, that means the last set bit is same for both, then put it into bucket 1
    -> if above condition is not met, that means, last set bit of 'rightMost' and nums[i] is diff, so put it in bucket 2
=> Keep xoring the numbers, so that the same ones will get nullified
=> At the end, both the buckets will only have the unique numbers left in them
 */