package org.DSA.String;

import java.util.Arrays;
import java.util.HashMap;

public class SortByFrequency {
    public String frequencySort(String s) {
        Character[] characters=new Character[s.length()];

        for(int i=0;i<s.length();i++){
            characters[i]=s.charAt(i);
        }

        HashMap<Character,Integer> hash=new HashMap<>();

        for(Character c:characters){
            hash.put(c,hash.getOrDefault(c,0)+1);
        }

        Arrays.sort(characters,(a, b)->{
            int freq1=hash.get(a), freq2=hash.get(b);
            if(freq1!=freq2)return freq2-freq1;
            return a-b;
        });

        char[] charArray=new char[s.length()];

        for(int i=0;i<charArray.length;i++){
            charArray[i]=characters[i];
        }

        return new String(charArray);
    }

    public static void main(String[] args) {

    }
}
