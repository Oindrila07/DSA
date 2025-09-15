package org.DSA.Sorting;

import java.util.Arrays;

public class SegregateEvenAndOdds {
    void segregateEvenOdd(int arr[]) {
        // code here
        int even=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                int temp=arr[i];
                arr[i]=arr[even];
                arr[even]=temp;
                even++;
            }
        }

        if(even==arr.length)return;

        Arrays.sort(arr,0,even);
        Arrays.sort(arr,even,arr.length);
    }
}
