package org.DSA.BinarySearch;

public class PainterPartition {
    public int minTime(int[] arr, int k) {
        // code here
        int low=arr[0], high=arr[0], res=-1;

        for(int i=1;i<arr.length;i++){
            low=Math.max(arr[i],low);
            high+=arr[i];
        }

        if(k==1)return high;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(ifPossible(arr,mid,k)){
                high=mid-1;
                res=mid;
            }
            else low=mid+1;
        }

        return res;
    }

    private boolean ifPossible(int[] arr, int time, int k){
        int count=1, sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            if(sum>time){
                count++;
                sum=arr[i];
            }
        }

        return count<=k;
    }
}

class PainterPartitionMain{
    public static void main(String[] args) {
        int[] arr={5, 10, 30, 20, 15};
        int k=3;

        System.out.println(new PainterPartition().minTime(arr,k));
    }
}
