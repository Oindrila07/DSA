package org.DSA.HashMap;

import java.util.HashSet;

public class SubarrayWith0Sum {
    static boolean findsum(int arr[]) {
        // Your code here
        HashSet<Integer> hash=new HashSet<>();
        int sum=0;
        hash.add(sum);

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hash.contains(sum)){
                return true;
            }
            hash.add(sum);
        }

        return false;
    }
}
