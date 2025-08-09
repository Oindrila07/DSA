package org.DSA.TwoPointers;

import java.util.Arrays;

public class TwoSum {
    static boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);

        int i=0, j=arr.length-1;
        int sum=arr[i]+arr[j];

        while(i<j){
            if(sum==target)return true;
            else if(sum>target)j--;
            else i++;
            sum=arr[i]+arr[j];
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
