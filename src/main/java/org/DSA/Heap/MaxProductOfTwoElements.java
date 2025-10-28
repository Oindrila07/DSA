package org.DSA.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxProductOfTwoElements {
    public int maxProduct(int[] nums) {
        Queue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            heap.offer(num);
        }
        int a=heap.poll();
        int b=heap.poll();
        return (a-1)*(b-1);
    }
}
