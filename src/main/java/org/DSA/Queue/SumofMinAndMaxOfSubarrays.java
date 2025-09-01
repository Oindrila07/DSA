package org.DSA.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumofMinAndMaxOfSubarrays {
    public int sumMinMax(int[] arr, int k){
        Deque<Integer> qmin=new ArrayDeque<>();
        Deque<Integer> qmax=new ArrayDeque<>();

        for(int i=0;i<k;i++){
            while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.offerLast(i);
            while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[i]){
                qmin.pollLast();
            }
            qmin.offerLast(i);
        }

        int sum=arr[qmin.peekFirst()]+arr[qmax.peekFirst()];

        for(int i=k;i<arr.length;i++){
            while(!qmax.isEmpty() && qmax.peekFirst()<=i-k){
                qmax.pollFirst();
            }

            while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.offerLast(i);

            while(!qmin.isEmpty() && qmin.peekFirst()<=i-k){
                qmin.pollFirst();
            }
            while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[i]){
                qmin.pollLast();
            }
            qmin.offerLast(i);

            sum+=arr[qmin.peekFirst()]+arr[qmax.peekFirst()];
        }

        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[] arr={2, 5, -1, 7, -3, -1, -2};
        int k=4;
        System.out.println(new SumofMinAndMaxOfSubarrays().sumMinMax(arr,k));
    }
}