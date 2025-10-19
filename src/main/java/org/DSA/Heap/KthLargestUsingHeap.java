package org.DSA.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestUsingHeap {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }
        while(k-->1){
            pq.poll();
        }
        return pq.peek();
    }
}
