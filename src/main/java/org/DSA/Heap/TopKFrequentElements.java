package org.DSA.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        Queue<PairCount> queue=new PriorityQueue<>((a, b)->b.count-a.count);
        for(Map.Entry e:hash.entrySet()){
            queue.add(new PairCount((Integer)e.getKey(), (Integer)e.getValue()));
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=queue.poll().element;
        }
        return res;
    }
}

class PairCount{
    int element;
    int count;
    PairCount(int element, int count){
        this.element=element;
        this.count=count;
    }
}