package org.DSA.BinarySearch;

public class AllocateMinimumPages {
    public int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length)return -1;

        int low=arr[0], high=0, res=Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(arr,mid,k)){
                high=mid-1;
                res=mid;
            }
            else low=mid+1;
        }

        return res;
    }

    private boolean check(int[] arr, int pages, int students){
        int count=1, sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            if(sum>pages){
                count++;
                sum=arr[i];
            }
        }

        return count<=students;
    }
}

class AllocateMinPagesMain{
    public static void main(String[] args) {
        int[] arr = {13, 31, 37, 45, 46, 54, 55, 63, 73, 84, 85};
        int students = 9;

        System.out.println(new AllocateMinimumPages().findPages(arr, students));
    }
}

/*
Approach:
---------
=> Minimum pages to allocate a student is to assign him the heaviest book = max (pages)
=> Maximum pages to be assigned to a student is to assign him all the books = sum (pages)
Then perform BS!
 */