package org.DSA.HashMap;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    int maxLength(int arr[]) {
        // code here
        HashMap<Integer,Integer> hash=new HashMap<>();
        int sum=0, len=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==0)len=i+1;
            else if(hash.containsKey(sum)){
                len=Math.max(len,i-hash.get(sum));
            }
            if(!hash.containsKey(sum)){
                hash.put(sum,i);
            }
        }

        return len;
    }
}
