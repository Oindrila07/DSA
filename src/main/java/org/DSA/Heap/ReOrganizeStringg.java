package org.DSA.Heap;

import java.util.PriorityQueue;

public class ReOrganizeStringg {
    public String reorganizeString(String s) {
        PriorityQueue<FreqPair> pq=new PriorityQueue<>((a, b)->b.count-a.count);
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.offer(new FreqPair((char)(i+'a'),freq[i]));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(pq.size()>1){
            FreqPair p1=pq.poll();
            FreqPair p2=pq.poll();
            char c1=p1.value, c2=p2.value;
            int count1=p1.count-1, count2=p2.count-1;
            sb.append(c1);
            sb.append(c2);
            if(count1>0)pq.offer(new FreqPair(c1,count1));
            if(count2>0)pq.offer(new FreqPair(c2,count2));
        }
        if(pq.size()==1){
            FreqPair p=pq.poll();
            if(p.count>1)return "";
            sb.append(p.value);
        }
        return sb.toString();
    }
}

class FreqPair{
    char value;
    int count;
    FreqPair(char value, int count){
        this.value=value;
        this.count=count;
    }
}

/*
Approach: Priority Queue Approach
----------------------------------
Key Data Structures
Max Heap: Used for storing characters sorted by their frequency in descending order.

Initialization:
---------------
Count the frequency of each character in the string.
Populate the max heap with these frequencies.

Processing Each Character:
--------------------------
Pop the top two characters from the max heap (i.e., the ones with the highest frequency).
Append these two characters to the result string.
Decrement their frequencies and re-insert them back into the max heap.
If only one character remains in the heap, make sure it doesn't exceed half of the string length, otherwise, return an empty string.
Wrap-up:

If there's a single remaining character with a frequency of 1, append it to the result.
Join all the characters to return the final reorganized string.
Example:
Given the input "aab":

Max heap after initialization: [(2, 'a'), (1, 'b')]
Result after first iteration: "ab"
Wrap-up: Result is "aba"
 */