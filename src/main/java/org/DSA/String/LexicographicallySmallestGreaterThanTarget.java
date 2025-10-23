package org.DSA.String;

import java.util.*;

public class LexicographicallySmallestGreaterThanTarget {
    public String lexGreaterPermutation(String s, String target) {
        TreeMap<Character,Integer> map=new TreeMap<>();
        List<String> possibleAnswers=new ArrayList<>();
        StringBuilder prefix=new StringBuilder();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.higherKey(target.charAt(i))!=null){
                TreeMap<Character, Integer> temp = new TreeMap<>(map);
                Character c=map.higherKey(target.charAt(i));
                StringBuilder str=new StringBuilder(prefix);
                str.append(c);
                temp.put(c,temp.get(c)-1);
                if(temp.get(c)==0){
                    temp.remove(c);
                }
                for(Map.Entry e:temp.entrySet()){
                    for (int k=0;k<(int)e.getValue();k++) {
                        str.append(e.getKey());
                    }
                }
                possibleAnswers.add(str.toString());
            }
            if(map.containsKey(target.charAt(i))){
                prefix.append(target.charAt(i));
                map.put(target.charAt(i),map.get(target.charAt(i))-1);
                if(map.get(target.charAt(i))==0){
                    map.remove(target.charAt(i));
                }
            }
            else break;
        }
        Collections.sort(possibleAnswers);
        return possibleAnswers.size()==0?"":possibleAnswers.get(0);
    }
}


/*
Source: https://www.youtube.com/watch?v=NoY7HC-nWvI&t=565s
 */