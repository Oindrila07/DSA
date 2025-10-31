package org.DSA.Heap;

import java.util.PriorityQueue;

public class NthSuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(1);
        int num=1, idx=0;
        while(idx++<n){
            num=pq.poll();
            //Remove Similar Duplicates
            while(!pq.isEmpty() && pq.peek().equals(num)){
                pq.poll();
            }
            for(int prime:primes){
                if(num>Integer.MAX_VALUE/prime){
                    break;
                }
                pq.offer(num*prime);
            }
        }
        return (int)num;
    }
}
