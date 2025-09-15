package org.DSA.SlidingWindow;

import java.util.HashMap;

public class CountSubstringsWithKDistinct {
    public int countSubstr(String s, int k) {
        //  code here
        return countSubstrings(s,k)-countSubstrings(s,k-1);
    }

    private int countSubstrings(String s, int k){
        if(k==0)return 0;
        int count=0, i=0, j=0;
        HashMap<Character,Integer> hash=new HashMap<>();

        while(j<s.length()){
            char ch=s.charAt(j);
            hash.put(ch,hash.getOrDefault(ch,0)+1);

            while(i<s.length() && hash.size()>k){
                char c=s.charAt(i);
                hash.put(c,hash.get(c)-1);
                if(hash.get(c)==0){
                    hash.remove(c);
                }
                i++;
            }

            count+=(j-i+1);
            j++;
        }

        return count;
    }
}
