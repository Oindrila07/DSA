package org.DSA.Heap;

import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k)pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k)pq.poll();
        return pq.peek();
    }

    private void populate(PriorityQueue<Integer> pq, int[] nums){
        for(int num:nums){
            pq.offer(num);
        }
    }
}

/*
Intuition:
----------
The KthLargest class is designed to efficiently find the kth largest element in a stream of integers.
The challenge here is to maintain the k largest elements seen so far, so that when a new element is added,
the class can quickly determine the kth largest element.

Approach:
---------
Min-Heap (Priority Queue):
The key idea is to use a min-heap (priority queue) to maintain the k largest elements seen so far.
A min-heap is a binary tree where the root node is the smallest element. This property allows us to efficiently get the smallest element of the heap in constant time.

=> Initialization:
------------------
During the initialization (KthLargest constructor), we iterate through the given list of numbers (nums).
Each number is added to the min-heap (pq), and if the heap size exceeds k, we remove the smallest element. This ensures that the heap always contains exactly k elements, representing the k largest elements seen so far.

=> Adding New Elements:
-----------------------
When a new value is added using the add method, we insert this value into the min-heap.
Again, if the heap size exceeds k, we remove the smallest element to maintain the heap's size.
After adding the new value, the root of the heap (pq.top()) is the kth largest element, as the heap contains the largest k elements, with the smallest of these being the kth largest overall.
 */