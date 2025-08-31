package org.DSA.Stack;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimums {
    final int mod=1000000007;
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack=new Stack<>();

        Arrays.fill(left,-1);
        Arrays.fill(right,n);

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek()<i){
                left[i]=stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek()>i){
                right[i]=stack.peek();
            }

            stack.push(i);
        }

        long sum=0;

        for(int i=0;i<n;i++){
            long count=(long)(i-left[i])*(right[i]-i)%mod*arr[i]%mod;
            sum=(sum+count)%mod;
        }

        return (int)sum;
    }
}

class SumOfSubarrayMinsMain {
    public static void main(String[] args) {
        int[] arr={71,55,82,55};

        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(arr));
    }
}

/*
Key Idea: "Contribution of each element" and then finding in how many of those it was the smallest

To know where arr[i] is the minimum, we find:
Left boundary (previous smaller element):
=> The nearest element strictly smaller than arr[i] on the left.
=> If none, assume -1.
=> This tells us how far we can extend left before encountering a smaller element.

Right boundary (next smaller element):
=> The nearest element smaller OR equal to arr[i] on the right.
=> If none, assume n.
=> This tells us how far we can extend right before encountering a smaller/equal element.

Why use > on left and >= on right?:
-----------------------------------
This asymmetry avoids double-counting subarrays when duplicate values exist.

=> Left pass (>): ensures each element claims responsibility only until a strictly smaller element.
=> Right pass (>=): ensures in case of duplicates, only the first occurrence on the right boundary stops the expansion.

This convention ensures uniqueness.
 */
