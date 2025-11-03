package org.DSA.Heap;

import java.util.*;

public class SortArrayByIncreasingFreqUsingHeap {
    public int[] frequencySort(int[] nums) {
        int[] res=new int[nums.length];
        HashMap<Integer,Integer> hash=new HashMap<>();
        PriorityQueue<FreqPairInteger> pq=new PriorityQueue<>((a,b)->{
            if(a.count!=b.count)return a.count-b.count;
            return b.value-a.value;
        });

        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        for(Map.Entry e:hash.entrySet()){
            pq.offer(new FreqPairInteger((int)e.getKey(),(int)e.getValue()));
        }
        int idx=0;
        while(pq.size()>0){
            FreqPairInteger p=pq.poll();
            int count=p.count;
            while(count-->0){
                res[idx++]=p.value;
            }
        }
        return res;
    }
}


class FreqPairInteger{
    int value;
    int count;
    FreqPairInteger(int value, int count){
        this.value=value;
        this.count=count;
    }
}