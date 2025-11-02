package org.DSA.Heap;

import java.util.PriorityQueue;

public class KWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<MapClass> pq=new PriorityQueue<>((a, b)->{
            if(a.count!=b.count)return a.count-b.count;
            return a.index-b.index;
        });
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0)break;
                count++;
            }
            pq.offer(new MapClass(i,count));
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll().index;
        }
        return res;
    }
}

class MapClass {
    int index;
    int count;
    MapClass(int index, int count){
        this.index=index;
        this.count=count;
    }
}
