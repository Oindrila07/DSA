package org.DSA.HashMap;

import java.util.HashSet;

public class LongestBalancedSubarray {
    public int longestBalanced(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> even=new HashSet<>();
            HashSet<Integer> odd=new HashSet<>();
            for(int j=i;j<nums.length;j++){
                int num=nums[j];
                if(num%2==0){
                    even.add(num);
                }
                else {
                    odd.add(num);
                }
                int len=j-i+1;
                if((len+(nums.length-j-1))<=res)break;
                if(even.size()==odd.size()){
                    res=Math.max(res,len);
                }
            }
        }
        return res;
    }
}
