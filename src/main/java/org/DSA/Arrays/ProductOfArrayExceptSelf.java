package org.DSA.Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int product=1, zeroes=0, idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroes++;
                idx=i;
                continue;
            }
            product*=nums[i];
        }
        if(zeroes>0){
            Arrays.fill(res,0);
            if(zeroes==1)res[idx]=product;
            return res;
        }
        for(int i=0;i<nums.length;i++){
            res[i]=product/nums[i];
        }
        return res;
    }
}
