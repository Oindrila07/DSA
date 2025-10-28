package org.DSA.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class NearlySorted {

    //Brute Force: TC = O(nlogn), SC = O(n)
    public void nearlySorted(int[] arr, int k) {
        // code here
        Queue<Integer> queue=new PriorityQueue<>();
        for(int num:arr){
            queue.add(num);
        }
        int n=arr.length;
        for(int i=0;i<n;i++){
            arr[i]=queue.poll();
        }
    }

    //Optimal: TC = O(nlogk), SC = O(k)
    public void nearlySortedOptimal(int[] arr, int k) {
        // code here
        Queue<Integer> queue=new PriorityQueue<>();
        // Pushing first k elements in queue
        for(int i=0;i<k;i++){
            queue.add(arr[i]);
        }
        int n=arr.length, i;
        // Size becomes k+1 so pop it
        // and add minimum element in (i-k) index
        for(i=k;i<n;i++){
            queue.add(arr[i]);
            arr[i-k]=queue.poll();
        }
        // Putting remaining elements in array
        while(!queue.isEmpty()){
            arr[i-k]=queue.poll();
            i++;
        }
    }
}

/*
Intuition:
----------
n this array, every element is at most k positions away from its correct spot.
This means the element at index i could be anywhere between i - k and i + k in the sorted array.
If we start placing the correct elements from left to right, then the element for the current position must be within the next
k+1 elements.
For these next k+1 elements, the best element to place at index i in the sorted array is the minimum element.
Therefore, the problem reduces to finding the minimum element in a window of size k+1 for each position.
To do this efficiently, we can use a min-heap, which allows us to quickly extract the minimum
and insert the next element as we move through the array.
 */