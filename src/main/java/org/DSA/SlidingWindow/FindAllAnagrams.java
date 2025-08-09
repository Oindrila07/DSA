package org.DSA.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length())return new ArrayList<>();

        int[] freq1=new int[26];
        int[] freq2=new int[26];

        for(int i=0;i<p.length();i++){
            freq1[p.charAt(i)-'a']++;
            freq2[s.charAt(i)-'a']++;
        }

        List<Integer> list=new ArrayList<>();

        int i=0, j=p.length();

        while(j<s.length()){
            if(checkIfAnagrams(freq1,freq2)){
                list.add(i);
            }

            freq2[s.charAt(i)-'a']--;
            freq2[s.charAt(j)-'a']++;
            i++;
            j++;
        }

        if(checkIfAnagrams(freq1,freq2))list.add(i);

        return list;
    }

    private static boolean checkIfAnagrams(int[] freq1, int[] freq2){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i])return false;
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();

        String s="abab";
        String p="ab";

        list=findAnagrams(s,p);

        System.out.println(list.toString());
    }
}
