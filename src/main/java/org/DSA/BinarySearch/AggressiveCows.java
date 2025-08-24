package org.DSA.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);

        int low=1, high=stalls[stalls.length-1]-stalls[0], res=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(canBePlaced(stalls,mid,k)){
                low=mid+1;
                res=mid;
            }
            else high=mid-1;//count is less, so decrease
        }

        return res;
    }

    private boolean canBePlaced(int[] stalls, int dist, int cows){
        int lastPlaced=stalls[0], count=1;

        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastPlaced>=dist){
                count++;
                lastPlaced=stalls[i];
            }
        }

        return count>=cows;
    }
}

class AggressiveCowsMain{
    public static void main(String[] args) {
        int[] arr={2, 12, 11, 3, 26, 7};
        System.out.println(new AggressiveCows().aggressiveCows(arr,5));
    }
}
