package org.DSA.Heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a, b)->b-a);

        for(int i=0;i<stones.length;i++){
            heap.offer(stones[i]);
        }

        while(heap.size()>1){
            int x=heap.poll();
            int y=heap.poll();

            if(Math.abs(x-y)>0)heap.offer(Math.abs(x-y));
        }

        if(heap.size()>0)return heap.peek();
        return 0;
    }
}

class LastStoneWeightMain {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(new LastStoneWeight().lastStoneWeight(stones));
    }
}
