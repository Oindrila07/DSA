package org.DSA.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Triplet> heap=new PriorityQueue<>((a, b)->a.value-b.value);
        for(int[] arr:points){
            int x=arr[0], y=arr[1];
            int value=x*x+y*y;
            heap.add(new Triplet(x,y,value));
        }
        int[][] res=new int[k][2];
        for(int i=0;i<k;i++){
            Triplet t=heap.poll();
            res[i]=new int[]{t.x,t.y};
        }
        return res;
    }
}

class Triplet{
    int x;
    int y;
    int value;
    Triplet(int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
}