package org.DSA.Sorting;

public class CountInversions {
    static int inversionCount(int arr[]) {
        // Code Here
        int count=countInv(arr,0,arr.length-1);
        return count;
    }

    private static int countInv(int[] arr, int low, int high){
        int count=0;

        if(low<high){
            int mid=low+(high-low)/2;
            count+=countInv(arr,low,mid);
            count+=countInv(arr,mid+1,high);
            count+=merge(arr,low,mid,high);
        }

        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high){
        int[] left=new int[mid-low+1];
        int[] right=new int[high-mid];

        for(int i=0;i<left.length;i++){
            left[i]=arr[i+low];
        }

        for(int i=0;i<right.length;i++){
            right[i]=arr[mid+1+i];
        }

        int i=0, j=0, count=0;

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[low++]=left[i++];
            }
            else{
                count+=left.length-i;
                arr[low++]=right[j++];
            }
        }

        while(i<left.length){
            arr[low++]=left[i++];
        }

        while(j<right.length){
            arr[low++]=right[j++];
        }

        return count;
    }
}
