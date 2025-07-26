package org.DSA.Arrays;

public class maxCircularSubarraySum {
    public static int maxCircularSum(int arr[]) {
        // code here
        int maxSum=maxSubarraySum(arr);

        if(maxSum<0)return maxSum; // because if all the values are negative, after calculating total sum
        // and circular sum, they will be same and nullify each other, so circular sum will be 0,
        // we dont need the output as 0 when all values are negative, we need the max sum for negatives only

        int total=0;

        for(int i=0;i<arr.length;i++){
            total+=arr[i];
            arr[i]=-arr[i];
        }

        int circularMaxSum=total+maxSubarraySum(arr);

        return Math.max(circularMaxSum, maxSum);
    }

    private static int maxSubarraySum(int[] arr){
        int currSum=0, maxSum=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<arr[i])currSum=arr[i];
            maxSum=Math.max(maxSum,currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr={10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println(maxCircularSum(arr));
    }
}
