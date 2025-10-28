package org.DSA.Heap;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hash=new HashMap<>();
        for(String word:words){
            hash.put(word,hash.getOrDefault(word,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.count!=b.count)return b.count-a.count;
            return a.word.compareTo(b.word);
        });
        for(Map.Entry e:hash.entrySet()){
            Pair pair=new Pair((String)e.getKey(),(Integer)e.getValue());
            pq.offer(pair);
        }
        List<String> list=new ArrayList<>();
        while(k-->0){
            list.add(pq.poll().word);
        }
        return list;
    }
}

class Pair{
    String word;
    int count;
    Pair(String word, int count){
        this.word=word;
        this.count=count;
    }
}
